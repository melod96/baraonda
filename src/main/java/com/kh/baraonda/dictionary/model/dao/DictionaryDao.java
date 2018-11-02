package com.kh.baraonda.dictionary.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.dictionary.model.exception.DictionaryException;
import com.kh.baraonda.dictionary.model.vo.FoodDictionary;

public interface DictionaryDao {

	int selectFoodListCount(SqlSessionTemplate sqlSession);

	ArrayList<FoodDictionary> selectFoodList(SqlSessionTemplate sqlSession, PageInfo pgif) throws DictionaryException;

	int selectSearchFoodListCount(SqlSessionTemplate sqlSession, String search);

	ArrayList<FoodDictionary> selectSearchFoodList(SqlSessionTemplate sqlSession, String search, PageInfo pgif) throws DictionaryException;

}
