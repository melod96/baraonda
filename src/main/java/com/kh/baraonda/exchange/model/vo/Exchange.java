package com.kh.baraonda.exchange.model.vo;

import java.io.Serializable;

public class Exchange implements Serializable{
	private String product_no;
	private String orderer;
	private String orderer_tel;
	private String accept_name;
	private String accept_address1;
	private String accept_address2;
	private String accept_address3;
	private String accept_tel;
	private int member_no;
	private int orders_no;
	private int address_no;
	
	
	public Exchange() {
		
	}


	public Exchange(String product_no, String orderer, String orderer_tel, String accept_name, String accept_address1,
			String accept_address2, String accept_address3, String accept_tel, int member_no, int orders_no,
			int address_no) {
		super();
		this.product_no = product_no;
		this.orderer = orderer;
		this.orderer_tel = orderer_tel;
		this.accept_name = accept_name;
		this.accept_address1 = accept_address1;
		this.accept_address2 = accept_address2;
		this.accept_address3 = accept_address3;
		this.accept_tel = accept_tel;
		this.member_no = member_no;
		this.orders_no = orders_no;
		this.address_no = address_no;
	}


	public String getProduct_no() {
		return product_no;
	}


	public String getOrderer() {
		return orderer;
	}


	public String getOrderer_tel() {
		return orderer_tel;
	}


	public String getAccept_name() {
		return accept_name;
	}


	public String getAccept_address1() {
		return accept_address1;
	}


	public String getAccept_address2() {
		return accept_address2;
	}


	public String getAccept_address3() {
		return accept_address3;
	}


	public String getAccept_tel() {
		return accept_tel;
	}


	public int getMember_no() {
		return member_no;
	}


	public int getOrders_no() {
		return orders_no;
	}


	public int getAddress_no() {
		return address_no;
	}


	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}


	public void setOrderer(String orderer) {
		this.orderer = orderer;
	}


	public void setOrderer_tel(String orderer_tel) {
		this.orderer_tel = orderer_tel;
	}


	public void setAccept_name(String accept_name) {
		this.accept_name = accept_name;
	}


	public void setAccept_address1(String accept_address1) {
		this.accept_address1 = accept_address1;
	}


	public void setAccept_address2(String accept_address2) {
		this.accept_address2 = accept_address2;
	}


	public void setAccept_address3(String accept_address3) {
		this.accept_address3 = accept_address3;
	}


	public void setAccept_tel(String accept_tel) {
		this.accept_tel = accept_tel;
	}


	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}


	public void setOrders_no(int orders_no) {
		this.orders_no = orders_no;
	}


	public void setAddress_no(int address_no) {
		this.address_no = address_no;
	}


	@Override
	public String toString() {
		return "Exchange [product_no=" + product_no + ", orderer=" + orderer + ", orderer_tel=" + orderer_tel
				+ ", accept_name=" + accept_name + ", accept_address1=" + accept_address1 + ", accept_address2="
				+ accept_address2 + ", accept_address3=" + accept_address3 + ", accept_tel=" + accept_tel
				+ ", member_no=" + member_no + ", orders_no=" + orders_no + ", address_no=" + address_no + "]";
	}

	
	
	
}
