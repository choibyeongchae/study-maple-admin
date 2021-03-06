package com.maple.admin;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.maple.admin.util.UserDetailUtil;
import com.querydsl.jpa.impl.JPAQueryFactory;

@EnableJpaAuditing
@SpringBootApplication
public class StudyMapleAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyMapleAdminApplication.class, args);
	}
	
	@PersistenceContext
	EntityManager em;
	
	@Bean
	public JPAQueryFactory queryFactory() {
		return new JPAQueryFactory(em);
	}
	
	@Bean
	public UserDetailUtil userDetailUtil() {
		return new UserDetailUtil();
	}

}
