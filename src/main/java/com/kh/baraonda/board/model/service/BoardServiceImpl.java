package com.kh.baraonda.board.model.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.board.model.dao.BoardDao;
import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.board.model.vo.Comments;
import com.kh.baraonda.board.model.vo.boardMarking;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.myPage.model.vo.Files;
import com.kh.baraonda.notice.model.vo.NoticeComment;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
	BoardDao boardDao;
	
	@Autowired //의존성 주입을 위함.
	private SqlSessionTemplate sqlSession;
	
	//게시글 전체 목록 조회
	@Override
	public List<HashMap<String, Object>> listAll(int writing_type, PageInfo info) throws BoardException {
		List<HashMap<String, Object>> list = boardDao.listAll(sqlSession, writing_type, info) ;
		
		return list;
	}
	//게시글 페이징 처리
	@Override
	public int selectBoardListCount() {
		return boardDao.selectBoardListCount(sqlSession);
	}
	
	//게시글 insert
	@Override
	public void create(Board b) throws BoardException {
		boardDao.create(b);
	}
	//게시글 update
	@Override
	public void updateBoard(Board b) throws BoardException {
		boardDao.updateBoard(b);
	}
	//게시글 delete
	@Override
	public void deleteBoard(int board_no) throws BoardException {
		boardDao.deleteBoard(board_no);
	}
	
	//게시글 조회수 증가
	@Override
	public void increaseViewCnt(int board_no, HttpSession session) throws BoardException{
		long update_time = 0;
		//세션에 저장된 조회시간 검색
		//최초로 조회할 경우 세선에 저장된 값이 없기 때문에 if문은 실행X
		if(session.getAttribute("update_time_" + board_no) != null) {
			update_time = (Long) session.getAttribute("update_time_" + board_no);
		}
		//시스템의 현재시간을 current_time에 저장
		long current_time = System.currentTimeMillis();
		//일정기간이 경과 후 조회수 증가 처리 24*60*60*1000(24시간)
		//시스템 현재 시간 - 열람 시간 > 일정 시간(조회수 증가가 가능하도록 지정한 시간)
		if(current_time - update_time > 5 * 1000) {
			boardDao.increaseViewCnt(board_no);
			
			session.setAttribute("update_time_" + board_no, current_time);
		}
	}
	
	//게시글 상세보기
	@Override
	/*public List<HashMap<String, Object>> detail(int board_no) throws BoardException {*/
	public HashMap<String, Object> detail(int board_no) throws BoardException {
		/*List<HashMap<String, Object>> detail = boardDao.detail(sqlSession, board_no) ;*/
		HashMap<String, Object> detail = boardDao.detail(sqlSession, board_no) ;
		return detail;
	}
	//댓글 조회
	@Override
	public List<HashMap<String, Object>> commentList(int board_no) throws BoardException {
		List<HashMap<String, Object>> commentList = boardDao.commentList(sqlSession, board_no) ;
		return commentList;
	}
	
	//댓글 insert
	@Override
	public int insertComment(Comments c) {
		return boardDao.insertComment(sqlSession, c);
	}
	//댓글 delete
	@Override
	public int deleteComment(int comments_no) {
		return boardDao.deleteComment(sqlSession, comments_no);
	}
	
	//좋아요 수
	@Override
	public int selectLike(int board_no) throws BoardException{
		return boardDao.selectLike(sqlSession, board_no);
	}
	//좋아요 체크 여부
	@Override
	public int checkLike(boardMarking bm) {
		return boardDao.checkLike(sqlSession, bm);
	}
	//좋아요 등록
	@Override
	public int insertLike(boardMarking bm) {
		return boardDao.insertLike(sqlSession, bm);
	}
	//좋아요 삭제
	@Override
	public int deleteLike(boardMarking bm){
		return boardDao.deleteLike(sqlSession, bm);
	}
	
	//북마크 체크 여부
	@Override
	public int checkBookMark(boardMarking bm) {
		return boardDao.checkBookMark(sqlSession, bm);
	}
	//북마크 insert
	@Override
	public int insertBookMark(boardMarking bm) {
		return boardDao.insertBookMark(sqlSession, bm);
	}
	//북마크 delete
	@Override
	public int deleteBookMark(boardMarking bm) {
		return boardDao.deleteBookMark(sqlSession, bm);
	}
	
	//게시글 검색 개수
	@Override
	public int searchBoardCount(SearchCondition sc) {
		return boardDao.searchBoardCount(sqlSession, sc);
	}
	
	//검색
	@Override
	public List<HashMap<String, Object>> searchList(int writing_type, PageInfo info, SearchCondition sc) {
		return boardDao.searchList(sqlSession, sc, info, writing_type);
	}
	

}





























