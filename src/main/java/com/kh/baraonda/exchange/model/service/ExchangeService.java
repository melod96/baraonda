package com.kh.baraonda.exchange.model.service;

import com.kh.baraonda.exchange.model.vo.Deliver_record;
import com.kh.baraonda.exchange.model.vo.Exchange;
import com.kh.baraonda.exchange.model.vo.Product;

public interface ExchangeService {

	Product selectProduct(String change_type);

	void insertOrder(Exchange ex);

	int orderCurrval();

	void insertAddress(Exchange ex);

	int addressCurrval();

	void insertDeliver(Deliver_record dr);

}
