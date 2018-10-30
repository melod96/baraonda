package com.kh.baraonda.board.model.dao;

import java.util.List;

import com.kh.baraonda.board.model.vo.Board;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao{

	
/*	@Override
	public List<Board> listAll() throws Exception{
		return SqlSession.selectList("Board.listAll");
	}*/

	@Override
	public List<Board> listAll(SqlSessionTemplate sqlSession) throws Exception {
		return sqlSession.selectList("Board.listAll");
	}

}
