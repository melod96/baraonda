package com.kh.baraonda.main.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.baraonda.main.model.dao.MainDao;
import com.kh.baraonda.main.model.exception.NoticeSelectListException;
import com.kh.baraonda.main.model.vo.PageInfo;
import com.kh.baraonda.notice.model.vo.Notice;

public class MainServiceImpl implements MainService{
@Autowired
private SqlSessionTemplate sqlSession;
@Autowired
private MainDao md;
	
	
	
	@Override
	public ArrayList<Notice> selectNotice() throws NoticeSelectListException {
		
		return md.selectNotice(sqlSession);
	}
	

}

