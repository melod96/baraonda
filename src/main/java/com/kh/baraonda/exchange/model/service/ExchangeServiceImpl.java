package com.kh.baraonda.exchange.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.baraonda.exchange.model.dao.ExchangeDao;
import com.kh.baraonda.exchange.model.vo.Deliver_record;
import com.kh.baraonda.exchange.model.vo.Exchange;
import com.kh.baraonda.exchange.model.vo.Product;

@Service
public class ExchangeServiceImpl implements ExchangeService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private ExchangeDao ecd;
	
	@Override
	public Product selectProduct(String change_type) {
		
		return ecd.selectProduct(sqlSession, change_type);
	}

	@Override
	public void insertOrder(Exchange ex) {
		
		ecd.insertOrder(sqlSession, ex);
		
	}

	@Override
	public int orderCurrval() {
		
		return ecd.orderCurrval(sqlSession);
	}

	@Override
	public void insertAddress(Exchange ex) {
		ecd.insertAddress(sqlSession, ex);
		
	}

	@Override
	public int addressCurrval() {
		
		return ecd.addressCurrval(sqlSession);
	}

	@Override
	public void insertDeliver(Deliver_record dr) {
		
		ecd.insertDeliver(sqlSession, dr);
		
	}

}
