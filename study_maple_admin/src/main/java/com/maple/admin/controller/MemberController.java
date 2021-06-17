package com.maple.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maple.admin.dto.MemberDetailDto;
import com.maple.admin.entity.Member;
import com.maple.admin.service.MemberService;
import com.maple.admin.util.SuccessResponse;
import com.maple.admin.util.UserDetailUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/member/core")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private UserDetailUtil userDetailUtil;
	
	@ApiOperation("회원가입")
	@PostMapping(value = "/signup")
	@Transactional(readOnly = false)
	@ResponseBody
	public SuccessResponse signUp(@RequestBody Map<String, Object> reqMap, HttpServletResponse response) throws Exception {
		
		Member mbr = memberService.signUp(reqMap);
		
		return new SuccessResponse(response.SC_OK, "회원가입 완료", mbr);
	}
	
	@ApiOperation("회원리스트 조회")
	@GetMapping(value = "/siteMemberList")
	public SuccessResponse getSiteMemberList(HttpServletResponse response) throws Exception {
		
		List<Member> list = memberService.getMemberList();
		
		return new SuccessResponse(response.SC_OK, "조회성공", list);
	}
	
	@ApiOperation("로그아웃")
	@PostMapping(value = "/doLogout")
	@ResponseBody
	public Object doLogout(HttpServletResponse response,HttpServletRequest request) throws Exception {
		
		SecurityContextHolder.getContext().setAuthentication(null);
		
		userDetailUtil.setPrincipalDetails(null);

		return new SuccessResponse(response.SC_OK, "로그아웃 완료", null);
		
	}
	
	@ApiOperation("어드민 회원 리스트 조회")
	@GetMapping(value = "/adminMemberList")
	@ResponseBody
	@Transactional(readOnly = true)
	public SuccessResponse getAdminMemberList(HttpServletResponse response) throws Exception {
		
		List<Member> adminMemberList = memberService.getAdminMemberList();
		return new SuccessResponse(response.SC_OK, "조회성공", adminMemberList);
	}
	
	@ApiOperation("회원 관리 : 회원상세")
	@GetMapping(value = "/siteMemberDetail")
	public SuccessResponse siteMemberDetail(@RequestParam("mbrno") Integer mbrno,HttpServletResponse response) throws Exception{
		List<MemberDetailDto> memberDetailList = memberService.getMemberDetail(mbrno);
		
		return new SuccessResponse(response.SC_OK, "조회성공", memberDetailList);
	}
	
}

