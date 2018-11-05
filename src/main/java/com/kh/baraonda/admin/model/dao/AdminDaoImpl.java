package com.kh.baraonda.admin.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.admin.model.exception.AdminException;
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

}
