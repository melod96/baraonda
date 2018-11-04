package com.kh.baraonda.notice.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.notice.model.exception.NoticeException;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.notice.model.vo.NoticeComment;

public interface NoticeDao {

	//공지사항 개수
	int selectNoticeListCount(SqlSessionTemplate sqlSession);

	//공지사항 리스트
	ArrayList<Notice> selectNoticeList(SqlSessionTemplate sqlSession, PageInfo pgif) throws NoticeException;

	//공지사항 상세
	Notice selectNoticeOne(SqlSessionTemplate sqlSession, String notice_no);

	//댓글 수
	int selectCommentListCount(SqlSessionTemplate sqlSession, String notice_no);
	
	//댓글 리스트
	ArrayList<NoticeComment> selectComment(SqlSessionTemplate sqlSession, String notice_no, PageInfo pgif);

	//조회수 업데이트
	Notice updateNoticeCount(SqlSessionTemplate sqlSession, String notice_no);

	//공지사항 검색 개수
	int searchNoticeCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	//공지사항 검색 리스트
	ArrayList<Notice> searchNoticeList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pgif);

	//공지사항 insert
	int insertNotice(SqlSessionTemplate sqlSession, Notice n);

	//공지사항 delete
	int deleteNotice(SqlSessionTemplate sqlSession, String notice_no);



}
