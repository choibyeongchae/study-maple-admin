package com.maple.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maple.admin.entity.ItemMaster;
import com.maple.admin.service.ItemService;
import com.maple.admin.util.SuccessResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/item/core")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@ApiOperation("아이템 생성")
	@PostMapping("/saveItem")
	@Transactional(readOnly = false)
	public SuccessResponse saveItem(@RequestBody Map<String, Object> saveMap, HttpServletResponse response) throws Exception {
		
		ItemMaster itemMaster = itemService.saveItem(saveMap);
		
		return new SuccessResponse(response.SC_OK, "정상적으로 등록되었습니다.", itemMaster);
	}
	
	@ApiOperation("아이템 상세")
	@GetMapping("/itemDetail")
	@Transactional(readOnly = true)
	public SuccessResponse getItem(@RequestParam("item_seq") Integer item_seq, HttpServletResponse response) throws Exception {
		
		ItemMaster itemDetail = itemService.getItemDetail(item_seq);
		
		return new SuccessResponse(response.SC_OK, "조회 성공", itemDetail);
	}
	
	
}
