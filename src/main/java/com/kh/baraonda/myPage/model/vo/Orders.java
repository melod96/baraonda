package com.kh.baraonda.myPage.model.vo;

import java.sql.Date;

public class Orders {

	private int orders_no;
	private int member_no;
	private int product_no;
	private Date orders_date;
	private int orders_type;
	private int product_quantity;
	private Date banner_start_date;
	private Date banner_end_date;
	private String banner_content;
	private String addressee_name;
	private String address;
	private String addressee_phone;
	private String product_name;
	
	public Orders () {}

	public Orders(int orders_no, int member_no, int product_no, Date orders_date, int orders_type, int product_quantity,
			Date banner_start_date, Date banner_end_date, String banner_content, String addressee_name, String address,
			String addressee_phone, String product_name) {
		super();
		this.orders_no = orders_no;
		this.member_no = member_no;
		this.product_no = product_no;
		this.orders_date = orders_date;
		this.orders_type = orders_type;
		this.product_quantity = product_quantity;
		this.banner_start_date = banner_start_date;
		this.banner_end_date = banner_end_date;
		this.banner_content = banner_content;
		this.addressee_name = addressee_name;
		this.address = address;
		this.addressee_phone = addressee_phone;
		this.product_name = product_name;
	}

	@Override
	public String toString() {
		return "Orders [orders_no=" + orders_no + ", member_no=" + member_no + ", product_no=" + product_no
				+ ", orders_date=" + orders_date + ", orders_type=" + orders_type + ", product_quantity="
				+ product_quantity + ", banner_start_date=" + banner_start_date + ", banner_end_date=" + banner_end_date
				+ ", banner_content=" + banner_content + ", addressee_name=" + addressee_name + ", address=" + address
				+ ", addressee_phone=" + addressee_phone + ", product_name=" + product_name + "]";
	}

	public int getOrders_no() {
		return orders_no;
	}

	public void setOrders_no(int orders_no) {
		this.orders_no = orders_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public Date getOrders_date() {
		return orders_date;
	}

	public void setOrders_date(Date orders_date) {
		this.orders_date = orders_date;
	}

	public int getOrders_type() {
		return orders_type;
	}

	public void setOrders_type(int orders_type) {
		this.orders_type = orders_type;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public Date getBanner_start_date() {
		return banner_start_date;
	}

	public void setBanner_start_date(Date banner_start_date) {
		this.banner_start_date = banner_start_date;
	}

	public Date getBanner_end_date() {
		return banner_end_date;
	}

	public void setBanner_end_date(Date banner_end_date) {
		this.banner_end_date = banner_end_date;
	}

	public String getBanner_content() {
		return banner_content;
	}

	public void setBanner_content(String banner_content) {
		this.banner_content = banner_content;
	}

	public String getAddressee_name() {
		return addressee_name;
	}

	public void setAddressee_name(String addressee_name) {
		this.addressee_name = addressee_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressee_phone() {
		return addressee_phone;
	}

	public void setAddressee_phone(String addressee_phone) {
		this.addressee_phone = addressee_phone;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	
	
	
}
