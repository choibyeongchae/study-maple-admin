package com.maple.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@Table(name="main_benner")
@Builder
@Data
@EqualsAndHashCode(callSuper=true)
@SequenceGenerator(name = "benner_seq", sequenceName = "benner_seq", initialValue = 1, allocationSize = 1)
public class MainBenner extends DateEntityUtil implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "benner_seq")
	@ApiModelProperty(value = "메인베너 시퀀스")
	@Column(name = "benner_seq")
	private Integer benner_seq;
	
	@ApiModelProperty(value = "메인베너 이미지경로")
	@Column(name="benner_image")
	private String benner_image;
	
	@ApiModelProperty(value = "메인배너 이미지명")
	@Column(name = "benner_imagenm")
	private String benner_imagenm;
	
	@ApiModelProperty(value = "메인베너 타이틀")
	@Column(name="benner_title")
	private String benner_title;
	
	@ApiModelProperty(value = "메인베너 시작기간")
	@Column(name="benner_stardate")
	private String benner_stardate;
	
	@ApiModelProperty(value = "메인베너 종료기간")
	@Column(name="benner_endate")
	private String benner_endate;
	
	@ApiModelProperty(value = "메인베너 타입")
	@Column(name="benner_type")
	private String benner_type;
	
	@ApiModelProperty(value = "메인베너 예약타입")
	@Column(name="banner_restype")
	private String banner_restype;
	
}
