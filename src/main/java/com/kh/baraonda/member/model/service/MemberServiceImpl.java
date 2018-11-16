package com.kh.baraonda.member.model.service;

import java.util.ArrayList;

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
	
	//트랜젝션 관리  - 메소드 내에 있는 구문은 전부 하나의 트랜젝션으로 관리된다.
	
	//멤버 검색
	@Override
	public Member selectOne(Member m) {
		return md.selectMemberOne(sqlSession, m);
	}
	
	//회원가입(+ 포인트 행 추가)
	@Override
	public int insertMember(Member m) {
		return md.insertMember(sqlSession, m);
	}
	
	@Override
	public int insertPoint(Member m) {
		return  md.insertPoint(sqlSession, m);
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

	@Override
	public int insertCompany(Member m) {
		return md.insertCompany(sqlSession, m);
	}

	@Override
	public int selectIdCheck(Member m) {
		return md.selectIdCheck(sqlSession, m);
	}

	@Override
	public int selectBizIDCheck(Member m) {
		return md.selectBizIDCheck(sqlSession, m);
	}

	@Override
	public int selectNickCheck(Member m) {
		return md.selectNickCheck(sqlSession, m);
	}

	@Override
	public ArrayList<Member> selectIds(Member m){
		return md.selectIds(sqlSession, m);
	}

	



	
}
