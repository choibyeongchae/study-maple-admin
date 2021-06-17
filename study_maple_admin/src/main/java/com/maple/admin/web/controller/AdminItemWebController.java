package com.maple.admin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maple.admin.entity.ItemMaster;
import com.maple.admin.service.ItemService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/item")
public class AdminItemWebController {
	
	@Autowired
	private ItemService itemService;
	
	@ApiOperation("아이템 리스트 화면매핑")
	@GetMapping(value = "/list")
	public String itemList(Model model) throws Exception {
		
		List<ItemMaster> itemList = itemService.getItemList();
		model.addAttribute("itemList", itemList);
		
		return "item/list";
	}
	
	@ApiOperation("아이템 상세 화면매핑")
	@GetMapping(value = "/detail")
	public String itemDetail(Model model) {
		return "item/detail";
	}
	
}
