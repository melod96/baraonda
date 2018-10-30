package com.kh.baraonda.myPage.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.vo.Files;
import com.kh.baraonda.myPage.model.vo.Point;

@Repository
public class MyPageDaoImpl implements MyPageDao{

	@Override
	public Point selectPoint(SqlSessionTemplate sqlSession, Member loginUser) {
		return sqlSession.selectOne("MyPage.selectPoint", loginUser);
	}

	@Override
	public int updateMemberInfo(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("MyPage.updateMemberInfo", m);
	}

	@Override
	public void insertPhoto(SqlSessionTemplate sqlSession, Files file) {
		sqlSession.insert("MyPage.insertPhoto", file);
	}

	@Override
	public Files selectPhoto(SqlSessionTemplate sqlSession, Member loginUser) {
		return (Files)sqlSession.selectOne("MyPage.selectPhoto",loginUser);
	}


}
