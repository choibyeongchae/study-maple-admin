package com.maple.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.maple.admin.dto.MemberDetailDto;
import com.maple.admin.entity.Member;
import com.maple.admin.entity.MemberCharacter;
import com.maple.admin.entity.QItemInven;
import com.maple.admin.entity.QItemMaster;
import com.maple.admin.entity.QMember;
import com.maple.admin.entity.QMemberCharacter;
import com.maple.admin.repositroy.MemberRepository;
import com.maple.admin.service.MemberService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
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

	@Override
	public List<MemberDetailDto> getMemberDetail(Integer mbrno) throws Exception {
		QMember member = QMember.member;
		QMemberCharacter memberCharacter = QMemberCharacter.memberCharacter;
		QItemInven itemInven = QItemInven.itemInven;
		QItemMaster itemMaster = QItemMaster.itemMaster;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(member.mbr_no.eq(mbrno));
		builder.and(member.mbr_role.eq("ROLE_USER"));
		
		List<MemberDetailDto> memberDetail = queryFactory
				.select(
					Projections.constructor(MemberDetailDto.class,
						member.mbr_no
						,member.mbr_email
						,member.mbr_name
						,member.mbr_phone
						,member.mbr_born
						,member.mbr_adress
						,memberCharacter.caharacter_name
						,memberCharacter.cha_level
						,memberCharacter.cha_server
						,itemInven.item_seq
						,itemInven.item_type
						,itemMaster.item_name
						,itemMaster.item_desc
						,itemMaster.item_takelevel
						,itemMaster.item_job
						,itemMaster.item_str
						,itemMaster.item_dex
						,itemMaster.item_int
						,itemMaster.item_luk
						,itemMaster.item_strapos
						,itemMaster.item_ficat
						,itemMaster.item_attack
						,itemMaster.item_mattack
						,itemMaster.item_upgarde
				))
				.from(member)
				.leftJoin(memberCharacter)
				.on(member.mbr_no.eq(memberCharacter.mbr_no))
				.leftJoin(itemInven)
				.on(
						itemInven.mbr_no.eq(memberCharacter.mbr_no)
						.and(itemInven.mbr_email.eq(memberCharacter.mbr_email))
						.and(itemInven.caharacter_name.eq(memberCharacter.caharacter_name))
					)
				.leftJoin(itemMaster)
				.on(itemMaster.item_seq.eq(itemInven.item_seq))
				.where(builder)
				.orderBy(memberCharacter.cha_server.desc(),memberCharacter.cha_level.desc())
				.fetch();
		
		return memberDetail;
	}

	@Override
	public List<Member> getMemberList() throws Exception {
		QMember member = QMember.member;
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(member.mbr_role.eq("ROLE_USER"));
		
		List<Member> memberList = queryFactory
				.selectFrom(member)
				.where(builder)
				.fetch();
		
		return memberList;
	}

}
