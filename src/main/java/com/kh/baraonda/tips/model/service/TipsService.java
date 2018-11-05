package com.kh.baraonda.tips.model.service;

import java.util.ArrayList;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.tips.model.exception.TipsSelectListException;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;

public interface TipsService {
	
	//꿀팁 개수
	int selectTipsListCount();

	//꿀팁 리스트
	ArrayList<Tips> selectTipsList(PageInfo pgif) throws TipsSelectListException;
	
	//꿀팁 상세
	Tips selectTipsOne(String board_no);

	//댓글 수
	int selectCommentListCount(String board_no);
		
	//댓글 리스트
	ArrayList<TipsComment> selectComment(String board_no, PageInfo pgif);
	
	//꿀팁 검색 개수
	int searchTipsCount(SearchCondition sc);

	//꿀팁 검색 리스트
	ArrayList<Tips> searchTipsList(SearchCondition sc, PageInfo pgif);

}
