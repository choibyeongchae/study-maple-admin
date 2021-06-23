package com.maple.admin.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maple.admin.dto.BoardDto;
import com.maple.admin.entity.MainBoard;
import com.maple.admin.service.BoardService;
import com.maple.admin.util.SuccessResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/board/core")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@ApiOperation("공지사항 등록")
	@PostMapping("/save")
	@Transactional(readOnly = false)
	@ResponseBody
	public SuccessResponse saveNotice(BoardDto.BoardSaveDto save,HttpServletResponse response) throws Exception {
		
		MainBoard board = boardService.saveNotice(save);
		
		return new SuccessResponse(response.SC_OK, "정상적으로 등록되었습니다.", board);
	}
	
	@ApiOperation("공지사항 상세조회")
	@GetMapping("/noticeDetail")
	@Transactional(readOnly = true)
	@ResponseBody
	public SuccessResponse getNoticeDetail(@RequestParam("boardSeq") Integer boardSeq,HttpServletResponse response) throws Exception {
		MainBoard board = boardService.getBoardDetail(boardSeq);

		return new SuccessResponse(response.SC_OK, "데이터 조회 성공", board);
	}
	
	@ApiOperation("공지사항 수정")
	@PostMapping("/update")
	@Transactional(readOnly = false)
	@ResponseBody
	public SuccessResponse updateNotice(BoardDto.BoardSaveDto save, HttpServletResponse response) throws Exception {
		
		boardService.updateNotice(save);
		
		return new SuccessResponse(response.SC_OK, "정상적으로 수정되었습니다.", null);
	}
	
}
