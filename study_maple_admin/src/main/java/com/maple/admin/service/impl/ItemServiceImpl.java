package com.maple.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.maple.admin.entity.ItemMaster;
import com.maple.admin.entity.QItemMaster;
import com.maple.admin.repositroy.ItemMasterRepository;
import com.maple.admin.service.ItemService;
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
	public ItemMaster saveItem(Map<String, Object> saveMap) throws Exception {
		
		ItemMaster master = ItemMaster.builder()
				.item_type(String.valueOf(saveMap.get("item_type")))
				.item_name(String.valueOf(saveMap.get("item_name")))
				.item_desc(String.valueOf(saveMap.get("item_desc")))
				.item_takelevel(String.valueOf(saveMap.get("item_takelevel")))
				.item_job(String.valueOf(saveMap.get("item_job")))
				.item_str(String.valueOf(saveMap.get("item_str")))
				.item_dex(String.valueOf(saveMap.get("item_dex")))
				.item_int(String.valueOf(saveMap.get("item_int")))
				.item_luk(String.valueOf(saveMap.get("item_luk")))
				.item_strapos(String.valueOf(saveMap.get("item_strapos")))
				.item_ficat(String.valueOf(saveMap.get("item_ficat")))
				.item_attack(String.valueOf(saveMap.get("item_attack")))
				.item_mattack(String.valueOf(saveMap.get("item_mattack")))
				.item_upgarde(String.valueOf(saveMap.get("item_upgarde")))
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

}
