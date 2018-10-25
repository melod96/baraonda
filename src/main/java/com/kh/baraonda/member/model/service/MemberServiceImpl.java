package com.kh.baraonda.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.baraonda.member.model.dao.MemberDao;
import com.kh.baraonda.member.model.exception.LoginException;
import com.kh.baraonda.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired //의존성 주입을 위함.
	private SqlSessionTemplate sqlSession;
	
	@Autowired //Dao역시 의존성 주입을 위해 Autowired 어노테이션으로 생성해준다.
	private MemberDao md;
	
	@Autowired //두 비밀번호를 비교해주기 위해 사용
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	//transactionManager를 의존성 주입으로 받는다.
	
	//회원가입
	@Override
	public int insertMember(Member m) {
		return md.insertMember(sqlSession, m);
	}
	
	//암호화 처리 하는 로그인용 메소드
	@Override
	public Member loginMember(Member m) throws LoginException{
		Member loginUser = null;
		
		System.out.println("Service Member : " + m);
		
		String encPassword = md.selectEncPassword(sqlSession, m);
		
		System.out.println("encPassword : " + encPassword);
		
		if(!passwordEncoder.matches(m.getPassword(), encPassword)) {
			throw new LoginException("로그인 실패");
		}else {
			loginUser = md.selectMember(sqlSession, m);
		}
		return loginUser;
	}
}
