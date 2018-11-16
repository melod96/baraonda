package com.kh.baraonda.experience.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.experience.model.exception.ExperienceSelectListException;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tips selectExperienceOne(SqlSessionTemplate sqlSession, String experience_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectHeartExperience(SqlSessionTemplate sqlSession, String experience_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCommentListCount(SqlSessionTemplate sqlSession, String experience_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<TipsComment> selectCommentList(SqlSessionTemplate sqlSession, String experience_no,
			PageInfo pgif) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tips selectNextNo(SqlSessionTemplate sqlSession, String experience_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tips selectBeforeNo(SqlSessionTemplate sqlSession, String experience_no) {
		// TODO Auto-generated method stub
		return null;
	}

}
