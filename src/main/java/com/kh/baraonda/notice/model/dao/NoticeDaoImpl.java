package com.kh.baraonda.notice.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.exchange.model.vo.Point_Record;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.notice.model.exception.NoticeException;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.notice.model.vo.NoticeComment;
import com.kh.baraonda.notice.model.vo.NoticeMarking;

@Repository
public class NoticeDaoImpl implements NoticeDao{

	//공지사항 개수
	@Override
	public int selectNoticeListCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("Notice2.selectNoticeListCount");
	}

	//공지사항 리스트
	@Override
	public ArrayList<Notice> selectNoticeList(SqlSessionTemplate sqlSession, PageInfo pgif) throws NoticeException {
		ArrayList<Notice> list = null;
		
		//건너 뛸 게시물의 수
		int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
						
		RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
						
		//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
		//제네릭을 설정하면 오류가 나서 넣으면 안된다
		list = (ArrayList) sqlSession.selectList("Notice2.selectNoticeList", null, rowBounds);
						
		if(list == null){
			sqlSession.close();
			throw new NoticeException("공지사항 조회 실패");
		}
		
		return list;
	}

	//공지사항 상세
	@Override
	public Notice selectNoticeOne(SqlSessionTemplate sqlSession, String notice_no) {
		
		return sqlSession.selectOne("Notice2.selectNoticeOne",notice_no);
	}
	
	//좋아요 개수
	@Override
	public int selectHeart(SqlSessionTemplate sqlSession, String notice_no) {
		
		return sqlSession.selectOne("Notice2.selectHeart", notice_no);
	}

	//댓글 수
	@Override
	public int selectCommentListCount(SqlSessionTemplate sqlSession,String notice_no) {
		
		return sqlSession.selectOne("Notice2.selectCommentListCount", notice_no);
	}
	
	//댓글 리스트
	@Override
	public ArrayList<NoticeComment> selectComment(SqlSessionTemplate sqlSession, String notice_no, PageInfo pgif) {
		ArrayList<NoticeComment> list = null;
		
		//건너 뛸 게시물의 수
		int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
						
		RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
						
		//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
		//제네릭을 설정하면 오류가 나서 넣으면 안된다
		list = (ArrayList) sqlSession.selectList("Notice2.selectComment", notice_no, rowBounds);
		
		return list;
	}
	
	//조회수 업데이트
	@Override
	public Notice updateNoticeCount(SqlSessionTemplate sqlSession, String notice_no) {
		
		return sqlSession.selectOne("Notice2.updateNoticeCount", notice_no);
	}

	//공지사항 검색 개수
	@Override
	public int searchNoticeCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		
		return sqlSession.selectOne("Notice2.searchNoticeCount",sc);
	}

	//공지사항 검색 리스트
	@Override
	public ArrayList<Notice> searchNoticeList(SqlSessionTemplate sqlSession, SearchCondition sc,PageInfo pgif) {
		ArrayList<Notice> list = null;
		
		//건너 뛸 게시물의 수
		int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
						
		RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
						
		//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
		//제네릭을 설정하면 오류가 나서 넣으면 안된다
		list = (ArrayList) sqlSession.selectList("Notice2.searchNoticeList", sc, rowBounds);
		
		return list;
	}

	//공지사항 insert
	@Override
	public int insertNotice(SqlSessionTemplate sqlSession, Notice n) {
		int i = -99;
		sqlSession.selectOne("Notice2.insertNotice",n);
		i = 1;
		return i;
	}

	//공지사항 delete
	@Override
	public int deleteNotice(SqlSessionTemplate sqlSession, String notice_no) {
		int i = -99;
		sqlSession.selectOne("Notice2.deleteNotice", notice_no);
		i = 1;
		return i;
	}

	//공지사항 update
	@Override
	public int updateNotice(SqlSessionTemplate sqlSession, Notice n) {
		int i = -99;
		
		sqlSession.selectOne("Notice2.updateNotice",n);
		
		i = 1;
		
		return i;
	}

	//댓글 insert
	@Override
	public int insertComment(SqlSessionTemplate sqlSession, NoticeComment c) {
		int i = -99;
		
		sqlSession.selectOne("Notice2.insertComment",c);
		
		i = 1;
		
		return i;
	}

	//댓글 delete
	@Override
	public int deleteComment(SqlSessionTemplate sqlSession, String comment_no) {
		int i = -99;
		
		sqlSession.selectOne("Notice2.deleteComment",comment_no);
		
		i = 1;
		
		return i;
	}

	//북마크 체크 여부
	@Override
	public int checkBookmark(SqlSessionTemplate sqlSession, NoticeMarking nm) {
		
		return sqlSession.selectOne("Notice2.checkBookmark", nm);
	}

	//북마크 등록
	@Override
	public int insertBookmark(SqlSessionTemplate sqlSession, NoticeMarking nm) {
		int i = -99;
		
		sqlSession.selectOne("Notice2.insertBookmark",nm);
		
		i = 1;
		
		return i;
	}

	//북마크 삭제
	@Override
	public int deleteBookmark(SqlSessionTemplate sqlSession, NoticeMarking nm) {
		int i = -99;
		
		sqlSession.selectOne("Notice2.deleteBookmark",nm);
		
		i = 1;
		
		return i;
	}

	//좋아요 체크 여부
	@Override
	public int checkHeart(SqlSessionTemplate sqlSession, NoticeMarking nm) {
		
		return sqlSession.selectOne("Notice2.checkHeart", nm);
	}

	//좋아요 등록
	@Override
	public int insertHeart(SqlSessionTemplate sqlSession, NoticeMarking nm) {
		int i = -99;
		
		sqlSession.selectOne("Notice2.insertHeart",nm);
		
		i = 1;
		
		return i;
	}

	//좋아요 삭제
	@Override
	public int deleteHeart(SqlSessionTemplate sqlSession, NoticeMarking nm) {
		int i = -99;
		
		sqlSession.selectOne("Notice2.deleteHeart",nm);
		
		i = 1;
		
		return i;
	}

	//다음글 번호 
	@Override
	public int selectNextNo(SqlSessionTemplate sqlSession, String notice_no) {
		String next = String.valueOf(sqlSession.selectOne("Notice2.selectNextNo", notice_no));
		System.out.println("길이" + next.length());
		System.out.println(next);
		
		if(next.equals("null")) {
			System.out.println("????");
			return 0;
		}else{	
			int n = Integer.parseInt(next);
			System.out.println(n);
			return n;
		}
	}

	//이전글 번호
	@Override
	public int selectBeforeNo(SqlSessionTemplate sqlSession, String notice_no) {
		String before = null;
		before = String.valueOf(sqlSession.selectOne("Notice2.selectBeforeNo", notice_no));
		if(before.equals("null")) {
			return 0;
		}else{
			int befo = Integer.parseInt(before);
			
			return befo;
		}
	}

	//포인트 이력 insert
	@Override
	public void insertPointRecord(SqlSessionTemplate sqlSession, Point_Record pr) {
		sqlSession.insert("Notice2.insertPointRecord", pr);
	}

	//포인트 update
	@Override
	public void updatePoint(SqlSessionTemplate sqlSession, Point_Record pr) {
		sqlSession.update("Notice2.updatePoint", pr);
		
	}

	

}
