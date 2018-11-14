package com.kh.baraonda.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.board.model.vo.Comments;
import com.kh.baraonda.board.model.vo.boardMarking;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
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
	public List<HashMap<String, Object>> commentList(int board_no, PageInfo info) throws BoardException;
	//댓글 수 
	int commentListCount(int board_no);
	//댓글 insert
	int insertComment(Comments c);
	//댓글 delete
	int deleteComment(int comments_no);
	
	//좋아요 수
	int selectLike(int board_no) throws BoardException;
	//좋아요 체크 여부
	int checkLike(boardMarking bm);
	//좋아요 등록
	int insertLike(boardMarking bm);
	//좋아요 삭제
	int deleteLike(boardMarking bm);
	
	//북마크 체크 여부
	int checkBookMark(boardMarking bm);
	//북마크 insert
	int insertBookMark(boardMarking bm);
	//북마크 delete
	int deleteBookMark(boardMarking bm);
	
	//검색
	public List<HashMap<String, Object>> searchList(PageInfo info, SearchCondition sc);
	//게시글 검색 개수
	int searchBoardCount(SearchCondition sc);	
	
	//홈트레이닝 게시물 목록 조회
	ArrayList<Board> selectHomeList(PageInfo info) throws BoardException;
	
	
	
}
