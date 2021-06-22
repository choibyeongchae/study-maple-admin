package com.maple.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maple.admin.dto.ItemSaveDto;
import com.maple.admin.entity.ItemMaster;

@Service
public interface ItemService {

	public List<ItemMaster> getItemList() throws Exception;
	
	public ItemMaster saveItem(ItemSaveDto save) throws Exception;
	
	public ItemMaster getItemDetail(Integer item_seq) throws Exception;
	
	public void updateItem(ItemSaveDto save) throws Exception;
}
