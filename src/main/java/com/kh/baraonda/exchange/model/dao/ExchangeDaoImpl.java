package com.kh.baraonda.exchange.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.baraonda.exchange.model.vo.Deliver_record;
import com.kh.baraonda.exchange.model.vo.Exchange;
import com.kh.baraonda.exchange.model.vo.Product;

@Repository
public class ExchangeDaoImpl implements ExchangeDao{

	@Override
	public Product selectProduct(SqlSessionTemplate sqlSession, String change_type) {
		
		return sqlSession.selectOne("Exchange.selectProuct", change_type);
	}

	@Override
	public void insertOrder(SqlSessionTemplate sqlSession, Exchange ex) {
		
		sqlSession.selectOne("Exchange.insertOrder", ex);
		
	}

	@Override
	public int orderCurrval(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("Exchage.orderCurrval");
	}

	@Override
	public void insertAddress(SqlSessionTemplate sqlSession, Exchange ex) {
		
		sqlSession.selectOne("Exchange.insertAddress",ex);
	}

	@Override
	public int addressCurrval(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("Exchange.addressCurrval");
	}

	@Override
	public void insertDeliver(SqlSessionTemplate sqlSession, Deliver_record dr) {
		
		sqlSession.selectOne("Exchange.insertDeliver", dr);
		
	}

}
