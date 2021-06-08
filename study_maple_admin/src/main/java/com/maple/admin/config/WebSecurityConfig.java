package com.maple.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.CorsFilter;

import com.maple.admin.filter.AuthenticationFilter;
import com.maple.admin.filter.AuthorizationFilter;
import com.maple.admin.repositroy.MemberRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final CorsFilter corsFilter;
	private final MemberRepository memberRepository;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilter(corsFilter)
		.formLogin().disable() // form login 사용안함
		.httpBasic().disable()
		.addFilter(new AuthenticationFilter(authenticationManager()))
		.addFilter(new AuthorizationFilter(authenticationManager(),memberRepository))
		.authorizeRequests()
		.antMatchers("/**").permitAll();
		//.anyRequest()
		//.access("hasRole('ROLE_ADMIN')");
		
	}
}
