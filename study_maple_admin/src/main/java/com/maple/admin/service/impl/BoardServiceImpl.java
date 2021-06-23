package com.maple.admin.service.impl;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maple.admin.config.PrincipalDetails;
import com.maple.admin.dto.BoardDto;
import com.maple.admin.dto.BoardDto.BoardSaveDto;
import com.maple.admin.entity.MainBoard;
import com.maple.admin.entity.QMainBoard;
import com.maple.admin.repositroy.BoardRepository;
import com.maple.admin.service.BoardService;
import com.maple.admin.util.ConstantUtil;
import com.maple.admin.util.UserDetailUtil;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private JPAQueryFactory queryFactory;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private UserDetailUtil userDetailUtil;
	
	@Override
	public List<MainBoard> getBoardList() throws Exception {
		QMainBoard board = QMainBoard.mainBoard;
		
		List<MainBoard> list = queryFactory
				.selectFrom(board)
				.where(board.boader_type.eq("notice"))
				.orderBy(board.createDate.desc())
				.fetch();
		
		return list;
	}

	@Override
	public MainBoard saveNotice(BoardDto.BoardSaveDto save) throws Exception {
		
		PrincipalDetails userInfo = userDetailUtil.getPrincipalDetails();
		
		MainBoard board = MainBoard.builder()
				.boader_seq(null)
				.mbr_no(userInfo.getMember().getMbr_no())
				.mbr_email(userInfo.getMember().getMbr_email())
				.boader_title(save.getBoader_title())
				.boader_contents(save.getBoader_contents())
				.boader_type(ConstantUtil.BOARD_NOTICE)
				.boader_viewcnt(0)
				.build();
		
		MainBoard mainBoard = boardRepository.save(board);
		
		return mainBoard;
	}

	@Override
	public MainBoard getBoardDetail(Integer boardSeq) throws Exception {
		QMainBoard board = QMainBoard.mainBoard;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(board.boader_seq.eq(boardSeq));
		builder.and(board.boader_type.eq(ConstantUtil.BOARD_NOTICE));
		
		MainBoard mainBoard = queryFactory
				.selectFrom(board)
				.where(builder)
				.fetchOne();
		
		return mainBoard;
	}

	@Override
	public void updateNotice(BoardSaveDto save) throws Exception {
		QMainBoard board = QMainBoard.mainBoard;
		
		queryFactory.update(board)
			.set(board.boader_title, save.getBoader_title())
			.set(board.boader_contents, save.getBoader_contents())
			.where(board.boader_seq.eq(save.getBoader_seq()))
			.execute();
		
	}

	
}
