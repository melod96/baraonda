package com.kh.baraonda.board.model.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.board.model.vo.Comments;
import com.kh.baraonda.board.model.vo.boardMarking;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.vo.Files;

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
	public int selectBoardListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("Board.selectBoardListCount");
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
	public List<HashMap<String, Object>> commentList(SqlSessionTemplate sqlSession, int board_no) throws BoardException {
		try {
			List<HashMap<String, Object>> commentList = sqlSession.selectList("Board.commentList", board_no);
			
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
	public List<HashMap<String, Object>> searchList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo info,
			int writing_type) {
		// TODO Auto-generated method stub
		return null;
	}



}

















