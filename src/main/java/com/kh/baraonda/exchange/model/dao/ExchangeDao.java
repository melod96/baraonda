package com.kh.baraonda.exchange.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.exchange.model.vo.Deliver_record;
import com.kh.baraonda.exchange.model.vo.Exchange;
import com.kh.baraonda.exchange.model.vo.Product;

public interface ExchangeDao {

	Product selectProduct(SqlSessionTemplate sqlSession, String change_type);

	void insertOrder(SqlSessionTemplate sqlSession, Exchange ex);

	int orderCurrval(SqlSessionTemplate sqlSession);

	void insertAddress(SqlSessionTemplate sqlSession, Exchange ex);

	int addressCurrval(SqlSessionTemplate sqlSession);

	void insertDeliver(SqlSessionTemplate sqlSession, Deliver_record dr);

}
