package com.maple.admin.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.maple.admin.config.PrincipalDetails;
import com.maple.admin.util.UserDetailUtil;

public class AuthorizationFilter extends BasicAuthenticationFilter {

	private UserDetailUtil userDetailUtil;
	
	public AuthorizationFilter(AuthenticationManager authenticationManager,UserDetailUtil userDetailUtil) {
		super(authenticationManager);
		this.userDetailUtil = userDetailUtil;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		PrincipalDetails userInfo = userDetailUtil.getPrincipalDetails();
		if (userInfo != null) {
			request.setAttribute("userInfo", userInfo.getMember());
		}
		
		chain.doFilter(request, response);

	}
	
}
