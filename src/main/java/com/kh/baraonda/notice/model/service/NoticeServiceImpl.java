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
}
