package com.kh.baraonda.admin.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.admin.model.exception.AdminException;
import com.kh.baraonda.admin.model.vo.AdminGeneralMember;
import com.kh.baraonda.common.PageInfo;

public interface AdminDao {

	int selectGeneralMemberCount(SqlSessionTemplate sqlSession) throws AdminException;

	ArrayList<AdminGeneralMember> selectGeneralMemberList(SqlSessionTemplate sqlSession, PageInfo pi) throws AdminException;

}
