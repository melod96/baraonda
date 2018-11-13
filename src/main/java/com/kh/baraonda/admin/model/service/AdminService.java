package com.kh.baraonda.admin.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kh.baraonda.admin.model.exception.AdminException;
import com.kh.baraonda.admin.model.vo.AdminBoard;
import com.kh.baraonda.admin.model.vo.Search;
import com.kh.baraonda.common.PageInfo;

public interface AdminService {

	int selectGeneralMemberCount(Search search) throws AdminException;

	List<Map<String, Object>> selectGeneralMemberList(PageInfo pi, Search search) throws AdminException;

	int selectCompanyMemberCount(Search search) throws AdminException;

	List<Map<String, Object>> selectCompanyMemberList(PageInfo pi, Search search) throws AdminException;
	
	int selectBlackMemberCount(Search search) throws AdminException;

	List<Map<String, Object>> selectBlackMemberList(PageInfo pi, Search search) throws AdminException;
	
	int selectNoticeCount(Search search) throws AdminException;

	List<Map<String, Object>> selectNoticeList(PageInfo pi, Search search) throws AdminException;
	
	int selectDeclarationCount(Search search) throws AdminException;

	List<Map<String, Object>> selectDeclarationList(PageInfo pi, Search search) throws AdminException;
	
	int selectOrderCount(Search search) throws AdminException;

	List<Map<String, Object>> selectOrderList(PageInfo pi, Search search) throws AdminException;
	
	Map<String, Object> selectGeneralMemberInfo(String num) throws AdminException;
	
	List<Map<String, Object>> selectMembersDeclarationList(String num) throws AdminException;
	
	List<Map<String, Object>> selectMembersOrderList(String num) throws AdminException;
	
	Map<String, Object> selectCompanyMemberInfo(String num) throws AdminException;

	Map<String, Object> selectNoticeInfo(String num) throws AdminException;

	void insertNoticeInfo(AdminBoard adminBoard) throws AdminException;

	void updateNoticeInfo(AdminBoard adminBoard) throws AdminException;

	void deleteNoticeInfo(String num) throws AdminException;
	
	
}
