package com.kh.baraonda.exchange.model.vo;

import java.io.Serializable;

public class Product implements Serializable{
	private int product_no;
	private String product_name;
	private int product_price;
	private int product_type;
	private int point_step;
	
	public Product() {
		
	}

	public Product(int product_no, String product_name, int product_price, int product_type, int point_step) {
		super();
		this.product_no = product_no;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_type = product_type;
		this.point_step = point_step;
	}

	public int getProduct_no() {
		return product_no;
	}

	public String getProduct_name() {
		return product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public int getProduct_type() {
		return product_type;
	}

	public int getPoint_step() {
		return point_step;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public void setProduct_type(int product_type) {
		this.product_type = product_type;
	}

	public void setPoint_step(int point_step) {
		this.point_step = point_step;
	}

	@Override
	public String toString() {
		return "Product [product_no=" + product_no + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_type=" + product_type + ", point_step=" + point_step + "]";
	}

	
}
