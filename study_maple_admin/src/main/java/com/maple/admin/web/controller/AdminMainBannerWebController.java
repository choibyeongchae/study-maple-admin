package com.maple.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/banner")
public class AdminMainBannerWebController {

	@ApiOperation("메인배너 리스트 화면매핑")
	@GetMapping(value = "/list")
	public void bannerList(Model model) {
		
	}
	
	@ApiOperation("메인배너 상세 화면매핑")
	@GetMapping(value = "/detail")
	public void bannerDetail(Model model) {
		
	}
}
