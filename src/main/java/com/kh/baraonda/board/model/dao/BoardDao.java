package com.kh.baraonda.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.board.model.vo.Board;

public interface BoardDao {
	
	//게시글 전체 목록 조회
	public List<Board> listAll(SqlSessionTemplate sqlSession) throws Exception;

}