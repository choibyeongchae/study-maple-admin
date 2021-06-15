package com.maple.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.maple.admin.entity.Member;
import com.maple.admin.entity.QMember;
import com.maple.admin.repositroy.MemberRepository;
import com.maple.admin.service.MemberService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private JPAQueryFactory queryFactory;
	
	@Override
	public Member signUp(Map<String, Object> reqMap) throws Exception {
		
		BCryptPasswordEncoder bcrptPasswordEncoder = new BCryptPasswordEncoder();
		
		Member mbr = Member.builder()
				.mbr_email(String.valueOf(reqMap.get("userId")))
				.mbr_name(String.valueOf(reqMap.get("username")))
				.mbr_pass(bcrptPasswordEncoder.encode(String.valueOf(reqMap.get("password"))))
				.mbr_phone(String.valueOf(reqMap.get("tel")))
				.mbr_born(String.valueOf(reqMap.get("birth")))
				.mbr_adress(String.valueOf(reqMap.get("address")))
				.mbr_zip(String.valueOf(reqMap.get("zip")))
				.mbr_role("ROLE_ADMIN")
				.build();
		
		// insert
		Member rtnMbr = memberRepository.save(mbr);
		
		
		return rtnMbr;
	}

	@Override
	public List<Member> getAdminMemberList() throws Exception {
		QMember member = QMember.member;
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(member.mbr_role.eq("ROLE_ADMIN"));
		
		//PageRequest 
		
		List<Member> adminMbrList = queryFactory
				.selectFrom(member)
				.where(builder)
				.fetch();
		
		//Pageable pageable = PageRequest.of(page, size)
		
		//long totalCount = queryFactory.selectFrom(member).where(builder).fetchCount();
		
		return adminMbrList;
	}

}
