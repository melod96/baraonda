package com.kh.baraonda.admin.model.vo;

import java.sql.Date;

public class AdminOrder implements java.io.Serializable {

	private int orders_no;
	private String name;
	private String product_name;
	private int product_quantity;
	private Date orders_date;
	private String phone;
	
	public AdminOrder () {
		
	}

	public AdminOrder(int orders_no, String name, String product_name, int product_quantity, Date orders_date,
			String phone) {
		super();
		this.orders_no = orders_no;
		this.name = name;
		this.product_name = product_name;
		this.product_quantity = product_quantity;
		this.orders_date = orders_date;
		this.phone = phone;
	}

	public int getOrders_no() {
		return orders_no;
	}

	public void setOrders_no(int orders_no) {
		this.orders_no = orders_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "AdminOrder [orders_no=" + orders_no + ", name=" + name + ", product_name=" + product_name
				+ ", product_quantity=" + product_quantity + ", orders_date=" + orders_date + ", phone=" + phone + "]";
	}

	
	
}
