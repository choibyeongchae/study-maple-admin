package com.maple.admin.dto;

import com.maple.admin.entity.ItemMaster;

import lombok.Data;

@Data
public class ItemSaveDto {
	
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
	
	public ItemMaster toEntity(ItemSaveDto save) {
		return ItemMaster.builder()
				.item_seq(save.getItem_seq())
				.item_type(save.getItem_type())
				.item_name(save.getItem_name())
				.item_desc(save.getItem_desc())
				.item_takelevel(save.getItem_takelevel())
				.item_job(save.getItem_job())
				.item_str(save.getItem_str())
				.item_dex(save.getItem_dex())
				.item_int(save.getItem_int())
				.item_luk(save.getItem_luk())
				.item_strapos(save.getItem_strapos())
				.item_ficat(save.getItem_ficat())
				.item_attack(save.getItem_attack())
				.item_mattack(save.getItem_mattack())
				.item_upgarde(save.getItem_upgarde())
			.build();
	}
}
