package com.kh.baraonda.admin.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.admin.model.dao.AdminDao;
import com.kh.baraonda.admin.model.exception.AdminException;
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
	public List<Map<String, Object>> selectGeneralMemberList(PageInfo pi, Search search) throws AdminException {
		return ad.selectGeneralMemberList(sqlSession, pi, search);
	}

	@Override
	public int selectCompanyMemberCount(Search search) throws AdminException {
		return ad.selectCompanyMemberCount(sqlSession, search);
	}

	@Override
	public List<Map<String, Object>> selectCompanyMemberList(PageInfo pi, Search search) throws AdminException {
		return ad.selectCompanyMemberList(sqlSession, pi, search);
	}

	@Override
	public int selectBlackMemberCount(Search search) throws AdminException {
		return ad.selectBlackMemberCount(sqlSession, search);
	}

	@Override
	public List<Map<String, Object>> selectBlackMemberList(PageInfo pi, Search search) throws AdminException {
		return ad.selectBlackMemberList(sqlSession, pi, search);
	}

	@Override
	public int selectNoticeCount(Search search) throws AdminException {
		return ad.selectNoticeCount(sqlSession, search);
	}

	@Override
	public List<Map<String, Object>> selectNoticeList(PageInfo pi, Search search) throws AdminException {
		return ad.selectNoticeList(sqlSession, pi, search);
	}

	@Override
	public int selectDeclarationCount(Search search) throws AdminException {
		return ad.selectDeclarationCount(sqlSession, search);
	}

	@Override
	public List<Map<String, Object>> selectDeclarationList(PageInfo pi, Search search) throws AdminException {
		return ad.selectDeclarationList(sqlSession, pi, search);
	}

	@Override
	public int selectOrderCount(Search search) throws AdminException {
		return ad.selectOrderCount(sqlSession, search);
	}

	@Override
	public List<Map<String, Object>> selectOrderList(PageInfo pi, Search search) throws AdminException {
		return ad.selectOrderList(sqlSession, pi, search);
	}

	@Override
	public Map<String, Object> selectGeneralMemberInfo(String num) throws AdminException {
		return ad.selectGeneralMemberInfo(sqlSession, num);
	}

	@Override
	public List<Map<String, Object>> selectMembersDeclarationList(String num) throws AdminException {
		return ad.selectMembersDeclarationList(sqlSession, num);
	}

	@Override
	public List<Map<String, Object>> selectMembersOrderList(String num) throws AdminException {
		return ad.selectMembersOrderList(sqlSession, num);
	}

	@Override
	public Map<String, Object> selectCompanyMemberInfo(String num) throws AdminException {
		return ad.selectCompanyMemberInfo(sqlSession, num);
	}

	@Override
	public Map<String, Object> selectNoticeInfo(String num) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

}
