package com.kh.baraonda.admin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.admin.model.dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired //Dao역시 의존성 주입을 위해 Autowired 어노테이션으로 생성해준다.
	private AdminDao ad;
	
}
