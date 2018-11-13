package com.kh.baraonda.exchange.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.exchange.model.vo.Deliver_record;
import com.kh.baraonda.exchange.model.vo.Exchange;
import com.kh.baraonda.exchange.model.vo.Point_Record;
import com.kh.baraonda.exchange.model.vo.Product;
import com.kh.baraonda.myPage.model.vo.Point;

@Repository
public class ExchangeDaoImpl implements ExchangeDao{

	@Override
	public Product selectProduct(SqlSessionTemplate sqlSession, String change_type) {
		
		return sqlSession.selectOne("Exchange.selectProuct", change_type);
	}

	@Override
	public void insertOrder(SqlSessionTemplate sqlSession, Exchange ex) {
		
		sqlSession.insert("Exchange.insertOrder", ex);
		
	}


	@Override
	public void insertAddress(SqlSessionTemplate sqlSession, Exchange ex) {
		
		sqlSession.insert("Exchange.insertAddress",ex);
	}


	@Override
	public void insertDeliver(SqlSessionTemplate sqlSession, Deliver_record dr) {
		
		sqlSession.selectOne("Exchange.insertDeliver", dr);
		
	}

	@Override
	public void updatePoint(SqlSessionTemplate sqlSession, Point point) {
		
		sqlSession.selectOne("Exchange.updatePoint", point);
	}

	@Override
	public void updatePoint_Record(SqlSessionTemplate sqlSession, Point point) {
		sqlSession.selectOne("Exchange.updatePoint_Record", point);
		
	}

}
