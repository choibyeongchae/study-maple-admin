package com.maple.admin.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maple.admin.dto.MainBannerDto;
import com.maple.admin.entity.MainBenner;
import com.maple.admin.service.MainBannerService;
import com.maple.admin.util.SuccessResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/banner/core")
public class MainBannerController {

	@Autowired
	private MainBannerService bannerService;
	
	@ApiOperation("메인배너 저장")
	@PostMapping("/save")
	@Transactional(readOnly = false)
	@ResponseBody
	public SuccessResponse saveBanner(MainBannerDto.MainBannerSave save, HttpServletResponse response) throws Exception {
		
		bannerService.saveBanner(save);
		
		return new SuccessResponse(response.SC_OK, "정상적으로 등록되었습니다.", null);
	}
	
	@ApiOperation("메인배너 수정")
	@PostMapping("/update")
	@Transactional(readOnly = false)
	@ResponseBody
	public SuccessResponse updateBanner(MainBannerDto.MainBannerSave save, HttpServletResponse response) throws Exception {
		
		bannerService.updateBanner(save);
		
		return new SuccessResponse(response.SC_OK, "정상적으로 수정되었습니다.", null);
	}
	
	@ApiOperation("메인배너 정보조회")
	@GetMapping("/getInfo")
	@Transactional(readOnly = true)
	@ResponseBody
	public SuccessResponse getBannerInfo(@RequestParam("bannerNo") Integer bannerNo, HttpServletResponse response) throws Exception{
		
		MainBenner banner = bannerService.getInfo(bannerNo);
		
		return new SuccessResponse(response.SC_OK, "정상적으로 조회되었습니다.", banner);
	}

}
