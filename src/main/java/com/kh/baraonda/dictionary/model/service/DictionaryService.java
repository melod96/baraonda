package com.kh.baraonda.dictionary.model.service;

import java.util.ArrayList;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.dictionary.model.exception.DictionaryException;
import com.kh.baraonda.dictionary.model.vo.FoodDictionary;

public interface DictionaryService {

	int selectFoodListCount();

	ArrayList<FoodDictionary> selectFoodList(PageInfo pgif) throws DictionaryException;

	int selectSearchFoodListCount(String search);

	ArrayList<FoodDictionary> selectSearchFoodList(String search, PageInfo pgif) throws DictionaryException;

}
