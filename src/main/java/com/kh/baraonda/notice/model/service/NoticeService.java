package com.kh.baraonda.notice.model.service;

import java.util.ArrayList;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.notice.model.exception.NoticeException;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.notice.model.vo.NoticeComment;
import com.kh.baraonda.notice.model.vo.NoticeMarking;

public interface NoticeService {

	//공지사항 개수
	int selectNoticeListCount();

	//공지사항 리스트
	ArrayList<Notice> selectNoticeList(PageInfo pgif) throws NoticeException;

	//공지사항 상세
	Notice selectNoticeOne(String notice_no);

	//좋아요 수
	int selectHeart(String notice_no);

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

	//공지사항 update
	int updateNotice(Notice n);

	//댓글 insert
	int insertComment(NoticeComment c);

	//댓글 delete
	int deleteComment(String comment_no);

	//북마크 체크 여부
	int checkBookmark(NoticeMarking nm);

	//북마크 등록
	int insertBookmark(NoticeMarking nm);

	//북마크 삭제
	int deleteBookmark(NoticeMarking nm);

	//좋아요 체크 여부
	int checkHeart(NoticeMarking nm);

	//좋아요 등록
	int insertHeart(NoticeMarking nm);

	//좋아요 삭제
	int deleteHeart(NoticeMarking nm);

	//다음글
	Notice selectNextBoard(String notice_no);

	//이전글
	Notice selectBeforeBoard(String notice_no);




}
