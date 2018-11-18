package com.kh.baraonda.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.admin.model.exception.AdminException;
import com.kh.baraonda.admin.model.vo.AdminBoard;
import com.kh.baraonda.admin.model.vo.Search;
import com.kh.baraonda.common.PageInfo;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Override
	public int selectGeneralMemberCount(SqlSessionTemplate sqlSession, Search search) throws AdminException {
		return sqlSession.selectOne("Admin.selectGeneralMemberCount", search);
	}

	@Override
	public List<Map<String, Object>> selectGeneralMemberList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException {
		RowBounds rowBounds = new RowBounds((pi.getCurrentPage() -1) * pi.getLimit(), pi.getLimit());
		return sqlSession.selectList("Admin.selectGeneralMemberList" , search, rowBounds);
	}

	@Override
	public int selectCompanyMemberCount(SqlSessionTemplate sqlSession, Search search) throws AdminException {
		return sqlSession.selectOne("Admin.selectCompanyMemberCount", search);
	}

	@Override
	public List<Map<String, Object>> selectCompanyMemberList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException {
		RowBounds rowBounds = new RowBounds((pi.getCurrentPage() -1) * pi.getLimit(), pi.getLimit());
		return sqlSession.selectList("Admin.selectCompanyMemberList" , search, rowBounds);
	}

	@Override
	public int selectBlackMemberCount(SqlSessionTemplate sqlSession, Search search) throws AdminException {
		return sqlSession.selectOne("Admin.selectBlackMemberCount", search);
	}

	@Override
	public List<Map<String, Object>> selectBlackMemberList(SqlSessionTemplate sqlSession, PageInfo pi, Search search)	throws AdminException {
		RowBounds rowBounds = new RowBounds((pi.getCurrentPage() -1) * pi.getLimit(), pi.getLimit());
		return sqlSession.selectList("Admin.selectBlakcMemberList" , search, rowBounds);
	}

	@Override
	public int selectNoticeCount(SqlSessionTemplate sqlSession, Search search) throws AdminException {
		return sqlSession.selectOne("Admin.selectNoticeCount", search);
	}

	@Override
	public List<Map<String, Object>> selectNoticeList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException {
		RowBounds rowBounds = new RowBounds((pi.getCurrentPage() -1) * pi.getLimit(), pi.getLimit());
		return sqlSession.selectList("Admin.selectNoticeList" , search, rowBounds);
	}
	
	@Override
	public int selectDeclarationCount(SqlSessionTemplate sqlSession, Search search) throws AdminException {
		return sqlSession.selectOne("Admin.selectDeclarationCount", search);
	}

	@Override
	public List<Map<String, Object>> selectDeclarationList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException {
		RowBounds rowBounds = new RowBounds((pi.getCurrentPage() -1) * pi.getLimit(), pi.getLimit());
		return sqlSession.selectList("Admin.selectDeclarationList" , search, rowBounds);
	}
	
	@Override
	public int selectOrderCount(SqlSessionTemplate sqlSession, Search search) throws AdminException {
		return sqlSession.selectOne("Admin.selectOrderCount", search);
	}

	@Override
	public List<Map<String, Object>> selectOrderList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException {
		RowBounds rowBounds = new RowBounds((pi.getCurrentPage() -1) * pi.getLimit(), pi.getLimit());
		return sqlSession.selectList("Admin.selectOrderList" , search, rowBounds);
	}

	@Override
	public Map<String, Object> selectGeneralMemberInfo(SqlSessionTemplate sqlSession, String num) throws AdminException {
		return sqlSession.selectOne("Admin.selectGeneralMemberInfo", num);
	}

	@Override
	public List<Map<String, Object>> selectMembersDeclarationList(SqlSessionTemplate sqlSession, String num) throws AdminException {
		return sqlSession.selectList("Admin.selectMembersDeclarationList", num);
	}

	@Override
	public List<Map<String, Object>> selectMembersOrderList(SqlSessionTemplate sqlSession, String num) throws AdminException {
		return sqlSession.selectList("Admin.selectMembersOrderList", num);
	}

	@Override
	public Map<String, Object> selectCompanyMemberInfo(SqlSessionTemplate sqlSession, String num) throws AdminException {
		return sqlSession.selectOne("Admin.selectCompanyMemberInfo", num);
	}

	@Override
	public Map<String, Object> selectNoticeInfo(SqlSessionTemplate sqlSession, String num) throws AdminException {
		return sqlSession.selectOne("Admin.selectNoticeInfo", num);
	}

	@Override
	public void insertNoticeInfo(SqlSessionTemplate sqlSession, AdminBoard adminBoard) throws AdminException {
		sqlSession.insert("Admin.insertNoticeInfo", adminBoard);	
	}

	@Override
	public void updateNoticeInfo(SqlSessionTemplate sqlSession, AdminBoard adminBoard) throws AdminException {
		sqlSession.update("Admin.updateNoticeInfo", adminBoard);	
	}

	@Override
	public void deleteNoticeInfo(SqlSessionTemplate sqlSession, String num) throws AdminException {
		sqlSession.update("Admin.deleteNoticeInfo", num);
	}

	@Override
	public Map<String, Object> selectDeclarationInfo(SqlSessionTemplate sqlSession, String num) throws AdminException {
		return sqlSession.selectOne("Admin.selectDeclarationInfo", num);
	}

	@Override
	public void insertBlackMemberAdmin(SqlSessionTemplate sqlSession, String num) throws AdminException {
		sqlSession.insert("Admin.insertBlackMemberAdmin", num);	
	}

	@Override
	public void updateMemberStatusAdmin(SqlSessionTemplate sqlSession, String num) throws AdminException {
		sqlSession.update("Admin.updateMemberStatusAdmin", num);
	}

	@Override
	public void updateReportApprovalAdmin(SqlSessionTemplate sqlSession, String num) throws AdminException {	
		sqlSession.update("Admin.updateReportApprovalAdmin", num);
	}

	@Override
	public Map<String, Object> selectOrderInfo(SqlSessionTemplate sqlSession, String num) throws AdminException {
		return sqlSession.selectOne("Admin.selectOrderInfo", num);
	}

	@Override
	public Map<String, Object> selectProductInfoForGraph(SqlSessionTemplate sqlSession, String num) throws AdminException{
		return sqlSession.selectOne("Admin.selectProductInfoForGraph", num);
	}

	@Override
	public Map<String, Object> selectMemberInfoForDashboard(SqlSessionTemplate sqlSession) throws AdminException{
		return sqlSession.selectOne("Admin.selectMemberInfoForDashboard");
	}

	@Override
	public Map<String, Object> selectDashboardInfo(SqlSessionTemplate sqlSession) throws AdminException {
		return sqlSession.selectOne("Admin.selectDashboardInfo");
	}

	@Override
	public List<Map<String, Object>> selectBoardInfo(SqlSessionTemplate sqlSession) throws AdminException {
		return sqlSession.selectList("Admin.selectBoardInfo");
	}

	@Override
	public List<Map<String, Object>> selectProductInfo(SqlSessionTemplate sqlSession) throws AdminException {
		return sqlSession.selectList("Admin.selectProductInfo");
	}

	@Override
	public Map<String, Object> selectOrderInfo(SqlSessionTemplate sqlSession) throws AdminException {
		return sqlSession.selectOne("Admin.selectOrderInfoP");
	}

	@Override
	public int selectExperienceCount(SqlSessionTemplate sqlSession, Search search) throws AdminException {
		return sqlSession.selectOne("Admin.selectExperienceCount", search);
	}

	@Override
	public List<Map<String, Object>> selectExperienceList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException {
		RowBounds rowBounds = new RowBounds((pi.getCurrentPage() -1) * pi.getLimit(), pi.getLimit());
		return sqlSession.selectList("Admin.selectExperienceList" , search, rowBounds);
	}

	
	

}
