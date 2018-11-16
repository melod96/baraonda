package com.kh.baraonda.experience.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.common.SearchCondition;
import com.kh.baraonda.exchange.model.vo.Point_Record;
import com.kh.baraonda.experience.model.dao.ExperienceDao;
import com.kh.baraonda.experience.model.exception.ExperienceSelectListException;
import com.kh.baraonda.experience.model.vo.Experience;
import com.kh.baraonda.notice.model.vo.NoticeComment;
import com.kh.baraonda.notice.model.vo.NoticeMarking;
import com.kh.baraonda.tips.model.vo.Tips;
import com.kh.baraonda.tips.model.vo.TipsComment;
import com.kh.baraonda.tips.model.vo.TipsFiles;

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
		int nextno= epd.selectNextNo(sqlSession,experience_no);
		
		return epd.selectExperienceOne(sqlSession, String.valueOf(nextno));
	}
	@Override
	public Tips selectBeforeNo(String experience_no) {
		int beforeno= epd.selectBeforeNo(sqlSession,experience_no);
		
		return epd.selectExperienceOne(sqlSession, String.valueOf(beforeno));
	}
	@Override
	public int searchExperienceCount(SearchCondition sc) {
		
		return epd.searchExperienceCount(sqlSession,sc);
	}
	@Override
	public ArrayList<Tips> searchExperienceList(SearchCondition sc, PageInfo pgif) {
		return epd.searchExperienceList(sqlSession, pgif, sc);
	}
	@Override
	public void deleteExperience(String notice_no) {
		
		epd.deleteExperience(sqlSession, notice_no);
	}
	@Override
	public int checkBookmark(NoticeMarking nm) {
		return epd.checkBookmark(sqlSession, nm);
	}
	@Override
	public void insertBookmark(NoticeMarking nm) {
		epd.insertBookmark(sqlSession, nm);
	}
	@Override
	public void deleteBookmark(NoticeMarking nm) {
		epd.deleteBookmark(sqlSession, nm);
	}
	@Override
	public int checkHeart(NoticeMarking nm) {
		return epd.checkHeart(sqlSession, nm);
	}
	@Override
	public void insertHeart(NoticeMarking nm) {
		 epd.insertHeart(sqlSession, nm);
	}
	@Override
	public void deleteHeart(NoticeMarking nm) {
		 epd.deleteHeart(sqlSession, nm);
	}
	@Override
	public void insertComment(NoticeComment c) {
		epd.insertComment(sqlSession, c);
	}
	@Override
	public void updatePoint(Point_Record pr) {
		epd.updatePoint(sqlSession, pr);
	}
	@Override
	public void deleteComment(String comment_no) {
		epd.deleteComment(sqlSession, comment_no);
		
	}
	@Override
	public int insertExperience(Tips t) {
		return epd.insertExperience(sqlSession, t);
	}
	@Override
	public void insertPhoto(TipsFiles file,Experience e) {
		System.out.println("?????");
		epd.insertExperienceList(sqlSession, e);
		System.out.println("?????");
		epd.insertPhoto(sqlSession, file);
		
	}

}
