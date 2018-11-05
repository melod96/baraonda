package com.kh.baraonda.notice.model.service;

import java.util.ArrayList;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.notice.model.exception.NoticeException;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.notice.model.vo.NoticeComment;

public interface NoticeService {

	//공지사항 개수
	int selectNoticeListCount();

	//공지사항 리스트
	ArrayList<Notice> selectNoticeList(PageInfo pgif) throws NoticeException;

	//공지사항 상세
	Notice selectNoticeOne(String notice_no);

	//댓글 수
	int selectCommentListCount(String notice_no);
	
	//댓글 리스트
	ArrayList<NoticeComment> selectComment(String notice_no, PageInfo pgif);
	
	//공지사항 검색 개수
	int searchNoticeCount(SearchCondition sc);

	//공지사항 검색 리스트
	ArrayList<Notice> searchNoticeList(SearchCondition sc, PageInfo pgif);

	//공지사항 insert
	int insertNotice(Notice n);

	//공지사항 delete
	int deleteNotice(String notice_no);



}
