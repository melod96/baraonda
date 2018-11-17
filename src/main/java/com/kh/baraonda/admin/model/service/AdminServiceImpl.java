package com.kh.baraonda.admin.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.admin.model.dao.AdminDao;
import com.kh.baraonda.admin.model.exception.AdminException;
import com.kh.baraonda.admin.model.vo.AdminBoard;
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
		return ad.selectNoticeInfo(sqlSession, num);
	}

	@Override
	public void insertNoticeInfo(AdminBoard adminBoard) throws AdminException {
		ad.insertNoticeInfo(sqlSession, adminBoard);
	}

	@Override
	public void updateNoticeInfo(AdminBoard adminBoard) throws AdminException {
		ad.updateNoticeInfo(sqlSession, adminBoard);	
	}

	@Override
	public void deleteNoticeInfo(String num) throws AdminException {
		ad.deleteNoticeInfo(sqlSession, num);
	}

	@Override
	public Map<String, Object> selectDeclarationInfo(String num) throws AdminException {
		return ad.selectDeclarationInfo(sqlSession, num);
	}

	@Override
	public void insertBlackMemberAdmin(String num) throws AdminException {
		ad.insertBlackMemberAdmin(sqlSession, num);
		ad.updateMemberStatusAdmin(sqlSession, num);
		ad.updateReportApprovalAdmin(sqlSession, num);
	}

	@Override
	public Map<String, Object> selectOrderInfo(String num) throws AdminException {
		return ad.selectOrderInfo(sqlSession, num);
	}

	@Override
	public Map<String, Object> selectProductInfoForGraph(String num) throws AdminException {
		return ad.selectProductInfoForGraph(sqlSession, num);
	}

	@Override
	public Map<String, Object> selectMemberInfoForDashboard() throws AdminException {
		return ad.selectMemberInfoForDashboard(sqlSession);
	}

	@Override
	public Map<String, Object> selectDashboardInfo() throws AdminException {
		return ad.selectDashboardInfo(sqlSession);
	}

	@Override
	public List<Map<String, Object>> selectBoardInfo() throws AdminException {
		return ad.selectBoardInfo(sqlSession);
	}

	@Override
	public List<Map<String, Object>> selectProductInfo() throws AdminException {
		return ad.selectProductInfo(sqlSession);
	}

	@Override
	public Map<String, Object> selectOrderInfo() throws AdminException {
		return ad.selectOrderInfo(sqlSession);
	}

	@Override
	public int selectExperienceCount(Search search) throws AdminException {
		return ad.selectExperienceCount(sqlSession, search);
	}

	@Override
	public List<Map<String, Object>> selectExperienceList(PageInfo pi, Search search) throws AdminException {
		return ad.selectExperienceList(sqlSession, pi, search);
	}


	
	

}
