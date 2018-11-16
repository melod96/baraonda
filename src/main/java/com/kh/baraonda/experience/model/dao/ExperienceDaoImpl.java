package com.kh.baraonda.experience.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.exchange.model.vo.Point_Record;
import com.kh.baraonda.experience.model.exception.ExperienceSelectListException;
import com.kh.baraonda.experience.model.vo.Experience;
import com.kh.baraonda.notice.model.vo.NoticeComment;
import com.kh.baraonda.notice.model.vo.NoticeMarking;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;
import com.kh.baraonda.tips.model.vo.TipsFiles;

@Repository
public class ExperienceDaoImpl implements ExperienceDao{

	@Override
	public int selectExperienceListCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("Experience.experienceListCount");
	}

	@Override
	public ArrayList<Tips> selectExperienceListCount(SqlSessionTemplate sqlSession, PageInfo pgif) throws ExperienceSelectListException {
		ArrayList<Tips> list = null;
		
		//건너 뛸 게시물의 수
		int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
						
		RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
						
		//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
		//제네릭을 설정하면 오류가 나서 넣으면 안된다
		list = (ArrayList) sqlSession.selectList("Experience.selectExperienceList", null, rowBounds);
						
		if(list == null){
			sqlSession.close();
			throw new ExperienceSelectListException("체험단 조회 실패");
		}
		
		return list;
	}

	@Override
	public void updateExperienceCount(SqlSessionTemplate sqlSession, String experience_no) {
		sqlSession.update("Experience.updateExperienceCount", experience_no);
		
	}

	@Override
	public Tips selectExperienceOne(SqlSessionTemplate sqlSession, String experience_no) {
		return sqlSession.selectOne("Experience.selectExperienceOne",experience_no );
	}

	@Override
	public int selectHeartExperience(SqlSessionTemplate sqlSession, String experience_no) {
		return sqlSession.selectOne("Experience.selectHeartExperience",experience_no );
	}

	@Override
	public int selectCommentListCount(SqlSessionTemplate sqlSession, String experience_no) {
		return sqlSession.selectOne("Experience.selectCommentListCount",experience_no );
	}

	@Override
	public ArrayList<TipsComment> selectCommentList(SqlSessionTemplate sqlSession, String experience_no,
			PageInfo pgif) {
		ArrayList<TipsComment> list = null;
		
		//건너 뛸 게시물의 수
		int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
						
		RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
						
		//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
		//제네릭을 설정하면 오류가 나서 넣으면 안된다
		list = (ArrayList) sqlSession.selectList("Experience.selectCommentList", experience_no, rowBounds);
		
		return list;
	}

	@Override
	public int selectNextNo(SqlSessionTemplate sqlSession, String experience_no) {
		
		String before = null;
		before = String.valueOf(sqlSession.selectOne("Experience.selectNextNo", experience_no));
		if(before.equals("null")) {
			return 0;
		}else{
			int befo = Integer.parseInt(before);
			
			return befo;
		}
	}

	@Override
	public int selectBeforeNo(SqlSessionTemplate sqlSession, String experience_no) {
		String before = null;
		before = String.valueOf(sqlSession.selectOne("Experience.selectBeforeNo", experience_no));
		if(before.equals("null")) {
			return 0;
		}else{
			int befo = Integer.parseInt(before);
			
			return befo;
		}
		
	}

	@Override
	public int searchExperienceCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return sqlSession.selectOne("Experience.searchExperienceCount",sc);
	}

	@Override
	public ArrayList<Tips> searchExperienceList(SqlSessionTemplate sqlSession, PageInfo pgif, SearchCondition sc) {
		ArrayList<Tips> list = null;
		
		//건너 뛸 게시물의 수
		int offset = (pgif.getCurrentPage() -1) * pgif.getLimit();
						
		RowBounds rowBounds = new RowBounds(offset, pgif.getLimit());
						
		//오브젝트로 받아오기 때문에 arraylist로 다운캐스팅 해준다
		//제네릭을 설정하면 오류가 나서 넣으면 안된다
		list = (ArrayList) sqlSession.selectList("Experience.searchExperienceList", sc, rowBounds);
		
		return list;
	}

	@Override
	public void deleteExperience(SqlSessionTemplate sqlSession, String notice_no) {
		sqlSession.update("Experience.deleteExperience",notice_no );
		
	}

	@Override
	public int checkBookmark(SqlSessionTemplate sqlSession, NoticeMarking nm) {
		return sqlSession.selectOne("Experience.checkBookmark",nm );
	}

	@Override
	public void insertBookmark(SqlSessionTemplate sqlSession, NoticeMarking nm) {
		 sqlSession.insert("Experience.insertBookmark",nm );
	}

	@Override
	public void deleteBookmark(SqlSessionTemplate sqlSession, NoticeMarking nm) {
		 sqlSession.delete("Experience.deleteBookmark",nm );
	}

	@Override
	public int checkHeart(SqlSessionTemplate sqlSession, NoticeMarking nm) {
		return sqlSession.selectOne("Experience.checkHeart",nm );
	}

	@Override
	public void insertHeart(SqlSessionTemplate sqlSession, NoticeMarking nm) {
		 sqlSession.insert("Experience.insertHeart",nm );
	}

	@Override
	public void deleteHeart(SqlSessionTemplate sqlSession, NoticeMarking nm) {
		 sqlSession.delete("Experience.deleteHeart",nm );
	}

	@Override
	public void insertComment(SqlSessionTemplate sqlSession, NoticeComment c) {
		sqlSession.insert("Experience.insertComment",c );
	}

	@Override
	public void updatePoint(SqlSessionTemplate sqlSession, Point_Record pr) {
		sqlSession.update("Experience.updatePoint",pr );
	}

	@Override
	public void deleteComment(SqlSessionTemplate sqlSession, String comment_no) {
		sqlSession.update("Experience.deleteComment",comment_no );
		
	}

	@Override
	public int insertExperience(SqlSessionTemplate sqlSession, Tips t) {
		sqlSession.insert("Experience.insertExperience",t );
		return t.getF_reference_no();
	}

	@Override
	public void insertPhoto(SqlSessionTemplate sqlSession, TipsFiles file) {
		sqlSession.insert("Experience.insertPhoto",file );
	}

	@Override
	public void insertExperienceList(SqlSessionTemplate sqlSession, Experience e) {
		System.out.println("??????/");
		sqlSession.insert("Experience.insertExperienceList",e );
		System.out.println("??????/");
	}


	

}
