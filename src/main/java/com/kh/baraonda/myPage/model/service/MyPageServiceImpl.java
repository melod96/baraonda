package com.kh.baraonda.myPage.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.dao.MyPageDao;
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

}
