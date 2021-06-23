package com.maple.admin.util;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.Modifying;

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
	@CreatedDate
	private Instant createDate;
	
	@Column(name = "upddate")
	@LastModifiedDate
	private Instant updateDate;
	
}
