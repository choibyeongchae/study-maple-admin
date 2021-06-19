package com.maple.admin.util;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

import com.maple.admin.entity.BoardComents;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class DateEntityUtil {
	
	@Column(name = "regdate")
	private Instant createDate;
	
	@Column(name = "upddate")
	private Instant updateDate;
	
}
