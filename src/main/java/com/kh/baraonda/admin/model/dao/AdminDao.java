package com.kh.baraonda.admin.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.admin.model.exception.AdminException;
import com.kh.baraonda.admin.model.vo.AdminBlackMember;
import com.kh.baraonda.admin.model.vo.AdminCompanyMember;
import com.kh.baraonda.admin.model.vo.AdminGeneralMember;
import com.kh.baraonda.admin.model.vo.Search;
import com.kh.baraonda.common.PageInfo;

public interface AdminDao {

	int selectGeneralMemberCount(SqlSessionTemplate sqlSession, Search search) throws AdminException;

	ArrayList<AdminGeneralMember> selectGeneralMemberList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException;

	int selectCompanyMemberCount(SqlSessionTemplate sqlSession, Search search) throws AdminException;

	ArrayList<AdminCompanyMember> selectCompanyMemberList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException;

	int selectBlackMemberCount(SqlSessionTemplate sqlSession, Search search) throws AdminException;

	ArrayList<AdminBlackMember> selectBlackMemberList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException;
	
}
