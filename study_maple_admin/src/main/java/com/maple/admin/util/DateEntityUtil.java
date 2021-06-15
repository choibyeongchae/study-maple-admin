package com.maple.admin.util;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class DateEntityUtil {
	
	@Column(name = "regdate")
	private Instant createDate;
	
	@Column(name = "upddate")
	private Instant updateDate;
	
}
