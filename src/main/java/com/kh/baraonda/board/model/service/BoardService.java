package com.kh.baraonda.board.model.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.member.model.vo.Member;

public interface BoardService {
	
	//게시글 전체 목록 조회
	public List<HashMap<String, Object>> listAll(int writing_type) throws BoardException;
	//게시글 페이징 처리
	public int selectBoardListCount();
	
	//게시글 작성
	public void create(Board b) throws BoardException;
	
	//게시글 조화수 증가
	public void increaseViewCnt(int board_no, HttpSession session) throws BoardException;
	
	//게시글 상세 보기
	/*public List<HashMap<String, Object>> detail(int board_no) throws BoardException;*/
	public HashMap<String, Object> detail(int board_no) throws BoardException;
	
	//댓글 조회
	public List<HashMap<String, Object>> commentList(int board_no) throws BoardException;
	
}
