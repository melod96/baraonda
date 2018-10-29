package com.kh.baraonda.board.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.baraonda.board.model.dao.BoardDao;
import com.kh.baraonda.board.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
	BoardDao boardDao;
	
	//게시글 전체 목록 조회
	@Override
	public List<Board> listAll() throws Exception{
		return boardDao.listAll();
	}
	
}
