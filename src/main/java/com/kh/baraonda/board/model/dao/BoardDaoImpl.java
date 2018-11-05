package com.kh.baraonda.board.model.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import com.kh.baraonda.board.model.exception.BoardException;
import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.board.model.vo.Comments;
import com.kh.baraonda.common.PageInfo;
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
			int offset = (info.getCurrentPage() -1) * info.getLimit();
			
			RowBounds rowBounds = new RowBounds(offset, info.getLimit());
			
			//HashMap<Key, value>
			List<HashMap<String, Object>> list = sqlSession.selectList("Board.listAll", writing_type, rowBounds);
			System.out.println("전체목록 조회 : " + list);
			if(list == null) {
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

	//게시글 작성
	@Override
	public void create(Board b) throws BoardException {
		System.out.println("dao : " + b);
		SqlSession.insert("Board.insert", b);
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
			//HashMap<Key, value>
			/*List<HashMap<String, Object>> detail = sqlSession.selectOne("Board.detail", board_no);*/
			System.out.println("board_no : "+ board_no);
			/*List<HashMap<String, Object>> detail = sqlSession.selectList("Board.detail", board_no);*/
			HashMap<String, Object> detail = sqlSession.selectOne("Board.detail", board_no);
			System.out.println("detail : " + detail);
			
			
			
			if(detail == null) {
				throw new BoardException("리스트 값 널");
			}

			return detail;
		}catch(Exception e) {
			throw new BoardException(e.getMessage());
		}
	}
	
	//댓글 작성
	@Override
	public void comment(Comments c) throws BoardException {
		SqlSession.insert("Board.commentInsert", c);
		
	}
	//댓글 조회
	@Override
	public List<HashMap<String, Object>> commentList(SqlSessionTemplate sqlSession, int board_no) throws BoardException {
		try {
			//HashMap<Key, value>
			
			List<HashMap<String, Object>> commentList = sqlSession.selectList("Board.commentList", board_no);
			
			System.out.println("commentList : " + commentList);
			
			if(commentList == null) {
				throw new BoardException("리스트 값 널");
			}

			return commentList;
		}catch(Exception e) {
			throw new BoardException(e.getMessage());
		}
	}
	
	//게시글 작성시 사진 업로드
	@Override
	public void insertPhoto(SqlSessionTemplate sqlSession, Files file) throws BoardException{
		sqlSession.insert("board.insertPhoto", file);
		
	}

}

















