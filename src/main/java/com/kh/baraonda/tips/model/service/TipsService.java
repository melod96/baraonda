package com.kh.baraonda.tips.model.service;

import java.util.ArrayList;


import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.tips.model.vo.TipsFiles;
import com.kh.baraonda.tips.model.exception.TipsSelectListException;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;
import com.kh.baraonda.tips.model.vo.TipsMarking;

public interface TipsService {
	
	//꿀팁 개수
	int selectTipsListCount();

	//꿀팁 리스트
	ArrayList<Tips> selectTipsList(PageInfo pgif) throws TipsSelectListException;
	
/*	//게시글 전체 목록 조회
	public List<HashMap<String, Object>> selectTipsList(int writing_type, PageInfo pgif) throws TipsSelectListException;*/
	
	//꿀팁 상세
	Tips selectTipsOne(String tips_no);
	
	//좋아요 개수
	int selectHeartTips(String tips_no);

	//댓글 수
	int selectCommentListCountTips(String tips_no);
		
	//댓글 리스트
	ArrayList<TipsComment> selectCommentTips(String tips_no, PageInfo pgif);
	
	//꿀팁 검색 개수
	int searchTipsCount(SearchCondition sc);

	//꿀팁 검색 리스트
	ArrayList<Tips> searchTipsList(SearchCondition sc, PageInfo pgif);
	
	
	
		//꿀팁 insert
		int insertTips(Tips t);
		
		//파일 업로드
		void insertPhoto(TipsFiles file);
		
		//파일 업로드 수정
		void updatePhoto(TipsFiles file);

		//꿀팁 delete
		int deleteTips(String tips_no);

		//꿀팁 update
		int updateTips(Tips t);

		//꿀팁 insert
		int insertCommentTips(TipsComment tc);

		//꿀팁 delete
		int deleteCommentTips(String tcomment_no);

		//북마크 체크 여부
		int checkBookmarkTips(TipsMarking tm);

		//북마크 등록
		int insertBookmarkTips(TipsMarking tm);

		//북마크 삭제
		int deleteBookmarkTips(TipsMarking tm);

		//좋아요 체크 여부
		int checkHeartTips(TipsMarking tm);

		//좋아요 등록
		int insertHeartTips(TipsMarking tm);

		//좋아요 삭제
		int deleteHeartTips(TipsMarking tm);

		//다음글
		Tips selectNextNoTips(String tips_no);

		//이전글
		Tips selectBeforeNoTips(String tips_no);


}
