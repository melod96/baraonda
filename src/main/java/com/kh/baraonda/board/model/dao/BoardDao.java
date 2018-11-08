package com.kh.baraonda.board.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.board.model.vo.Comments;
import com.kh.baraonda.board.model.vo.boardMarking;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.vo.Files;

public interface BoardDao {
	
	//게시글 전체 목록 조회
	public List<HashMap<String, Object>> listAll(SqlSessionTemplate sqlSession, int writing_type, PageInfo info) throws BoardException;
	//게시글 페이징 처리
	public int selectBoardListCount(SqlSessionTemplate sqlSession);
	
	//게시글 insert
	public void create(Board b) throws BoardException;
	//게시글 update
	public void updateBoard(Board b) throws BoardException;
	//게시글 delete
	public void deleteBoard(int board_no) throws BoardException;
	
	//게시글 조회수 증가
	public void increaseViewCnt(int board_no) throws BoardException;
	
	//게시글 상세보기
	/*public List<HashMap<String, Object>> detail(SqlSessionTemplate sqlSession, int board_no) throws BoardException;*/
	public HashMap<String, Object> detail(SqlSessionTemplate sqlSession, int board_no) throws BoardException;

	//댓글 조회
	public List<HashMap<String, Object>> commentList(SqlSessionTemplate sqlSession, int board_no) throws BoardException;
	
	//댓글 insert
	int insertComment(SqlSessionTemplate sqlSession, Comments c);
	//댓글 delete
	int deleteComment(SqlSessionTemplate sqlSession, int comments_no);
	
	//좋아요 수
	int selectLike(SqlSessionTemplate sqlSession, int board_no) throws BoardException;
	//좋아요 체크 여부
	int checkLike(SqlSessionTemplate sqlSession, boardMarking bm);
	//좋아요 등록
	public void insertLike(SqlSessionTemplate sqlSession, boardMarking bm);
	

	
}
