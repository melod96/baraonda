package com.kh.baraonda.main.model.service;

import java.util.ArrayList;

import org.apache.tools.ant.Main;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.main.model.dao.MainDao;
import com.kh.baraonda.main.model.exception.NoticeSelectListException;
import com.kh.baraonda.main.model.vo.PageInfo;
import com.kh.baraonda.notice.model.vo.Notice;


public interface MainService {
	
	ArrayList<Notice> selectNotice() throws NoticeSelectListException;
	

}
