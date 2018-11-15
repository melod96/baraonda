package com.kh.baraonda.tips.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.tips.model.vo.TipsFiles;
import com.kh.baraonda.tips.model.exception.TipsSelectListException;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;
import com.kh.baraonda.tips.model.vo.TipsMarking;

public interface TipsDao {

	//꿀팁 개수
	int selectTipsListCount(SqlSessionTemplate sqlSession);

	//꿀팁 리스트
	ArrayList<Tips> selectTipsList(SqlSessionTemplate sqlSession, PageInfo pgif) throws TipsSelectListException;
	
	/*//게시글 전체 목록 조회
	public List<HashMap<String, Object>> selectTipsList(SqlSessionTemplate sqlSession, int writing_type, PageInfo pgif) throws TipsSelectListException;*/
	
	//꿀팁 상세
	Tips selectTipsOne(SqlSessionTemplate sqlSession, String tips_no);
	
	//좋아요 개수
	int selectHeartTips(SqlSessionTemplate sqlSession, String tips_no);

	//댓글 수
	int selectCommentListCountTips(SqlSessionTemplate sqlSession, String tips_no);
	
	//댓글 리스트
	ArrayList<TipsComment> selectCommentTips(SqlSessionTemplate sqlSession, String tips_no, PageInfo pgif);

	//조회수 업데이트
	Tips updateTipsCount(SqlSessionTemplate sqlSession, String tips_no);

	//꿀팁 검색 개수
	int searchTipsCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	//꿀팁 검색 리스트
	ArrayList<Tips> searchTipsList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pgif);
	
		//공지사항 insert
		int insertTips(SqlSessionTemplate sqlSession, Tips t);
		
		//파일 업로드
		void insertPhoto(SqlSessionTemplate sqlSession, TipsFiles file);
		//파일 수정
				void updatePhoto(SqlSessionTemplate sqlSession, TipsFiles file);

		//공지사항 delete
		int deleteTips(SqlSessionTemplate sqlSession, String tips_no);

		//공지사항 update
		int updateTips(SqlSessionTemplate sqlSession, Tips t);

		//댓글 insert
		int insertCommentTips(SqlSessionTemplate sqlSession, TipsComment tc);

		//댓글 delete
		int deleteCommentTips(SqlSessionTemplate sqlSession, String tcomment_no);

		//북마크 체크 여부
		int checkBookmarkTips(SqlSessionTemplate sqlSession, TipsMarking tm);

		//북마크 등록
		int insertBookmarkTips(SqlSessionTemplate sqlSession, TipsMarking tm);

		//북마크 삭제
		int deleteBookmarkTips(SqlSessionTemplate sqlSession, TipsMarking tm);

		//좋아요 체크 여부
		int checkHeartTips(SqlSessionTemplate sqlSession, TipsMarking tm);

		//좋아요 등록
		int insertHeartTips(SqlSessionTemplate sqlSession, TipsMarking tm);

		//좋아요 삭제
		int deleteHeartTips(SqlSessionTemplate sqlSession, TipsMarking tm);

		//다음글 번호
		int selectNextNoTips(SqlSessionTemplate sqlSession, String tips_no);

		//이전글 번호
		int selectBeforeNoTips(SqlSessionTemplate sqlSession, String tips_no);

}
