package com.maple.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.maple.admin.entity.Member;

@Service
public interface MemberService {

	public Member signUp(Map<String, Object> reqMap) throws Exception;
	
	public List<Member> getAdminMemberList() throws Exception;
}
