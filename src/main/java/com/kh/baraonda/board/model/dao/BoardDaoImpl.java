package com.kh.baraonda.board.model.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.member.model.vo.Member;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Inject
	SqlSession SqlSession;

	//게시글 전체 목록 조회
	@Override
	public List<HashMap<String, Object>> listAll(SqlSessionTemplate sqlSession) throws BoardException  {
		try {
			//HashMap<Key, value>
			List<HashMap<String, Object>> list = sqlSession.selectList("Board.listAll");

			if(list == null) {
				throw new BoardException("리스트 값 널");
			}

			return list;
		}catch(Exception e) {
			throw new BoardException(e.getMessage());
		}
	}

	//게시글 작성
	@Override
	public void create(Board b, Member m) throws Exception {
		SqlSession.insert("Board.insert", b);
	}
	
	//게시글 상세 보기
	@Override
	public Board read(int board_no) throws BoardException{
		return SqlSession.selectOne("Board.view" ,board_no);
	}
	
	//게시글 조화수 증가
	@Override
	public void increaseViewCnt(int board_no) throws BoardException{
		SqlSession.update("Board.increaseViewCnt", board_no);
		
	}


}

















