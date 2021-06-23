package com.maple.admin.service;

import java.util.List;

import com.maple.admin.dto.BoardDto;
import com.maple.admin.entity.MainBoard;

public interface BoardService {

	public List<MainBoard> getBoardList() throws Exception;
	
	public MainBoard saveNotice(BoardDto.BoardSaveDto save) throws Exception;
	
	public MainBoard getBoardDetail(Integer boardSeq) throws Exception;
	
	public void updateNotice(BoardDto.BoardSaveDto save) throws Exception;
}
