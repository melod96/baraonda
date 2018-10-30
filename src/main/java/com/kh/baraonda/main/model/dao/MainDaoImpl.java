package com.kh.baraonda.main.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.notice.model.vo.Notice;


@Repository
public class MainDaoImpl implements MainDao{

	@Override
	public ArrayList<Notice> selectNotice(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("Main.selectNotice");
	}

}
