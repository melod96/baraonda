package com.kh.baraonda.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.admin.model.exception.AdminException;
import com.kh.baraonda.admin.model.vo.AdminBoard;
import com.kh.baraonda.admin.model.vo.Search;
import com.kh.baraonda.common.PageInfo;

public interface AdminDao {

	int selectGeneralMemberCount(SqlSessionTemplate sqlSession, Search search) throws AdminException;

	List<Map<String, Object>> selectGeneralMemberList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException;

	int selectCompanyMemberCount(SqlSessionTemplate sqlSession, Search search) throws AdminException;

	List<Map<String, Object>> selectCompanyMemberList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException;

	int selectBlackMemberCount(SqlSessionTemplate sqlSession, Search search) throws AdminException;

	List<Map<String, Object>> selectBlackMemberList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException;
	
	int selectNoticeCount(SqlSessionTemplate sqlSession, Search search) throws AdminException;

	List<Map<String, Object>> selectNoticeList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException;
	
	int selectDeclarationCount(SqlSessionTemplate sqlSession, Search search) throws AdminException;

	List<Map<String, Object>> selectDeclarationList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException;
	
	int selectOrderCount(SqlSessionTemplate sqlSession, Search search) throws AdminException;

	List<Map<String, Object>> selectOrderList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException;
	
	Map<String, Object> selectGeneralMemberInfo(SqlSessionTemplate sqlSession, String num) throws AdminException;
	
	List<Map<String, Object>> selectMembersDeclarationList(SqlSessionTemplate sqlSession, String num) throws AdminException;
	
	List<Map<String, Object>> selectMembersOrderList(SqlSessionTemplate sqlSession, String num) throws AdminException;
	
	Map<String, Object> selectCompanyMemberInfo(SqlSessionTemplate sqlSession, String num) throws AdminException;
	
	Map<String, Object> selectNoticeInfo(SqlSessionTemplate sqlSession, String num) throws AdminException;

	void insertNoticeInfo(SqlSessionTemplate sqlSession, AdminBoard adminBoard) throws AdminException;

	void updateNoticeInfo(SqlSessionTemplate sqlSession, AdminBoard adminBoard) throws AdminException;

	void deleteNoticeInfo(SqlSessionTemplate sqlSession, String num) throws AdminException;

	Map<String, Object> selectDeclarationInfo(SqlSessionTemplate sqlSession, String num) throws AdminException;

	void insertBlackMemberAdmin(SqlSessionTemplate sqlSession, String num) throws AdminException;

	void updateMemberStatusAdmin(SqlSessionTemplate sqlSession, String num) throws AdminException;

	void updateReportApprovalAdmin(SqlSessionTemplate sqlSession, String num) throws AdminException;

	Map<String, Object> selectOrderInfo(SqlSessionTemplate sqlSession, String num) throws AdminException;

	List<Map<String, Object>> selectProductInfoForGraph(SqlSessionTemplate sqlSession, String num);


	
}
