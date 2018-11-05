package com.kh.baraonda.myPage.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.dao.MyPageDao;
import com.kh.baraonda.myPage.model.vo.Comments;
import com.kh.baraonda.myPage.model.vo.Files;
import com.kh.baraonda.myPage.model.vo.Footprints;
import com.kh.baraonda.myPage.model.vo.Marking;
import com.kh.baraonda.myPage.model.vo.Point;

@Service
public class MyPageServiceImpl implements MyPageService{

	
	@Autowired //의존성 주입을 위함.
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MyPageDao mpd;
	
	@Override
	public Point selectPoint(Member loginUser) {
		return mpd.selectPoint(sqlSession, loginUser);
	}

	@Override
	public int updateMemberInfo(Member m) {
		return mpd.updateMemberInfo(sqlSession, m);
	}

	@Override
	public void insertPhoto(Files file) {
		mpd.insertPhoto(sqlSession, file);
	}

	@Override
	public Files selectPhoto(Member loginUser) {
		return mpd.selectPhoto(sqlSession, loginUser);
	}

	@Override
	public Footprints selectFootprints(Member loginUser) {
		return mpd.selectFootprints(sqlSession, loginUser);
	}

	@Override
	public int selectListCount(int id) {
		return mpd.selectListCount(sqlSession, id);
	}

	@Override
	public ArrayList<Board> selectBoardList(PageInfo pi, int member_no) {
		System.out.println("service실행");
		return mpd.selectBoardList(sqlSession,pi, member_no);
	}

	@Override
	public ArrayList<Marking> selectLikeCount(int member_no) {
		return mpd.selectLikeCount(sqlSession, member_no);
	}

	@Override
	public int selectCommentsListCount(int member_no) {
		return mpd.selectCommentsListCount(sqlSession, member_no);
	}

	@Override
	public ArrayList<Comments> selectCommentList(PageInfo cPi, int member_no) {
		return mpd.selectCommentList(sqlSession,cPi, member_no);
	}






}
