package com.maple.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maple.admin.service.BoardService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/board")
public class AdminBoardWebController {

	@Autowired
	private BoardService boardService;
	
	@ApiOperation("공지사항 리스트")
	@GetMapping("/list")
	public String getBoardList(Model model) throws Exception {
		
		model.addAttribute("boardList", boardService.getBoardList());
		
		return "/board/list";
	}
	
	@ApiOperation("공지사항 상세 (등록,수정,삭제)")
	@GetMapping("/detail")
	public String getBoardDetail(Model model) {
		return "/board/detail";
	}

}
