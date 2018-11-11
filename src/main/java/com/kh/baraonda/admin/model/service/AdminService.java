package com.kh.baraonda.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.admin.model.exception.AdminException;
import com.kh.baraonda.admin.model.vo.AdminBlackMember;
import com.kh.baraonda.admin.model.vo.AdminCompanyMember;
import com.kh.baraonda.admin.model.vo.AdminDeclaration;
import com.kh.baraonda.admin.model.vo.AdminDeclarationForMemberDetail;
import com.kh.baraonda.admin.model.vo.AdminGeneralMember;
import com.kh.baraonda.admin.model.vo.AdminNotice;
import com.kh.baraonda.admin.model.vo.AdminOrder;
import com.kh.baraonda.admin.model.vo.AdminOrderForMemberDetail;
import com.kh.baraonda.admin.model.vo.Search;
import com.kh.baraonda.common.PageInfo;

public interface AdminService {

	int selectGeneralMemberCount(Search search) throws AdminException;

	ArrayList<AdminGeneralMember> selectGeneralMemberList(PageInfo pi, Search search) throws AdminException;

	int selectCompanyMemberCount(Search search) throws AdminException;

	ArrayList<AdminCompanyMember> selectCompanyMemberList(PageInfo pi, Search search) throws AdminException;
	
	int selectBlackMemberCount(Search search) throws AdminException;

	ArrayList<AdminBlackMember> selectBlackMemberList(PageInfo pi, Search search) throws AdminException;
	
	int selectNoticeCount(Search search) throws AdminException;

	ArrayList<AdminNotice> selectNoticeList(PageInfo pi, Search search) throws AdminException;
	
	int selectDeclarationCount(Search search) throws AdminException;

	ArrayList<AdminDeclaration> selectDeclarationList(PageInfo pi, Search search) throws AdminException;
	
	int selectOrderCount(Search search) throws AdminException;

	ArrayList<AdminOrder> selectOrderList(PageInfo pi, Search search) throws AdminException;
	
	AdminGeneralMember selectGeneralMemberInfo(String num) throws AdminException;
	
	ArrayList<AdminDeclarationForMemberDetail> selectMembersDeclarationList(String num) throws AdminException;
	
	ArrayList<AdminOrderForMemberDetail> selectMembersOrderList(String num) throws AdminException;
	
	AdminCompanyMember selectCompanyMemberInfo(String num) throws AdminException;
	
}
