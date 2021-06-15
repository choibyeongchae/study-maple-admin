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
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="item_inven")
@Builder
@Data
@SequenceGenerator(name = "iven_seq", sequenceName = "iven_seq", initialValue = 1, allocationSize = 1)
public class ItemInven  extends DateEntityUtil implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "iven_seq")
	@ApiModelProperty(value = "인벤토리템 시퀀스")
	@Column(name = "iven_seq")
	private Integer iven_seq;
	
	@ApiModelProperty(value = "캐릭터명")
	@Column(name = "caharacter_name")
	private String caharacter_name;
	
	@ApiModelProperty(value = "회원시퀀스")
	@Column(name="mbr_no")
	private Integer mbr_no;
	
	@ApiModelProperty(value = "아이템 고유번호")
	@Column(name="item_seq")
	private Integer item_seq;
	
	@ApiModelProperty(value = "아이템 구분")
	@Column(name="item_type")
	private String item_type;
	
	@ApiModelProperty(value = "회원이메일")
	@Column(name="mbr_email")
	private String mbr_email;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="caharacter_name",insertable = false, updatable = false)
	private MemberCharacter memberCharacter;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "item_seq",insertable = false, updatable = false),
		@JoinColumn(name="item_type",insertable = false, updatable = false)
	})
	private ItemMaster itemMaster;

}
