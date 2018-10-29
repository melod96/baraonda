package com.kh.baraonda.board.model.dao;

import java.util.List;

import javax.inject.Inject;

import com.kh.baraonda.board.model.vo.Board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Inject
	SqlSession SqlSession;
	
	@Override
	public List<Board> listAll() throws Exception{
		return SqlSession.selectList("Board.listAll");
	}

}
