package com.kh.baraonda.tips.model.dao;

import java.util.ArrayList;


import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.tips.model.dao.TipsDao;
import com.kh.baraonda.tips.model.exception.TipsSelectListException;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;
import com.kh.baraonda.tips.model.vo.TipsMarking;

@Repository
public class TipsDaoImpl implements TipsDao{
	
	//꿀팁 개수
		@Override
		public int selectTipsListCount(SqlSessionTemplate sqlSession) {
			
			return sqlSession.selectOne("Tips.selectTipsListCount");
		}
		
		/*//게시글 전체 목록 조회
		@Override
		public List<HashMap<String, Object>> selectTipsList(SqlSessionTemplate sqlSession, int writing_type,  PageInfo pgif) throws TipsSelectListException  {
			try {
				List<HashMap<String, Object>> list = null;
				
				int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
				
				RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
				
				//HashMap<Key, value>
				list = (ArrayList)sqlSession.selectList("Tips.selectTipsList", writing_type, rowBounds);
				
				if(list == null) {
					sqlSession.close();
					throw new TipsSelectListException("리스트 값 널");
				}

				return list;
			}catch(Exception e) {
				throw new TipsSelectListException(e.getMessage());
			}
		}*/

		//꿀팁 리스트
		@Override
		public ArrayList<Tips> selectTipsList(SqlSessionTemplate sqlSession, PageInfo pgif) throws TipsSelectListException {
			ArrayList<Tips> list = null;
			
			//건너 뛸 게시물의 수
			int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
							
			RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
							
			//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
			//제네릭을 설정하면 오류가 나서 넣으면 안된다
			list = (ArrayList) sqlSession.selectList("Tips.selectTipsList", null, rowBounds);
							
			if(list == null){
				sqlSession.close();
				throw new TipsSelectListException("꿀팁 조회 실패");
			}
			
			return list;
		}

		
		//꿀팁 상세
		@Override
		public Tips selectTipsOne(SqlSessionTemplate sqlSession, String tips_no) {
			
			return sqlSession.selectOne("Tips.selectTipsOne",tips_no);
		}
		
		//좋아요 개수
		@Override
		public int selectHeartTips(SqlSessionTemplate sqlSession, String tips_no) {
			
			return sqlSession.selectOne("Tips.selectHeartTips", tips_no);
		}

		//댓글 수
		@Override
		public int selectCommentListCountTips(SqlSessionTemplate sqlSession,String tips_no) {
			
			return sqlSession.selectOne("Tips.selectCommentListCountTips", tips_no);
		}
		
		//댓글 리스트
		@Override
		public ArrayList<TipsComment> selectCommentTips(SqlSessionTemplate sqlSession, String tips_no, PageInfo pgif) {
			ArrayList<TipsComment> list = null;
			
			//건너 뛸 게시물의 수
			int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
							
			RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
							
			//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
			//제네릭을 설정하면 오류가 나서 넣으면 안된다
			list = (ArrayList) sqlSession.selectList("Tips.selectCommentTips", tips_no, rowBounds);
			
			return list;
		}
		
		//조회수 업데이트
		@Override
		public Tips updateTipsCount(SqlSessionTemplate sqlSession, String tips_no) {
			
			return sqlSession.selectOne("Tips.updateTipsCount", tips_no);
		}

		//꿀팁 검색 개수
		@Override
		public int searchTipsCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
			
