package com.kh.baraonda.board.model.service;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.board.model.dao.BoardDao;
import com.kh.baraonda.board.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
	BoardDao boardDao;
	
	@Autowired //의존성 주입을 위함.
	private SqlSessionTemplate sqlSession;
	
	//게시글 전체 목록 조회
	@Override
	public List<Board> listAll() throws Exception{
		return boardDao.listAll(sqlSession);
	}
}
