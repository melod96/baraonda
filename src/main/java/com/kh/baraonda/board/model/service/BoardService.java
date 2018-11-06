package com.kh.baraonda.board.model.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.board.model.vo.Comments;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.vo.Files;
import com.kh.baraonda.notice.model.vo.NoticeComment;

public interface BoardService {
	
	//게시글 전체 목록 조회
	public List<HashMap<String, Object>> listAll(int writing_type, PageInfo info) throws BoardException;
	//게시글 페이징 처리
	public int selectBoardListCount();
	
	//게시글 insert
	public void create(Board b) throws BoardException;
	//게시글 update
	public void updateBoard(Board b) throws BoardException;
	//게시글 delete
	public void deleteBoard(int board_no) throws BoardException;
	
	//게시글 조회수 증가
	public void increaseViewCnt(int board_no, HttpSession session) throws BoardException;
	
	//게시글 상세 보기
	/*public List<HashMap<String, Object>> detail(int board_no) throws BoardException;*/
	public HashMap<String, Object> detail(int board_no) throws BoardException;

	//댓글 조회
	public List<HashMap<String, Object>> commentList(int board_no) throws BoardException;
	
	//댓글 insert
	int insertComment(Comments c);
	
	
	
}
