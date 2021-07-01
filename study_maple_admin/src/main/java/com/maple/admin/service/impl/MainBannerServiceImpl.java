package com.maple.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maple.admin.dto.MainBannerDto;
import com.maple.admin.dto.MainBannerDto.MainBannerSave;
import com.maple.admin.entity.MainBenner;
import com.maple.admin.entity.QMainBenner;
import com.maple.admin.repositroy.MainBannerRepository;
import com.maple.admin.service.MainBannerService;
import com.maple.admin.util.FileUtil;
import com.maple.admin.util.StringUtil;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class MainBannerServiceImpl implements MainBannerService{

	@Autowired
	private JPAQueryFactory queryFactory;
	
	@Autowired
	private MainBannerRepository bannerRepository;
	
	@Override
	public List<MainBenner> getBannerList() throws Exception {
		QMainBenner banner = QMainBenner.mainBenner;
		
		List<MainBenner> bannerList = queryFactory
				.selectFrom(banner)
				.orderBy(banner.benner_seq.desc())
				.fetch();
		
		return bannerList;
	}

	@Override
	public MainBenner saveBanner(MainBannerDto.MainBannerSave save) throws Exception {
		
		Map<String, Object> uploadFileMap = FileUtil.uploadImage(save.getBenner_image());
		
		MainBenner saveBanner = MainBenner.builder()
				.benner_image(String.valueOf(uploadFileMap.get("savePath")))
				.benner_imagenm(String.valueOf(uploadFileMap.get("imageName")))
				.benner_title(save.getBenner_title())
				.benner_stardate(save.getBenner_stardate())
				.benner_endate(save.getBenner_endate())
				.benner_type(save.getBenner_type())
				.banner_restype(save.getBanner_restype())
		.build();
		
		MainBenner banner = bannerRepository.save(saveBanner);
		
		return banner;
	}

	@Override
	public MainBenner getInfo(Integer bannerNo) throws Exception {
		
		QMainBenner qBanner = QMainBenner.mainBenner;
		
		MainBenner banner = queryFactory
				.selectFrom(qBanner)
				.where(qBanner.benner_seq.eq(bannerNo))
				.orderBy(qBanner.benner_seq.desc())
				.fetchOne();
		
		return banner;
	}

	@Override
	public void updateBanner(MainBannerSave save) throws Exception {
		QMainBenner banner = QMainBenner.mainBenner;
		
		if (StringUtil.isEmpty(save.getImgnm())) {
			Map<String, Object> uploadFileMap = FileUtil.uploadImage(save.getBenner_image());

			queryFactory.update(banner)
				.set(banner.benner_image, String.valueOf(uploadFileMap.get("savePath")))
				.set(banner.benner_imagenm, String.valueOf(uploadFileMap.get("imageName")))
				.set(banner.benner_title, save.getBenner_title())
				.set(banner.benner_stardate, save.getBenner_stardate())
				.set(banner.benner_endate, save.getBenner_endate())
				.set(banner.benner_type, save.getBenner_type())
				.set(banner.banner_restype, save.getBanner_restype())
			.execute();
		
		} else {
			queryFactory.update(banner)
			.set(banner.benner_title, save.getBenner_title())
			.set(banner.benner_stardate, save.getBenner_stardate())
			.set(banner.benner_endate, save.getBenner_endate())
			.set(banner.benner_type, save.getBenner_type())
			.set(banner.banner_restype, save.getBanner_restype())
			.execute();
		}
		
	}

}
