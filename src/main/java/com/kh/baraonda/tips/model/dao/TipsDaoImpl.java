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

@Repository
public class TipsDaoImpl implements TipsDao{
	
	//꿀팁 개수
		@Override
		public int selectTipsListCount(SqlSessionTemplate sqlSession) {
			
			return sqlSession.selectOne("Tips.selectTipsListCount");
		}

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
		public Tips selectTipsOne(SqlSessionTemplate sqlSession, String board_no) {
			
			return sqlSession.selectOne("Tips.selectTipsOne",board_no);
		}

		//댓글 수
		@Override
		public int selectCommentListCount(SqlSessionTemplate sqlSession,String board_no) {
			
			return sqlSession.selectOne("Tips.selectCommentListCount", board_no);
		}
		
		//댓글 리스트
		@Override
		public ArrayList<TipsComment> selectComment(SqlSessionTemplate sqlSession, String board_no, PageInfo pgif) {
			ArrayList<TipsComment> list = null;
			
			//건너 뛸 게시물의 수
			int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
							
			RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
							
			//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
			//제네릭을 설정하면 오류가 나서 넣으면 안된다
			list = (ArrayList) sqlSession.selectList("Tips.selectComment", board_no, rowBounds);
			
			return list;
		}
		
		//조회수 업데이트
		@Override
		public Tips updateTipsCount(SqlSessionTemplate sqlSession, String board_no) {
			
			return sqlSession.selectOne("Tips.updateTipsCount", board_no);
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
}
