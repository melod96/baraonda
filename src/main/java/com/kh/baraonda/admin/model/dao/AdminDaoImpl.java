package com.kh.baraonda.admin.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.admin.model.exception.AdminException;
import com.kh.baraonda.admin.model.vo.AdminBlackMember;
import com.kh.baraonda.admin.model.vo.AdminCompanyMember;
import com.kh.baraonda.admin.model.vo.AdminGeneralMember;
import com.kh.baraonda.admin.model.vo.Search;
import com.kh.baraonda.common.PageInfo;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Override
	public int selectGeneralMemberCount(SqlSessionTemplate sqlSession, Search search) throws AdminException {
		return sqlSession.selectOne("Admin.selectGeneralMemberCount", search);
	}

	@Override
	public ArrayList<AdminGeneralMember> selectGeneralMemberList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException {
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds((pi.getCurrentPage() -1) * pi.getLimit(), pi.getLimit());
		return (ArrayList)(sqlSession.selectList("Admin.selectGeneralMemberList" , search, rowBounds));
	}

	@Override
	public int selectCompanyMemberCount(SqlSessionTemplate sqlSession, Search search) throws AdminException {
		return sqlSession.selectOne("Admin.selectCompanyMemberCount", search);
	}

	@Override
	public ArrayList<AdminCompanyMember> selectCompanyMemberList(SqlSessionTemplate sqlSession, PageInfo pi, Search search) throws AdminException {
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds((pi.getCurrentPage() -1) * pi.getLimit(), pi.getLimit());
		return (ArrayList)(sqlSession.selectList("Admin.selectCompanyMemberList" , search, rowBounds));
	}

	@Override
	public int selectBlackMemberCount(SqlSessionTemplate sqlSession, Search search) throws AdminException {
		return sqlSession.selectOne("Admin.selectBlackMemberCount", search);
	}

	@Override
	public ArrayList<AdminBlackMember> selectBlackMemberList(SqlSessionTemplate sqlSession, PageInfo pi, Search search)	throws AdminException {
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds((pi.getCurrentPage() -1) * pi.getLimit(), pi.getLimit());
		return (ArrayList)(sqlSession.selectList("Admin.selectBlakcMemberList" , search, rowBounds));
	}

}
