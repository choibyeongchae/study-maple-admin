package com.maple.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.maple.admin.config.PrincipalDetails;
import com.maple.admin.entity.Member;
import com.maple.admin.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService{
	
	@Autowired
	private JPAQueryFactory queryFactory;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		QMember qMember = QMember.member;
		Member member = queryFactory.selectFrom(qMember)
				.from(qMember)
				.where(qMember.mbr_email.eq(username))
				.fetchFirst();

		if (member == null && !member.getMbr_role().equals("ROLE_ADMIN")) {
			Member loadUserByUsername = new Member();
			loadUserByUsername.setMbr_email(username);
			loadUserByUsername.setMbr_pass("");
			return new PrincipalDetails(loadUserByUsername);
		}
		return new PrincipalDetails(member);
	}
	
	
	

	
}
