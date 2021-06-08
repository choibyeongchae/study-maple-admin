package com.maple.admin.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.maple.admin.config.PrincipalDetails;
import com.maple.admin.repositroy.MemberRepository;

public class AuthorizationFilter extends BasicAuthenticationFilter {

	private MemberRepository memberRepository;
	
	public AuthorizationFilter(AuthenticationManager authenticationManager, MemberRepository memberRepository) {
		super(authenticationManager);
		this.memberRepository = memberRepository;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			PrincipalDetails principalDetails = (PrincipalDetails)auth.getPrincipal();
			request.setAttribute("userInfo", principalDetails.getMember());
		}
		chain.doFilter(request, response);

	}
	
}
