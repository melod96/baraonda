package com.kh.baraonda.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.member.model.vo.Member;

public interface MemberDao {

	int insertMember(SqlSessionTemplate sqlSession, Member m);

	String selectEncPassword(SqlSessionTemplate sqlSession, Member m);

	Member selectMember(SqlSessionTemplate sqlSession, Member m);

}
