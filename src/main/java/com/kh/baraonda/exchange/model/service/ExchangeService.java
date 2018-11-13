package com.kh.baraonda.exchange.model.service;

import com.kh.baraonda.exchange.model.vo.Deliver_record;
import com.kh.baraonda.exchange.model.vo.Exchange;
import com.kh.baraonda.exchange.model.vo.Product;
import com.kh.baraonda.myPage.model.vo.Point;

public interface ExchangeService {

	Product selectProduct(String change_type);

	void insertOrder(Exchange ex);


	void insertAddress(Exchange ex);


	void insertDeliver(Deliver_record dr);

	void updatePoint(Point point);

}
