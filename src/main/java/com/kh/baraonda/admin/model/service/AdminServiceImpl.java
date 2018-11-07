package com.kh.baraonda.admin.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.admin.model.dao.AdminDao;
import com.kh.baraonda.admin.model.exception.AdminException;
import com.kh.baraonda.admin.model.vo.AdminBlackMember;
import com.kh.baraonda.admin.model.vo.AdminCompanyMember;
import com.kh.baraonda.admin.model.vo.AdminDeclaration;
import com.kh.baraonda.admin.model.vo.AdminGeneralMember;
import com.kh.baraonda.admin.model.vo.AdminNotice;
import com.kh.baraonda.admin.model.vo.AdminOrder;
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

	@Override
	public int selectCompanyMemberCount(Search search) throws AdminException {
		return ad.selectCompanyMemberCount(sqlSession, search);
	}

	@Override
	public ArrayList<AdminCompanyMember> selectCompanyMemberList(PageInfo pi, Search search) throws AdminException {
		return ad.selectCompanyMemberList(sqlSession, pi, search);
	}

	@Override
	public int selectBlackMemberCount(Search search) throws AdminException {
		return ad.selectBlackMemberCount(sqlSession, search);
	}

	@Override
	public ArrayList<AdminBlackMember> selectBlackMemberList(PageInfo pi, Search search) throws AdminException {
		return ad.selectBlackMemberList(sqlSession, pi, search);
	}

	@Override
	public int selectNoticeCount(Search search) throws AdminException {
		return ad.selectNoticeCount(sqlSession, search);
	}

	@Override
	public ArrayList<AdminNotice> selectNoticeList(PageInfo pi, Search search) throws AdminException {
		return ad.selectNoticeList(sqlSession, pi, search);
	}

	@Override
	public int selectDeclarationCount(Search search) throws AdminException {
		return ad.selectDeclarationCount(sqlSession, search);
	}

	@Override
	public ArrayList<AdminDeclaration> selectDeclarationList(PageInfo pi, Search search) throws AdminException {
		return ad.selectDeclarationList(sqlSession, pi, search);
	}

	@Override
	public int selectOrderCount(Search search) throws AdminException {
		return ad.selectOrderCount(sqlSession, search);
	}

	@Override
	public ArrayList<AdminOrder> selectOrderList(PageInfo pi, Search search) throws AdminException {
		return ad.selectOrderList(sqlSession, pi, search);
	}
	
}
