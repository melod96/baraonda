package com.kh.baraonda.experience.model.service;

import java.util.ArrayList;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.experience.model.exception.ExperienceSelectListException;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;

public interface ExperienceService {

	int selectExperienceListCount();

	ArrayList<Tips> selectExperienceList(PageInfo pgif) throws ExperienceSelectListException;

	Tips selectExperienceOne(String experience_no);

	int selectHeartExperience(String experience_no);

	int selectCommentListCount(String experience_no);

	ArrayList<TipsComment> selectCommentList(String experience_no, PageInfo pgif);

	Tips selectNextNo(String experience_no);

	Tips selectBeforeNo(String experience_no);

}
