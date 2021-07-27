package com.maple.admin.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Slf4j // log 사용을 위한 lombok 어노테이션
@Configuration
@EnableBatchProcessing
@EnableScheduling 
@Import({BatchConfig.class})
public class BatchJob {
	
	/**
	 * 1.java class
	 * 2.your need java method
	 * 3.your need java var
	 * 4.you need time
	 * 5.you need local time
	 * 6.you need 
	 * 
	 * 
	 *  
	 */
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private BatchStep step;
	
	@Autowired
    private JobLauncher jobLauncher;
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void updateBannerStat() throws Exception {
		
		log.info(">>> Start Batch updateBannerStat >>> ");
		
		JobParameters param = new JobParametersBuilder().addString("updateBannerStat", String.valueOf(System.currentTimeMillis())).toJobParameters();
		
		JobExecution execution = jobLauncher.run(updateBannerStatJob(), param);
		
		log.info(">>> End Batch updateBannerStat >>> ");
	}
	
	@Bean
	public Job updateBannerStatJob() {
		return jobBuilderFactory.get("updateBannerStatJob")
				.start(step.updateBannerStatStep())
				.build();
				
	}
}
