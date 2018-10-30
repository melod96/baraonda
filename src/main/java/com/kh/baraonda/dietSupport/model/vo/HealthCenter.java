package com.kh.baraonda.dietSupport.model.vo;

import java.io.Serializable;

public class HealthCenter implements Serializable{
	private int id;
	private String location;
	private String state;
	private String name;
	private String address;
	private String tel;
	private String homepage;
	
	public HealthCenter() {
		
	}

	public HealthCenter(int id, String location, String state, String name, String address, String tel,
			String homepage) {
		super();
		this.id = id;
		this.location = location;
		this.state = state;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.homepage = homepage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	@Override
	public String toString() {
		return "HealthCenter [id=" + id + ", location=" + location + ", state=" + state + ", name=" + name
				+ ", address=" + address + ", tel=" + tel + ", homepage=" + homepage + "]";
	}
	
	
}
