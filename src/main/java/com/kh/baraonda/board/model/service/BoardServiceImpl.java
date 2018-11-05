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
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.vo.Files;

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
	
	//게시글 작성
	@Override
	public void create(Board b) throws BoardException {
		/*String title = b.getBoard_title();
		String content = b.getBoard_content();
		//*태그문자 처리(<==> &it; > == > &gt;)
		//replace(A,B)A를 B로 변경
		title = title.replace("<", "&lt;");
		title = title.replace("<", "&gt;");
		//*공백문자 처리
		title = title.replace("  ",    "&nbsp;&nbsp;");
		//*줄바꿈 문자 처리
		content = content.replace("\n", "<br>");
		b.setBoard_title(title);
		b.setBoard_content(content);*/
		System.out.println("service : " + b);
		boardDao.create(b);
		
		
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
	
	//댓글 작성
	@Override
	public void comment(Comments c) throws BoardException {
		boardDao.comment(c);
	}
	//댓글 조회
	@Override
	public List<HashMap<String, Object>> commentList(int board_no) throws BoardException {
		List<HashMap<String, Object>> commentList = boardDao.commentList(sqlSession, board_no) ;
		
		return commentList;
	}
	
	//게시글 작성시 사진 업로드
	@Override
	public void insertPhoto(Files file)  throws BoardException{
		boardDao.insertPhoto(sqlSession, file);
		
	}

}





























