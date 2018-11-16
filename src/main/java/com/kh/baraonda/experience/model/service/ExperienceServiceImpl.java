package com.kh.baraonda.experience.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.experience.model.dao.ExperienceDao;
import com.kh.baraonda.experience.model.exception.ExperienceSelectListException;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;

@Service
public class ExperienceServiceImpl implements ExperienceService{

	@Autowired
	private ExperienceDao epd;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Override
	public int selectExperienceListCount() {
		
		return epd.selectExperienceListCount(sqlSession);
	}
	@Override
	public ArrayList<Tips> selectExperienceList(PageInfo pgif) throws ExperienceSelectListException {
		
		return epd.selectExperienceListCount(sqlSession, pgif);
	}
	@Override
	public Tips selectExperienceOne(String experience_no) {
		epd.updateExperienceCount(sqlSession, experience_no);
		return epd.selectExperienceOne(sqlSession,experience_no );
	}
	@Override
	public int selectHeartExperience(String experience_no) {
		return epd.selectHeartExperience(sqlSession,experience_no );
	}
	@Override
	public int selectCommentListCount(String experience_no) {
		return epd.selectCommentListCount(sqlSession,experience_no );
	}
	@Override
	public ArrayList<TipsComment> selectCommentList(String experience_no, PageInfo pgif) {
		return epd.selectCommentList(sqlSession,experience_no ,pgif);
	}
	@Override
	public Tips selectNextNo(String experience_no) {
		return epd.selectNextNo(sqlSession,experience_no );
	}
	@Override
	public Tips selectBeforeNo(String experience_no) {
		return epd.selectBeforeNo(sqlSession,experience_no );
	}

}
