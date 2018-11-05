package com.kh.baraonda.tips.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.tips.model.dao.TipsDao;
import com.kh.baraonda.tips.model.exception.TipsSelectListException;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;




@Service
public class TipsServiceImpl implements TipsService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private TipsDao td;
	
	
	//꿀팁 개수
		@Override
		public int selectTipsListCount() {
			
			return td.selectTipsListCount(sqlSession);
		}

		//꿀팁 리스트
		@Override
		public ArrayList<Tips> selectTipsList(PageInfo pgif) throws TipsSelectListException {
			
			return td.selectTipsList(sqlSession, pgif);
		}

		//꿀팁 상세
		@Override
		public Tips selectTipsOne(String board_no) {
			Tips update = td.updateTipsCount(sqlSession, board_no);
			
			return td.selectTipsOne(sqlSession, board_no);
		}
		
		//댓글 수
		@Override
		public int selectCommentListCount(String board_no) {
			
			return td.selectCommentListCount(sqlSession, board_no);
		}
		
		//댓글 리스트
		@Override
		public ArrayList<TipsComment> selectComment(String board_no, PageInfo pgif) {
			
			return td.selectComment(sqlSession, board_no, pgif);
		}

		//꿀팁 검색 개수
		@Override
		public int searchTipsCount(SearchCondition sc) {
			
			return td.searchTipsCount(sqlSession, sc);
		}

		//꿀팁 검색 리스트
		@Override
		public ArrayList<Tips> searchTipsList(SearchCondition sc,PageInfo pgif) {
			
			return td.searchTipsList(sqlSession, sc,pgif);
		}
		

}
