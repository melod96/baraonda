package com.kh.baraonda.member.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.member.model.vo.Member;

public interface MemberDao {

	int insertMember(SqlSessionTemplate sqlSession, Member m);

	int insertPoint(SqlSessionTemplate sqlSession, Member m);
	
	String selectEncPassword(SqlSessionTemplate sqlSession, Member m);

	Member selectMember(SqlSessionTemplate sqlSession, Member m);

	Member selectMemberOne(SqlSessionTemplate sqlSession, Member m);

	int insertCompany(SqlSessionTemplate sqlSession, Member m);

	int selectIdCheck(SqlSessionTemplate sqlSession, Member m);

	int selectBizIDCheck(SqlSessionTemplate sqlSession, Member m);

	int selectNickCheck(SqlSessionTemplate sqlSession, Member m);

	ArrayList<Member> selectIds(SqlSessionTemplate sqlSession, Member m);

	int insertProfile(SqlSessionTemplate sqlSession, Member member);

}
