package com.kh.baraonda.dictionary.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.dictionary.model.dao.DictionaryDao;
import com.kh.baraonda.dictionary.model.exception.DictionaryException;
import com.kh.baraonda.dictionary.model.vo.FoodDictionary;

@Service
public class DictionaryServiceImpl implements DictionaryService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private DictionaryDao dd;
	
	@Override
	public int selectFoodListCount() {
		
		return dd.selectFoodListCount(sqlSession);
	}

	@Override
	public ArrayList<FoodDictionary> selectFoodList(PageInfo pgif) throws DictionaryException {
		
		return dd.selectFoodList(sqlSession, pgif);
	}

	@Override
	public int selectSearchFoodListCount(String search) {
		
		return dd.selectSearchFoodListCount(sqlSession, search);
	}

	@Override
	public ArrayList<FoodDictionary> selectSearchFoodList(String search, PageInfo pgif) throws DictionaryException {
		
		return dd.selectSearchFoodList(sqlSession, search, pgif);
	}

	@Override
	public FoodDictionary selectFoodInfo(String food_no) {
		
		return dd.selectFoodInfo(sqlSession, food_no);
	}
	
}
