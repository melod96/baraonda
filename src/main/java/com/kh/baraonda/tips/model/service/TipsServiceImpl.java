package com.kh.baraonda.tips.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.tips.model.vo.TipsFiles;
import com.kh.baraonda.tips.model.dao.TipsDao;
import com.kh.baraonda.tips.model.exception.TipsSelectListException;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;
import com.kh.baraonda.tips.model.vo.TipsMarking;




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
		
	//꿀팁 개수
		@Override
		public int selectTypeTipsListCount(int writing_type) {
			
			return td.selectTypeTipsListCount(sqlSession, writing_type);
		}	
		


		@Override
		public ArrayList<Tips> selectTypeTipsList(int writing_type, PageInfo pgif) throws TipsSelectListException {
			
			return td.selectTypeTipsList(sqlSession, pgif, writing_type);
		}

		//꿀팁 리스트
		@Override
		public ArrayList<Tips> selectTipsList(PageInfo pgif) throws TipsSelectListException {
			
			return td.selectTipsList(sqlSession, pgif);
		}
		
		/*
		//게시글 전체 목록 조회
		@Override
		public List<HashMap<String, Object>> selectTipsList(int writing_type, PageInfo pgif) throws TipsSelectListException {
			List<HashMap<String, Object>> list = td.selectTipsList(sqlSession, writing_type, pgif) ;
			
			return list;
		}*/
		

		//꿀팁 상세
		@Override
		public Tips selectTipsOne(String tips_no) {
			Tips update = td.updateTipsCount(sqlSession, tips_no);
			
			return td.selectTipsOne(sqlSession, tips_no);
		}
		
		//좋아요 수
		@Override
		public int selectHeartTips(String tips_no) {
			
			return td.selectHeartTips(sqlSession, tips_no);
		}
		
		//댓글 수
		@Override
		public int selectCommentListCountTips(String tips_no) {
			
			return td.selectCommentListCountTips(sqlSession, tips_no);
		}
		
		//댓글 리스트
		@Override
		public ArrayList<TipsComment> selectCommentTips(String tips_no, PageInfo pgif) {
			
			return td.selectCommentTips(sqlSession, tips_no, pgif);
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
		
		
		
		
		//공지사항 insert
		@Override
		public int insertTips(Tips t) {
			System.out.println("service t  :" + t);
			return td.insertTips(sqlSession, t);
		}
		
		//파일 업로드
		@Override
		public void insertPhoto(TipsFiles file) {
			td.insertPhoto(sqlSession, file);
		}
		
		//파일 업로드 수정
				@Override
				public void updatePhoto(TipsFiles file) {
					td.updatePhoto(sqlSession, file);
				}


		//공지사항 delete
		@Override
		public int deleteTips(String tips_no) {
			
			return td.deleteTips(sqlSession, tips_no);
		}

		//공지사항 update
		@Override
		public int updateTips(Tips t) {
			
			return td.updateTips(sqlSession, t);
		}

		//댓글 insert
		@Override
		public int insertCommentTips(TipsComment tc) {
			
			return td.insertCommentTips(sqlSession,tc);
		}

		//댓글 delete
		@Override
		public int deleteCommentTips(String tcomment_no) {
			
			return td.deleteCommentTips(sqlSession, tcomment_no);
		}

		//북마크 체크 여부
		@Override
		public int checkBookmarkTips(TipsMarking tm) {
			
			return td.checkBookmarkTips(sqlSession,tm);
		}

		//북마크 등록
		@Override
		public int insertBookmarkTips(TipsMarking tm) {
			
			return td.insertBookmarkTips(sqlSession, tm);
		}

		//북마크 삭제
		@Override
		public int deleteBookmarkTips(TipsMarking tm) {
			
			return td.deleteBookmarkTips(sqlSession, tm);
		}

		//좋아요 체크 여부
		@Override
		public int checkHeartTips(TipsMarking tm) {
			
			return td.checkHeartTips(sqlSession, tm);
		}

		//좋아요 등록
		@Override
		public int insertHeartTips(TipsMarking tm) {
			
			return td.insertHeartTips(sqlSession, tm);
		}

		//좋아요 삭제
		@Override
		public int deleteHeartTips(TipsMarking tm) {
			
			return td.deleteHeartTips(sqlSession, tm);
		}

		//다음글
		@Override
		public Tips selectNextNoTips(String tips_no) {
			int nextno= td.selectNextNoTips(sqlSession,tips_no);
			
			return td.selectTipsOne(sqlSession, String.valueOf(nextno));
		}

		//이전글
		@Override
		public Tips selectBeforeNoTips(String tips_no) {
			int beforeno= td.selectBeforeNoTips(sqlSession,tips_no);
			return td.selectTipsOne(sqlSession, String.valueOf(beforeno));
		}

		
		

}
