package com.kh.baraonda.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.board.model.vo.Comments;
import com.kh.baraonda.board.model.vo.HomeFiles;
import com.kh.baraonda.board.model.vo.Report;
import com.kh.baraonda.board.model.vo.boardMarking;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.vo.Files;
import com.kh.baraonda.tips.model.exception.TipsSelectListException;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Inject
	SqlSession SqlSession;

	//게시글 전체 목록 조회
	@Override
	public List<HashMap<String, Object>> listAll(SqlSessionTemplate sqlSession, int writing_type,  PageInfo info) throws BoardException  {
		try {
			List<HashMap<String, Object>> list = null;
			
			int offset = (info.getCurrentPage() -1) * info.getLimit();
			
			RowBounds rowBounds = new RowBounds(offset, info.getLimit());
			
			//HashMap<Key, value>
			list = sqlSession.selectList("Board.listAll", writing_type, rowBounds);
			
			if(list == null) {
				sqlSession.close();
				throw new BoardException("리스트 값 널");
			}

			return list;
		}catch(Exception e) {
			throw new BoardException(e.getMessage());
		}
	}
	//게시글 페이징 처리
	@Override
	public int selectBoardListCount(SqlSessionTemplate sqlSession, int writing_type) {
		return sqlSession.selectOne("Board.selectBoardListCount", writing_type);
	}

	//게시글 insert
	@Override
	public void create(Board b) throws BoardException {
		SqlSession.insert("Board.insertBoard", b);
	}
	//게시글 update
	@Override
	public void updateBoard(Board b) throws BoardException {
		SqlSession.selectOne("Board.updateBoard", b);
	}
	//게시글 delete
	@Override
	public void deleteBoard(int board_no) throws BoardException{
		SqlSession.selectOne("Board.deleteBoard", board_no);
	}
	
	
	//게시글 조회수 증가
	@Override
	public void increaseViewCnt(int board_no) throws BoardException{
		SqlSession.update("Board.increaseViewCnt", board_no);
		
	}

	//게시글 상세 보기
	/*public List<HashMap<String, Object>> detail(SqlSessionTemplate sqlSession, int board_no) throws BoardException {*/
	public HashMap<String, Object> detail(SqlSessionTemplate sqlSession, int board_no) throws BoardException {
		try {
			HashMap<String, Object> detail = sqlSession.selectOne("Board.detail", board_no);
			
			if(detail == null) {
				throw new BoardException("리스트 값 널");
			}

			return detail;
		}catch(Exception e) {
			throw new BoardException(e.getMessage());
		}
	}

	//댓글 조회
	@Override
	public List<HashMap<String, Object>> commentList(SqlSessionTemplate sqlSession, int board_no, PageInfo info) throws BoardException {
		//건너 뛸 게시물의 수
		int offset = (info.getCurrentPage() -1) * info.getLimit();
						
		RowBounds rowBounds = new RowBounds(offset, info.getLimit());
		
		try {
			List<HashMap<String, Object>> commentList = sqlSession.selectList("Board.commentList", board_no, rowBounds);
			
			if(commentList == null) {
				throw new BoardException("리스트 값 널");
			}

			return commentList;
		}catch(Exception e) {
			throw new BoardException(e.getMessage());
		}
	}
	
	//댓글 insert
	@Override
	public int insertComment(SqlSessionTemplate sqlSession, Comments c) {
		int i = -99;
		
		sqlSession.selectOne("Board.insertComment", c);
		
		i = 1;
		
		return i;
	}
	//댓글 delete
	@Override
	public int deleteComment(SqlSessionTemplate sqlSession, int comments_no) {
		int i = -99;
		
		sqlSession.selectOne("Board.deleteComment", comments_no);
		
		i = 1;
		
		return i;
	}
	
	//좋아요 수 
	@Override
	public int selectLike(SqlSessionTemplate sqlSession, int board_no) throws BoardException{
		return sqlSession.selectOne("Board.selectLike", board_no);
	}
	//좋아요 체크 여부
	@Override
	public int checkLike(SqlSessionTemplate sqlSession, boardMarking bm) {
		return sqlSession.selectOne("Board.checkLike", bm);
	}
	//좋아요 등록
	@Override
	public int insertLike(SqlSessionTemplate sqlSession, boardMarking bm) {
		int i = -99;
		
		sqlSession.selectOne("Board.insertLike", bm);
		
		i = 1;
		
		return i;
	}
	//좋아요 삭제
	@Override
	public int deleteLike(SqlSessionTemplate sqlSession, boardMarking bm) {
		int i = -99;
		
		sqlSession.selectOne("Board.deleteLike", bm);
		
		i = 1;
		
		return i;
	}
	
	//북마크 체크여부
	@Override
	public int checkBookMark(SqlSessionTemplate sqlSession, boardMarking bm) {
		return sqlSession.selectOne("Board.checkBookMark", bm);
	}
	//북마크 insert
	@Override
	public int insertBookMark(SqlSessionTemplate sqlSession, boardMarking bm) {
		int i = -99;
		
		sqlSession.selectOne("Board.insertBookMark", bm);
		
		i = 1;
		 
		return i;
	}
	//북마크 delete
	@Override
	public int deleteBookMark(SqlSessionTemplate sqlSession, boardMarking bm) {
		int i = -99;
		
		sqlSession.selectOne("Board.deleteBookMark", bm);
		
		i = 1;
		
		return i;
	}
	
	//게시글 검색 개수
	@Override
	public int searchBoardCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return sqlSession.selectOne("Board.searchBoardCount", sc);
	}
	@Override
	public List<HashMap<String, Object>> searchList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo info) {
		
		List<HashMap<String, Object>> list = null;
		
		int offset = (info.getCurrentPage() - 1) * info.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, info.getLimit());
		
		list = sqlSession.selectList("Board.searchBoardList", sc, rowBounds);
		
		return list;
	}
	//댓글 수
	@Override
	public int commentListCount(SqlSessionTemplate sqlSession, int board_no) {
		return sqlSession.selectOne("Board.commentListCount", board_no);
	}
	
	//홈트레이닝 게시물 목록 조회
	@Override
	public ArrayList<Board> selectHomeList(SqlSessionTemplate sqlSession, PageInfo info, int writing_type) throws BoardException {
		ArrayList<Board> list = null;

		//건너 뛸 게시물의 수
		int offset = (info.getCurrentPage() -1) * info.getLimit();
						
		RowBounds rowBounds = new RowBounds(offset, info.getLimit());
						
		//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
		//제네릭을 설정하면 오류가 나서 넣으면 안된다
		list = (ArrayList) sqlSession.selectList("Board.selectHomeList", writing_type, rowBounds);
						
		if(list == null){
			sqlSession.close();
			throw new BoardException("조회 실패");
		}
		
		return list;
	}
	//홈트레이닝 게시글 작성
	@Override
	public int insertHome(SqlSessionTemplate sqlSession, Board b) {
		sqlSession.insert("Board.insertHome", b);
		
		return b.getF_reference_no();
	}
	//파일 업로드
	@Override
	public void insertPhoto(SqlSessionTemplate sqlSession, HomeFiles file) {
		sqlSession.insert("Board.insertPhoto", file);
	}
	@Override
	public void adminDelete(SqlSessionTemplate sqlSession, List<String> valueArr) {
		SqlSession.selectList("Board.adminDelete", valueArr);
		
	}
	
	//게시글 신고
	@Override
	public void report(SqlSessionTemplate sqlSession, Report r) {
		sqlSession.selectOne("Board.report", r);
	}


}

















