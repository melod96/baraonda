package com.kh.baraonda.board.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.member.model.vo.Member;

public interface BoardDao {
	
	//게시글 전체 목록 조회
	public List<HashMap<String, Object>> listAll(SqlSessionTemplate sqlSession, int writing_type) throws BoardException;
	
	//게시글 작성
	public void create(Board b, Member m) throws Exception;
	
	//게시글 조화수 증가
	public void increaseViewCnt(int board_no) throws BoardException;
	
	//게시글 상세보기
	/*public List<HashMap<String, Object>> detail(SqlSessionTemplate sqlSession, int board_no) throws BoardException;*/
	public HashMap<String, Object> detail(SqlSessionTemplate sqlSession, int board_no) throws BoardException;
	
	//댓글 조회
	public List<HashMap<String, Object>> commentList(SqlSessionTemplate sqlSession, int board_no) throws BoardException;
}
