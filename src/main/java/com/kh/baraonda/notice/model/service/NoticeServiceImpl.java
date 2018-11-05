package com.kh.baraonda.notice.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.notice.model.dao.NoticeDao;
import com.kh.baraonda.notice.model.exception.NoticeException;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.notice.model.vo.NoticeComment;
import com.kh.baraonda.notice.model.vo.NoticeMarking;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private NoticeDao nd;
	
	//공지사항 개수
	@Override
	public int selectNoticeListCount() {
		
		return nd.selectNoticeListCount(sqlSession);
	}

	//공지사항 리스트
	@Override
	public ArrayList<Notice> selectNoticeList(PageInfo pgif) throws NoticeException {
		
		return nd.selectNoticeList(sqlSession, pgif);
	}

	//공지사항 상세
	@Override
	public Notice selectNoticeOne(String notice_no) {
		Notice update = nd.updateNoticeCount(sqlSession, notice_no);
		
		return nd.selectNoticeOne(sqlSession, notice_no);
	}
	
	//좋아요 수
	@Override
	public int selectHeart(String notice_no) {
		
		return nd.selectHeart(sqlSession, notice_no);
	}
	
	//댓글 수
	@Override
	public int selectCommentListCount(String notice_no) {
		
		return nd.selectCommentListCount(sqlSession, notice_no);
	}
	
	//댓글 리스트
	@Override
	public ArrayList<NoticeComment> selectComment(String notice_no, PageInfo pgif) {
		
		return nd.selectComment(sqlSession, notice_no, pgif);
	}

	//공지사항 검색 개수
	@Override
	public int searchNoticeCount(SearchCondition sc) {
		
		return nd.searchNoticeCount(sqlSession, sc);
	}

	//공지사항 검색 리스트
	@Override
	public ArrayList<Notice> searchNoticeList(SearchCondition sc,PageInfo pgif) {
		
		return nd.searchNoticeList(sqlSession, sc,pgif);
	}

	//공지사항 insert
	@Override
	public int insertNotice(Notice n) {
		
		return nd.insertNotice(sqlSession, n);
	}

	//공지사항 delete
	@Override
	public int deleteNotice(String notice_no) {
		
		return nd.deleteNotice(sqlSession, notice_no);
	}

	//공지사항 update
	@Override
	public int updateNotice(Notice n) {
		
		return nd.updateNotice(sqlSession, n);
	}

	//댓글 insert
	@Override
	public int insertComment(NoticeComment c) {
		
		return nd.insertComment(sqlSession,c);
	}

	//댓글 delete
	@Override
	public int deleteComment(String comment_no) {
		
		return nd.deleteComment(sqlSession, comment_no);
	}

	//북마크 체크 여부
	@Override
	public int checkBookmark(NoticeMarking nm) {
		
		return nd.checkBookmark(sqlSession,nm);
	}

	//북마크 등록
	@Override
	public int insertBookmark(NoticeMarking nm) {
		
		return nd.insertBookmark(sqlSession, nm);
	}

	//북마크 삭제
	@Override
	public int deleteBookmark(NoticeMarking nm) {
		
		return nd.deleteBookmark(sqlSession, nm);
	}

	//좋아요 체크 여부
	@Override
	public int checkHeart(NoticeMarking nm) {
		
		return nd.checkHeart(sqlSession, nm);
	}

	//좋아요 등록
	@Override
	public int insertHeart(NoticeMarking nm) {
		
		return nd.insertHeart(sqlSession, nm);
	}

	//좋아요 삭제
	@Override
	public int deleteHeart(NoticeMarking nm) {
		
		return nd.deleteHeart(sqlSession, nm);
	}

	//다음글
	@Override
	public Notice selectNextBoard(String notice_no) {
		int nextno= nd.selectNextNo(sqlSession,notice_no);
		
		return nd.selectNoticeOne(sqlSession, String.valueOf(nextno));
	}

	//이전글
	@Override
	public Notice selectBeforeBoard(String notice_no) {
		int beforeno= nd.selectBeforeNo(sqlSession,notice_no);
		return nd.selectNoticeOne(sqlSession, String.valueOf(beforeno));
	}


}
