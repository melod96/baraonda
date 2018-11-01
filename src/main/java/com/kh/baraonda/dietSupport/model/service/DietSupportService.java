package com.kh.baraonda.dietSupport.model.service;

import java.util.ArrayList;

import com.kh.baraonda.common.PageInfo;
import com.kh.baraonda.dietSupport.model.exception.DietSupportSelectListException;
import com.kh.baraonda.dietSupport.model.vo.HealthCenter;

public interface DietSupportService {

	int selectCenterListCount();

	ArrayList<HealthCenter> selectCenter(PageInfo pgif) throws DietSupportSelectListException;

	int searchCenterListCount(String state);

	ArrayList<HealthCenter> searchCenter(String state, PageInfo pgif) throws DietSupportSelectListException;
	
	


}
