package com.kh.baraonda.board.model.dao;

import java.util.List;

import javax.inject.Inject;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.member.model.vo.Member;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Inject
	SqlSession SqlSession;
	
/*	@Override
	public List<Board> listAll() throws Exception{
		return SqlSession.selectList("Board.listAll");
	}*/
	
	//게시글 전체 목록 조회
	@Override
	public List<Board> listAll(SqlSessionTemplate sqlSession) throws Exception {
		return sqlSession.selectList("Board.listAll");
	}
	
	//게시글 작성
	@Override
	public void create(Board b, Member m) throws Exception {
		SqlSession.insert("board.insert", b);
	}


}
