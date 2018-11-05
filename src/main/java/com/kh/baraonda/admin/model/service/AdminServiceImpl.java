package com.kh.baraonda.admin.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.admin.model.dao.AdminDao;
import com.kh.baraonda.admin.model.exception.AdminException;
import com.kh.baraonda.admin.model.vo.AdminGeneralMember;
import com.kh.baraonda.admin.model.vo.Search;
import com.kh.baraonda.common.PageInfo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao ad;
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int selectGeneralMemberCount(Search search) throws AdminException {
		return ad.selectGeneralMemberCount(sqlSession, search);
	}

	@Override
	public ArrayList<AdminGeneralMember> selectGeneralMemberList(PageInfo pi, Search search) throws AdminException {
		return ad.selectGeneralMemberList(sqlSession, pi, search);
	}
	
}
