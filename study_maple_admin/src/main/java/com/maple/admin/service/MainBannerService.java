package com.maple.admin.service;

import java.util.List;

import com.maple.admin.dto.MainBannerDto;
import com.maple.admin.entity.MainBenner;

public interface MainBannerService {

	public List<MainBenner> getBannerList() throws Exception;
	
	public MainBenner saveBanner(MainBannerDto.MainBannerSave save) throws Exception;
	
	public MainBenner getInfo(Integer bannerNo) throws Exception;
	
	public void updateBanner(MainBannerDto.MainBannerSave save) throws Exception;
}
