package com.kh.baraonda.member.model.service;

import com.kh.baraonda.member.model.exception.LoginException;
import com.kh.baraonda.member.model.vo.Member;



public interface MemberService {

	int insertMember(Member m);

	Member loginMember(Member m) throws LoginException;

}