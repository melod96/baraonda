package com.kh.baraonda.tips.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.tips.model.exception.TipsSelectListException;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;

public interface TipsDao {

	//꿀팁 개수
	int selectTipsListCount(SqlSessionTemplate sqlSession);

	//꿀팁 리스트
	ArrayList<Tips> selectTipsList(SqlSessionTemplate sqlSession, PageInfo pgif) throws TipsSelectListException;
	
	//꿀팁 상세
	Tips selectTipsOne(SqlSessionTemplate sqlSession, String board_no);

	//댓글 수
	int selectCommentListCount(SqlSessionTemplate sqlSession, String board_no);
	
	//댓글 리스트
	ArrayList<TipsComment> selectComment(SqlSessionTemplate sqlSession, String board_no, PageInfo pgif);

	//조회수 업데이트
	Tips updateTipsCount(SqlSessionTemplate sqlSession, String board_no);

	//꿀팁 검색 개수
	int searchTipsCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	//꿀팁 검색 리스트
	ArrayList<Tips> searchTipsList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pgif);

}
