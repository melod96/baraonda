package com.kh.baraonda.myPage.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.vo.Point;

public interface MyPageDao {

	Point selectPoint(SqlSessionTemplate sqlSession, Member loginUser);

	int updateMemberInfo(SqlSessionTemplate sqlSession, Member m);

}
