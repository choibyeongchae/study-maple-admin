package com.maple.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name="board_like")
@Builder
@Data
@EqualsAndHashCode(callSuper=true)
@SequenceGenerator(name = "history_seq", sequenceName = "history_seq", initialValue = 1, allocationSize = 1)
public class BoardIke extends DateEntityUtil implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "history_seq")
	@ApiModelProperty(value = "공감시퀀스")
	@Column(name = "history_seq")
	private Integer history_seq;
	
	@ApiModelProperty(value = "게시판시퀀스")
	@Column(name = "boader_seq")
	private Integer boader_seq;
	
	@ApiModelProperty(value = "회원시퀀스")
	@Column(name="mbr_no")
	private Integer mbr_no;
	
	@ApiModelProperty(value = "회원이메일")
	@Column(name="mbr_email")
	private String mbr_email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="boader_seq",insertable = false, updatable = false),
		@JoinColumn(name="mbr_no",insertable = false, updatable = false),
		@JoinColumn(name="mbr_email",insertable = false, updatable = false)
	})
	private MainBoard mainBoard;
}
