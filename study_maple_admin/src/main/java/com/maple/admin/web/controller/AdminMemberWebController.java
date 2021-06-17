package com.maple.admin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maple.admin.entity.Member;
import com.maple.admin.service.MemberService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/member")
public class AdminMemberWebController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping(value ="/member_login")
	public String loginPage(Model model) {
		return "member/member_login";
	}
	
	@ApiOperation("회원가입 화면 매핑")
	@GetMapping(value = "/member_register")
	public String member_register(Model model) {
		return "member/member_register";
	}
	
	@ApiOperation("회원관리화면 매핑")
	@GetMapping(value = "/siteMember")
	public String siteMember(Model model) {
		return "member/siteMember";
	}
	
	@ApiOperation("어드민 관리화면 매핑")
	@GetMapping(value = "/adminSiteMember")
	public String adminSiteMember(Model model) throws Exception {
		List<Member> adminMemberList = memberService.getAdminMemberList();
		
		model.addAttribute("adminMemberList", adminMemberList);
		
		return "member/adminSiteMember";
	}
}
