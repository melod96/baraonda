package com.kh.baraonda.dietSupport.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.dietSupport.model.dao.DietSupportDao;
import com.kh.baraonda.dietSupport.model.exception.DietSupportSelectListException;
import com.kh.baraonda.dietSupport.model.vo.HealthCenter;

@Service
public class DietSupportServiceImpl implements DietSupportService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private DietSupportDao dsd;

	@Override
	public int selectCenterListCount() {
		
		return dsd.selectCenterListCount(sqlSession);
	}
	
	@Override
	public ArrayList<HealthCenter> selectCenter(PageInfo pgif) throws DietSupportSelectListException {

		return dsd.selectCenter(sqlSession, pgif);
	}
	
	

}
