package com.maple.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/event")
public class AdminEventWebController {

	@ApiOperation("이벤트 리스트 화면 매핑")
	@GetMapping(value = "/list")
	public String eventList(Model model) {
		return "event/list";
	}
	
	@ApiOperation("이벤트 상세 화면 매핑")
	@GetMapping(value = "/detail")
	public String eventDetail(Model model) {
		return "event/detail";
	}
}
