package com.kh.baraonda.experience.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

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

public interface ExperienceDao {

	int selectExperienceListCount(SqlSessionTemplate sqlSession);

	ArrayList<Tips> selectExperienceListCount(SqlSessionTemplate sqlSession, PageInfo pgif) throws ExperienceSelectListException;

	void updateExperienceCount(SqlSessionTemplate sqlSession, String experience_no);

	Tips selectExperienceOne(SqlSessionTemplate sqlSession, String experience_no);

	int selectHeartExperience(SqlSessionTemplate sqlSession, String experience_no);

	int selectCommentListCount(SqlSessionTemplate sqlSession, String experience_no);

	ArrayList<TipsComment> selectCommentList(SqlSessionTemplate sqlSession, String experience_no, PageInfo pgif);

	int selectNextNo(SqlSessionTemplate sqlSession, String experience_no);

	int selectBeforeNo(SqlSessionTemplate sqlSession, String experience_no);

	int searchExperienceCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	ArrayList<Tips> searchExperienceList(SqlSessionTemplate sqlSession, PageInfo pgif, SearchCondition sc);

	void deleteExperience(SqlSessionTemplate sqlSession, String notice_no);

	int checkBookmark(SqlSessionTemplate sqlSession, NoticeMarking nm);

	void insertBookmark(SqlSessionTemplate sqlSession, NoticeMarking nm);

	void deleteBookmark(SqlSessionTemplate sqlSession, NoticeMarking nm);

	int checkHeart(SqlSessionTemplate sqlSession, NoticeMarking nm);

	void insertHeart(SqlSessionTemplate sqlSession, NoticeMarking nm);

	void deleteHeart(SqlSessionTemplate sqlSession, NoticeMarking nm);

	void insertComment(SqlSessionTemplate sqlSession, NoticeComment c);

	void updatePoint(SqlSessionTemplate sqlSession, Point_Record pr);

	void deleteComment(SqlSessionTemplate sqlSession, String comment_no);

	int insertExperience(SqlSessionTemplate sqlSession, Tips t);

	void insertPhoto(SqlSessionTemplate sqlSession, TipsFiles file);

	void insertExperienceList(SqlSessionTemplate sqlSession, Experience e);


}
