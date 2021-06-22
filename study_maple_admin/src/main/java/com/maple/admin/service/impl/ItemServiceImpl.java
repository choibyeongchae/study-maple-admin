package com.maple.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maple.admin.dto.ItemSaveDto;
import com.maple.admin.entity.ItemMaster;
import com.maple.admin.entity.QItemMaster;
import com.maple.admin.repositroy.ItemMasterRepository;
import com.maple.admin.service.ItemService;
import com.maple.admin.util.StringUtil;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemMasterRepository itemMasterRepository;
	
	@Autowired
	private JPAQueryFactory queryFactory;
	
	@Override
	public List<ItemMaster> getItemList() throws Exception {
		
		QItemMaster master = QItemMaster.itemMaster;
		List<ItemMaster> itemList = queryFactory
				.selectFrom(master)
				.orderBy(master.createDate.desc())
				.fetch();
		
		return itemList;
	}
	
	@Override
	public ItemMaster saveItem(ItemSaveDto save) throws Exception {
		
		String itemFicat = "";
		
		if (!StringUtil.isEmpty(save.getItem_ficat())) {
			itemFicat = save.getItem_ficat();
		}
		
		ItemMaster master = ItemMaster.builder()
				.item_seq(null)
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
				.item_ficat(itemFicat)
				.item_attack(save.getItem_attack())
				.item_mattack(save.getItem_mattack())
				.item_upgarde(save.getItem_upgarde())
			.build();
		
		// insert
		ItemMaster itemMaster = itemMasterRepository.save(master);
		
		return itemMaster;
	}

	@Override
	public ItemMaster getItemDetail(Integer item_seq) throws Exception {
		QItemMaster itemMaster = QItemMaster.itemMaster;
		
		ItemMaster item = queryFactory
				.selectFrom(itemMaster)
				.where(itemMaster.item_seq.eq(item_seq))
				.fetchFirst();
		
		return item;
	}

	@Override
	public void updateItem(ItemSaveDto save) throws Exception {
		QItemMaster master = QItemMaster.itemMaster;
		
		queryFactory.update(master)
			.set(master.item_name, save.getItem_name())
			.set(master.item_desc, save.getItem_desc())
			.set(master.item_takelevel, save.getItem_takelevel())
			.set(master.item_job, save.getItem_job())
			.set(master.item_str, save.getItem_str())
			.set(master.item_dex, save.getItem_dex())
			.set(master.item_int, save.getItem_int())
			.set(master.item_luk, save.getItem_luk())
			.set(master.item_strapos, save.getItem_strapos())
			.set(master.item_ficat, save.getItem_ficat())
			.set(master.item_attack, save.getItem_attack())
			.set(master.item_mattack, save.getItem_mattack())
			.set(master.item_upgarde, save.getItem_upgarde())
			.where(master.item_seq.eq(save.getItem_seq()))
			.execute();
			
	}

}
