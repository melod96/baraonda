package com.kh.baraonda.myPage.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.board.model.vo.Board;
import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.member.model.vo.Member;
import com.kh.baraonda.myPage.model.vo.Files;
import com.kh.baraonda.myPage.model.vo.Footprints;
import com.kh.baraonda.myPage.model.vo.Point;

public interface MyPageDao {

	Point selectPoint(SqlSessionTemplate sqlSession, Member loginUser);

	int updateMemberInfo(SqlSessionTemplate sqlSession, Member m);

	void insertPhoto(SqlSessionTemplate sqlSession, Files file);

	Files selectPhoto(SqlSessionTemplate sqlSession, Member loginUser);

	Footprints selectFootprints(SqlSessionTemplate sqlSession, Member loginUser);

	int selectListCount(SqlSessionTemplate sqlSession, int id);

	ArrayList<Board> selectBoardList(SqlSessionTemplate sqlSession, PageInfo pi, int member_no);



}
