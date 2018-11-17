package com.kh.baraonda.experience.model.service;

import java.util.ArrayList;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.exchange.model.vo.Point_Record;
import com.kh.baraonda.experience.model.exception.ExperienceSelectListException;
import com.kh.baraonda.experience.model.vo.Experience;
import com.kh.baraonda.notice.model.vo.Notice;
import com.kh.baraonda.notice.model.vo.NoticeComment;
import com.kh.baraonda.notice.model.vo.NoticeMarking;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;
import com.kh.baraonda.tips.model.vo.TipsFiles;

public interface ExperienceService {

	int selectExperienceListCount();

	ArrayList<Tips> selectExperienceList(PageInfo pgif) throws ExperienceSelectListException;

	Tips selectExperienceOne(String experience_no);

	int selectHeartExperience(String experience_no);

	int selectCommentListCount(String experience_no);

	ArrayList<TipsComment> selectCommentList(String experience_no, PageInfo pgif);

	Tips selectNextNo(String experience_no);

	Tips selectBeforeNo(String experience_no);

	int searchExperienceCount(SearchCondition sc);

	ArrayList<Tips> searchExperienceList(SearchCondition sc, PageInfo pgif);

	void deleteExperience(String notice_no);

	int checkBookmark(NoticeMarking nm);

	void insertBookmark(NoticeMarking nm);

	void deleteBookmark(NoticeMarking nm);

	int checkHeart(NoticeMarking nm);

	void insertHeart(NoticeMarking nm);

	void deleteHeart(NoticeMarking nm);

	void insertComment(NoticeComment c);

	void updatePoint(Point_Record pr);

	void deleteComment(String comment_no);

	int insertExperience(Tips t);

	void insertPhoto(TipsFiles file, Experience e);

}
