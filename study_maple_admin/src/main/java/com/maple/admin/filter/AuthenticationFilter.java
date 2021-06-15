package com.maple.admin.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maple.admin.config.PrincipalDetails;
import com.maple.admin.entity.Member;
import com.maple.admin.util.UserDetailUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private final AuthenticationManager authenticationManager;
	
	private final UserDetailUtil userDetailUtil;
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {

			ObjectMapper om = new ObjectMapper();
			Member mbr = om.readValue(request.getInputStream(), Member.class);
				
			// user info check
			UsernamePasswordAuthenticationToken authenticationToken =
					new UsernamePasswordAuthenticationToken(mbr.getMbr_email(), mbr.getMbr_pass());
				
			//PrincipalDetailService의 loadUserByName함수 실행
			Authentication authentication =
					authenticationManager.authenticate(authenticationToken);
			
			return authentication;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		PrincipalDetails principalDetails = (PrincipalDetails)authResult.getPrincipal();

		SecurityContextHolder.getContext().setAuthentication(authResult);
		
		userDetailUtil.setPrincipalDetails(principalDetails);
		
	}
	
}
