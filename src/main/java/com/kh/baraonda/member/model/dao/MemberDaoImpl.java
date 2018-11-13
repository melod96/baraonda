package com.kh.baraonda.member.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.member.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Override
	public int insertMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("Member.insertMember", m);
		
	}
	
	@Override
	public Member selectMemberOne(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.selectOne("Member.selectOne",m);
	}

	@Override
	public int insertPoint(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("Member.insertPoint", m);
	}
	
	
	@Override
	public String selectEncPassword(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.selectOne("Member.selectPwd", m.getId());
	}

	@Override
	public Member selectMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.selectOne("Member.selectLoginUser", m);
	}

	@Override
	public int insertCompany(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("Member.insertCompany", m);
	}
	
	@Override
	public int selectIdCheck(SqlSessionTemplate sqlSession, Member m) {
		System.out.println("dao m : " + m);
		return ((ArrayList)sqlSession.selectList("Member.selectIdCheck",m)).size();
	}

	@Override
	public int selectBizIDCheck(SqlSessionTemplate sqlSession, Member m) {
		System.out.println("dao m : " + m);
		return ((ArrayList)sqlSession.selectList("Member.selectBizIDCheck",m)).size();
	}

	@Override
	public int selectNickCheck(SqlSessionTemplate sqlSession, Member m) {
		System.out.println("dao m : " + m);
		return ((ArrayList)sqlSession.selectList("Member.selectNickCheck",m)).size();
	}

	


	
	

}
