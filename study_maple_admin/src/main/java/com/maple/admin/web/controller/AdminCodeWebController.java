package com.maple.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/code")
public class AdminCodeWebController {

	@ApiOperation("코드리스트 화면매핑")
	@GetMapping(value = "/list")
	public String codeList(Model model) {
		return "/code/list";
	}
	
	@ApiOperation("코드리스트 화면매핑")
	@GetMapping(value = "/detail")
	public String codeDetail(Model model) {
		return "/code/detail";
	}
}
