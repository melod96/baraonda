package com.kh.baraonda.myPage.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.javassist.expr.Instanceof;
import org.apache.ibatis.session.RowBounds;
import org.apache.tools.ant.types.resources.selectors.InstanceOf;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.vo.Files;
import com.kh.baraonda.myPage.model.vo.Footprints;
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

	@Override
	public Footprints selectFootprints(SqlSessionTemplate sqlSession, Member loginUser) {
		return (Footprints)sqlSession.selectOne("MyPage.selectFootprints", loginUser);
	}

	@Override
	public int selectListCount(SqlSessionTemplate sqlSession, int member_no) {
		return sqlSession.selectOne("MyPage.selectListCount",member_no);
	}

	@Override
	public ArrayList<Board> selectBoardList(SqlSessionTemplate sqlSession, PageInfo pi, int member_no) {
		
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		System.out.println(member_no);
		
		return (ArrayList)sqlSession.selectList("MyPage.selectBoardList",member_no,rowBounds);
	}



}
