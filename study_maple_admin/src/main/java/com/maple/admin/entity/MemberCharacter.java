package com.maple.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.maple.admin.util.DateEntityUtil;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="member_character")
@Builder
@Data
@EqualsAndHashCode(callSuper=true)
public class MemberCharacter extends DateEntityUtil implements Serializable{

	@Id
	@ApiModelProperty(value = "캐릭터명")
	@Column(name = "caharacter_name")
	private String caharacter_name;
	
	@Id
	@ApiModelProperty(value = "회원시퀀스")
	@Column(name="mbr_no")
	private Integer mbr_no;
	
	@Id
	@ApiModelProperty(value = "회원이메일")
	@Column(name="mbr_email")
	private String mbr_email;
	
	@ApiModelProperty(value = "캐릭터레벨")
	@Column(name="aharacter_level")
	private Integer cha_level;
	
	@ApiModelProperty(value = "캐릭터직업")
	@Column(name="aharacter_job")
	private String cha_job;
	
	@ApiModelProperty(value = "캐릭터서버")
	@Column(name="chaa_server")
	private String cha_server;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mbr_no",insertable = false, updatable = false)
	private Member member;
	
}
