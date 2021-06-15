package com.maple.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.maple.admin.util.DateEntityUtil;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="event_coment")
@Builder
@Data
@SequenceGenerator(name = "even_op", sequenceName = "even_op", initialValue = 1, allocationSize = 1)
public class EventComent extends DateEntityUtil implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "even_op")
	@ApiModelProperty(value = "이벤트오픈")
	@Column(name = "even_op")
	private Integer even_op;
	
	@ApiModelProperty(value = "회원시퀀스")
	@Column(name = "mbr_no")
	private Integer mbr_no;
	
	@ApiModelProperty(value = "이메일")
	@Column(name="mbr_email")
	private String mbr_email;
	
	@ApiModelProperty(value = "댓글내용")
	@Column(name="even_coments")
	private String even_coments;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="mbr_no",insertable = false, updatable = false)
	private Member member;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="even_op",insertable = false, updatable = false)
	private EventMaster eventMaster;
	
}
