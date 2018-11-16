package com.kh.baraonda.experience.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.experience.model.exception.ExperienceSelectListException;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;

public interface ExperienceDao {

	int selectExperienceListCount(SqlSessionTemplate sqlSession);

	ArrayList<Tips> selectExperienceListCount(SqlSessionTemplate sqlSession, PageInfo pgif) throws ExperienceSelectListException;

	void updateExperienceCount(SqlSessionTemplate sqlSession, String experience_no);

	Tips selectExperienceOne(SqlSessionTemplate sqlSession, String experience_no);

	int selectHeartExperience(SqlSessionTemplate sqlSession, String experience_no);

	int selectCommentListCount(SqlSessionTemplate sqlSession, String experience_no);

	ArrayList<TipsComment> selectCommentList(SqlSessionTemplate sqlSession, String experience_no, PageInfo pgif);

	Tips selectNextNo(SqlSessionTemplate sqlSession, String experience_no);

	Tips selectBeforeNo(SqlSessionTemplate sqlSession, String experience_no);

}
