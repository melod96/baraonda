package com.kh.baraonda.notice.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.notice.model.exception.NoticeException;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.notice.model.vo.NoticeComment;
import com.kh.baraonda.notice.model.vo.NoticeMarking;

public interface NoticeDao {

	//공지사항 개수
	int selectNoticeListCount(SqlSessionTemplate sqlSession);

	//공지사항 리스트
	ArrayList<Notice> selectNoticeList(SqlSessionTemplate sqlSession, PageInfo pgif) throws NoticeException;

	//공지사항 상세
	Notice selectNoticeOne(SqlSessionTemplate sqlSession, String notice_no);

	//좋아요 개수
	int selectHeart(SqlSessionTemplate sqlSession, String notice_no);

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

	//공지사항 update
	int updateNotice(SqlSessionTemplate sqlSession, Notice n);

	//댓글 insert
	int insertComment(SqlSessionTemplate sqlSession, NoticeComment c);

	//댓글 delete
	int deleteComment(SqlSessionTemplate sqlSession, String comment_no);

	//북마크 체크 여부
	int checkBookmark(SqlSessionTemplate sqlSession, NoticeMarking nm);

	//북마크 등록
	int insertBookmark(SqlSessionTemplate sqlSession, NoticeMarking nm);

	//북마크 삭제
	int deleteBookmark(SqlSessionTemplate sqlSession, NoticeMarking nm);

	//좋아요 체크 여부
	int checkHeart(SqlSessionTemplate sqlSession, NoticeMarking nm);

	//좋아요 등록
	int insertHeart(SqlSessionTemplate sqlSession, NoticeMarking nm);

	//좋아요 삭제
	int deleteHeart(SqlSessionTemplate sqlSession, NoticeMarking nm);

	//다음글 번호
	int selectNextNo(SqlSessionTemplate sqlSession, String notice_no);

	//이전글 번호
	int selectBeforeNo(SqlSessionTemplate sqlSession, String notice_no);





}
