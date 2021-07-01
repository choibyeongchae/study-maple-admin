package com.maple.admin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maple.admin.entity.MainBenner;
import com.maple.admin.service.MainBannerService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/banner")
public class AdminMainBannerWebController {

	@Autowired
	private MainBannerService mainBannerService;
	
	@ApiOperation("메인배너 리스트 화면매핑")
	@GetMapping(value = "/list")
	public String bannerList(Model model) throws Exception{
		
		List<MainBenner> bannerList = mainBannerService.getBannerList();
		model.addAttribute("bannerList",bannerList);
		
		return "/banner/list";
	}
	
	@ApiOperation("메인배너 상세 화면매핑")
	@GetMapping(value = "/detail")
	public String bannerDetail(Model model) {
		return "/banner/detail";
	}
}
