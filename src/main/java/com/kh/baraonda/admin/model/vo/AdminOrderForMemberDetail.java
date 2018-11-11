package com.kh.baraonda.admin.model.vo;

import java.sql.Date;

public class AdminOrderForMemberDetail implements java.io.Serializable {

	private int orders_no;
	private String product_name;
	private int product_quantity;
	private Date orders_date;
	
	public AdminOrderForMemberDetail() {
		
	}

	public AdminOrderForMemberDetail(int orders_no, String product_name, int product_quantity, Date orders_date) {
		super();
		this.orders_no = orders_no;
		this.product_name = product_name;
		this.product_quantity = product_quantity;
		this.orders_date = orders_date;
	}

	public int getOrders_no() {
		return orders_no;
	}

	public void setOrders_no(int orders_no) {
		this.orders_no = orders_no;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public Date getOrders_date() {
		return orders_date;
	}

	public void setOrders_date(Date orders_date) {
		this.orders_date = orders_date;
	}

	@Override
	public String toString() {
		return "AdminOrderForMemberDetail [orders_no=" + orders_no + ", product_name=" + product_name
				+ ", product_quantity=" + product_quantity + ", orders_date=" + orders_date + "]";
	}
	
	
	
}
