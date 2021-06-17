package com.maple.admin.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Data;

@Data
public class MemberDetailDto {

	private Integer mbr_no;
	private String mbr_email;
	private String mbr_name;
	private String mbr_phone;
	private String mbr_born;
	private String mbr_address;
	private String caharacter_name;
	private Integer aharacter_level;
	private String chaa_server;
	private Integer item_seq;
	private String item_type;
	private String item_name;
	private String item_desc;
	private String item_takelevel;
	private String item_job;
	private String item_str;
	private String item_dex;
	private String item_int;
	private String item_luk;
	private String item_strapos;
	private String item_ficat;
	private String item_attack;
	private String item_mattack;
	private String item_upgarde;
	
	@QueryProjection
	public MemberDetailDto(Integer mbr_no, String mbr_email,String mbr_name, String mbr_phone, String mbr_born, String mbr_address
			, String caharacter_name, Integer aharacter_level, String chaa_server, Integer item_seq, String item_type
			, String item_name, String item_desc, String item_takelevel, String item_job, String item_str
			, String item_dex, String item_int, String item_luk, String item_strapos, String item_ficat
			, String item_attack, String item_mattack, String item_upgarde) {
		
		this.mbr_no = mbr_no;
		this.mbr_email = mbr_email;
		this.mbr_name = mbr_name;
		this.mbr_phone = mbr_phone;
		this.mbr_born = mbr_born;
		this.mbr_address = mbr_address;
		this.caharacter_name = caharacter_name;
		this.aharacter_level = aharacter_level;
		this.chaa_server = chaa_server;
		this.item_seq = item_seq;
		this.item_type = item_type;
		this.item_name = item_name;
		this.item_desc  =item_desc;
		this.item_takelevel = item_takelevel;
		this.item_job = item_job;
		this.item_str = item_str;
		this.item_dex = item_dex;
		this.item_int = item_int;
		this.item_luk = item_luk;
		this.item_strapos = item_strapos;
		this.item_ficat = item_ficat;
		this.item_attack = item_attack;
		this.item_mattack = item_mattack;
		this.item_upgarde = item_upgarde;
	}
	
	
}
