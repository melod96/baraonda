package com.kh.baraonda.main.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.notice.model.vo.Notice;

public interface MainDao {

	ArrayList<Notice> selectNotice(SqlSessionTemplate sqlSession);

}
