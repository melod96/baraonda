package com.kh.baraonda.member.model.service;

import java.util.ArrayList;

import com.kh.baraonda.member.model.exception.LoginException;
import com.kh.baraonda.member.model.vo.Member;



public interface MemberService {

	int insertMember(Member m);

	Member loginMember(Member m) throws LoginException;

	int insertPoint(Member m);

	Member selectOne(Member m);

	int insertCompany(Member m);

	int selectIdCheck(Member m);

	int selectBizIDCheck(Member m);

	int selectNickCheck(Member m);

	ArrayList<Member> selectIds(Member m);

	int insertProfile(Member member);
}
