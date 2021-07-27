package com.maple.admin.job;

import java.util.List;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maple.admin.entity.MainBenner;
import com.maple.admin.entity.QMainBenner;
import com.maple.admin.util.DateUtil;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j // log 사용을 위한 lombok 어노테이션
@Configuration
@EnableBatchProcessing
public class BatchStep {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private JPAQueryFactory queryFactory;
	
	@Bean
	public Step updateBannerStatStep() {
		return stepBuilderFactory.get("updateBannerStatStep")
				.tasklet((contribution, chunkContext) -> {
                    
					QMainBenner banner = QMainBenner.mainBenner;
					
					//오늘날짜 
					String today = DateUtil.todayDate();
					BooleanBuilder startBuilder = new BooleanBuilder();
					startBuilder.and(banner.benner_stardate.goe(today));
					startBuilder.and(banner.banner_restype.eq("RS"));
					
					List<MainBenner> rsBannerList = queryFactory
							.selectFrom(banner)
							.where(startBuilder)
							.fetch();
					
					// start
					for (MainBenner item : rsBannerList) {
						queryFactory.update(banner)
						.set(banner.banner_restype, "OG")
						.where(banner.benner_seq.eq(item.getBenner_seq()))
						.execute();
						
					}
					
					
					//end
					BooleanBuilder endBuilder = new BooleanBuilder();
					endBuilder.and(banner.benner_endate.loe(today));
					endBuilder.and(banner.banner_restype.eq("OG"));
					
					List<MainBenner> ogBannerList = queryFactory
							.selectFrom(banner)
							.where(startBuilder)
							.fetch();
					
					for (MainBenner item : ogBannerList) {
						queryFactory.update(banner)
						.set(banner.banner_restype, "ED")
						.where(banner.benner_seq.eq(item.getBenner_seq()))
						.execute();
						
					}
					
                    return RepeatStatus.FINISHED;
                })
				.build();
	}
}
