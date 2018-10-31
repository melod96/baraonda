package com.kh.baraonda.dietSupport.model.vo;

import java.io.Serializable;

public class HealthCenter implements Serializable{
	private int center_no;
	private String center_location;
	private String center_state;
	private String center_name;
	private String center_address;
	private String center_tel;
	private String center_page;
	
	public HealthCenter() {
		
	}

	public HealthCenter(int center_no, String center_location, String center_state, String center_name,
			String center_address, String center_tel, String center_page) {
		super();
		this.center_no = center_no;
		this.center_location = center_location;
		this.center_state = center_state;
		this.center_name = center_name;
		this.center_address = center_address;
		this.center_tel = center_tel;
		this.center_page = center_page;
	}

	public int getCenter_no() {
		return center_no;
	}

	public void setCenter_no(int center_no) {
		this.center_no = center_no;
	}

	public String getCenter_location() {
		return center_location;
	}

	public void setCenter_location(String center_location) {
		this.center_location = center_location;
	}

	public String getCenter_state() {
		return center_state;
	}

	public void setCenter_state(String center_state) {
		this.center_state = center_state;
	}

	public String getCenter_name() {
		return center_name;
	}

	public void setCenter_name(String center_name) {
		this.center_name = center_name;
	}

	public String getCenter_address() {
		return center_address;
	}

	public void setCenter_address(String center_address) {
		this.center_address = center_address;
	}

	public String getCenter_tel() {
		return center_tel;
	}

	public void setCenter_tel(String center_tel) {
		this.center_tel = center_tel;
	}

	public String getCenter_page() {
		return center_page;
	}

	public void setCenter_page(String center_page) {
		this.center_page = center_page;
	}

	@Override
	public String toString() {
		return "HealthCenter [center_no=" + center_no + ", center_location=" + center_location + ", center_state="
				+ center_state + ", center_name=" + center_name + ", center_address=" + center_address + ", center_tel="
				+ center_tel + ", center_page=" + center_page + "]";
	}

	
	
	
}