			return sqlSession.selectOne("Tips.searchTipsCount",sc);
		}

		//꿀팁 검색 리스트
		@Override
		public ArrayList<Tips> searchTipsList(SqlSessionTemplate sqlSession, SearchCondition sc,PageInfo pgif) {
			ArrayList<Tips> list = null;
			
			//건너 뛸 게시물의 수
			int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
							
			RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
							
			//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
			//제네릭을 설정하면 오류가 나서 넣으면 안된다
			list = (ArrayList) sqlSession.selectList("Tips.searchTipsList", sc, rowBounds);
			
			return list;
		}
		
		
		//공지사항 insert
		@Override
		public int insertTips(SqlSessionTemplate sqlSession, Tips t) {
			int i = -99;
			sqlSession.selectOne("Tips.insertTips",t);
			i = 1;
			return i;
		}

		//공지사항 delete
		@Override
		public int deleteTips(SqlSessionTemplate sqlSession, String tips_no) {
			int i = -99;
			sqlSession.selectOne("Tips.deleteTips", tips_no);
			i = 1;
			return i;
		}

		//공지사항 update
		@Override
		public int updateTips(SqlSessionTemplate sqlSession, Tips t) {
			int i = -99;
			
			sqlSession.selectOne("Tips.updateTips",t);
			
			i = 1;
			
			return i;
		}

		//댓글 insert
		@Override
		public int insertCommentTips(SqlSessionTemplate sqlSession, TipsComment tc) {
			int i = -99;
			
			sqlSession.selectOne("Tips.insertCommentTips",tc);
			
			i = 1;
			
			return i;
		}

		//댓글 delete
		@Override
		public int deleteCommentTips(SqlSessionTemplate sqlSession, String tcomment_no) {
			int i = -99;
			
			sqlSession.selectOne("Tips.deleteCommentTips",tcomment_no);
			
			i = 1;
			
			return i;
		}

		//북마크 체크 여부
		@Override
		public int checkBookmarkTips(SqlSessionTemplate sqlSession, TipsMarking tm) {
			
			return sqlSession.selectOne("Tips.checkBookmarkTips", tm);
		}

		//북마크 등록
		@Override
		public int insertBookmarkTips(SqlSessionTemplate sqlSession, TipsMarking tm) {
			int i = -99;
			
			sqlSession.selectOne("Tips.insertBookmarkTips",tm);
			
			i = 1;
			
			return i;
		}

		//북마크 삭제
		@Override
		public int deleteBookmarkTips(SqlSessionTemplate sqlSession, TipsMarking tm) {
			int i = -99;
			
			sqlSession.selectOne("Tips.deleteBookmarkTips",tm);
			
			i = 1;
			
			return i;
		}

		//좋아요 체크 여부
		@Override
		public int checkHeartTips(SqlSessionTemplate sqlSession, TipsMarking tm) {
			
			return sqlSession.selectOne("Tips.checkHeartTips", tm);
		}

		//좋아요 등록
		@Override
		public int insertHeartTips(SqlSessionTemplate sqlSession, TipsMarking tm) {
			int i = -99;
			
			sqlSession.selectOne("Tips.insertHeartTips",tm);
			
			i = 1;
			
			return i;
		}

		//좋아요 삭제
		@Override
		public int deleteHeartTips(SqlSessionTemplate sqlSession, TipsMarking tm) {
			int i = -99;
			
			sqlSession.selectOne("Tips.deleteHeartTips",tm);
			
			i = 1;
			
			return i;
		}


		//다음글 번호 
		@Override
		public int selectNextNoTips(SqlSessionTemplate sqlSession, String tips_no) {
			String next = String.valueOf(sqlSession.selectOne("Tips.selectNextNoTips", tips_no));
			System.out.println("길이" + next.length());
			System.out.println(next);
			
			if(next.equals("null")) {
				System.out.println("????");
				return 0;
			}else{	
				int n = Integer.parseInt(next);
				System.out.println(n);
				return n;
			}
		}

		//이전글 번호
		@Override
		public int selectBeforeNoTips(SqlSessionTemplate sqlSession, String tips_no) {
			String before = null;
			before = String.valueOf(sqlSession.selectOne("Tips.selectBeforeNoTips", tips_no));
			if(before.equals("null")) {
				return 0;
			}else{
				int befo = Integer.parseInt(before);
				
				return befo;
			}
		}

		
		
}
