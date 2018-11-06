package com.kh.baraonda.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kh.baraonda.admin.model.exception.AdminException;
import com.kh.baraonda.admin.model.vo.AdminBlackMember;
import com.kh.baraonda.admin.model.vo.AdminCompanyMember;
import com.kh.baraonda.admin.model.vo.AdminGeneralMember;
import com.kh.baraonda.admin.model.vo.Search;
import com.kh.baraonda.common.PageInfo;

public interface AdminService {

	int selectGeneralMemberCount(Search search) throws AdminException;

	ArrayList<AdminGeneralMember> selectGeneralMemberList(PageInfo pi, Search search) throws AdminException;

	int selectCompanyMemberCount(Search search) throws AdminException;

	ArrayList<AdminCompanyMember> selectCompanyMemberList(PageInfo pi, Search search) throws AdminException;
	
	int selectBlackMemberCount(Search search) throws AdminException;

	ArrayList<AdminBlackMember> selectBlackMemberList(PageInfo pi, Search search) throws AdminException;
	
}
