package com.maple.admin.util;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class DateEntityUtil {
	
	@Column(name = "regdate")
	@CreatedDate
	private Instant createDate;
	
	@Column(name = "upddate")
	@LastModifiedDate
	private Instant updateDate;
	
}
