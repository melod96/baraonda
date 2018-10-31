package com.kh.baraonda.dietSupport.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.dietSupport.model.exception.DietSupportSelectListException;
import com.kh.baraonda.dietSupport.model.vo.HealthCenter;

public interface DietSupportDao {

	int selectCenterListCount(SqlSessionTemplate sqlSession);

	ArrayList<HealthCenter> selectCenter(SqlSessionTemplate sqlSession, PageInfo pgif) throws DietSupportSelectListException;

	


}
