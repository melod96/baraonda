package com.kh.baraonda.exchange.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.baraonda.exchange.model.vo.Deliver_record;
import com.kh.baraonda.exchange.model.vo.Exchange;
import com.kh.baraonda.exchange.model.vo.Point_Record;
import com.kh.baraonda.exchange.model.vo.Product;
import com.kh.baraonda.myPage.model.vo.Point;

public interface ExchangeDao {

	Product selectProduct(SqlSessionTemplate sqlSession, String change_type);

	void insertOrder(SqlSessionTemplate sqlSession, Exchange ex);


	void insertAddress(SqlSessionTemplate sqlSession, Exchange ex);


	void insertDeliver(SqlSessionTemplate sqlSession, Deliver_record dr);

	void updatePoint(SqlSessionTemplate sqlSession, Point point);

	void updatePoint_Record(SqlSessionTemplate sqlSession, Point_Record pr);

}
