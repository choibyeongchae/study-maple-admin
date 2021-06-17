package com.maple.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.maple.admin.entity.ItemMaster;

@Service
public interface ItemService {

	public List<ItemMaster> getItemList() throws Exception;
	
	public ItemMaster saveItem(Map<String, Object> saveMap) throws Exception;
	
	public ItemMaster getItemDetail(Integer item_seq) throws Exception;
}
