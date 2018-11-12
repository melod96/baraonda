package com.kh.baraonda.exchange.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Deliver_record implements Serializable{
	private int deliver_no;
	private int address_no;
	private int orders_no;
	private Date deliver_date;
	private String tracking_no;
	
	public Deliver_record() {
		
	}

	public Deliver_record(int deliver_no, int address_no, int orders_no, Date deliver_date, String tracking_no) {
		super();
		this.deliver_no = deliver_no;
		this.address_no = address_no;
		this.orders_no = orders_no;
		this.deliver_date = deliver_date;
		this.tracking_no = tracking_no;
	}

	public int getDeliver_no() {
		return deliver_no;
	}

	public int getAddress_no() {
		return address_no;
	}

	public int getOrders_no() {
		return orders_no;
	}

	public Date getDeliver_date() {
		return deliver_date;
	}

	public String getTracking_no() {
		return tracking_no;
	}

	public void setDeliver_no(int deliver_no) {
		this.deliver_no = deliver_no;
	}

	public void setAddress_no(int address_no) {
		this.address_no = address_no;
	}

	public void setOrders_no(int orders_no) {
		this.orders_no = orders_no;
	}

	public void setDeliver_date(Date deliver_date) {
		this.deliver_date = deliver_date;
	}

	public void setTracking_no(String tracking_no) {
		this.tracking_no = tracking_no;
	}

	@Override
	public String toString() {
		return "Deliver_record [deliver_no=" + deliver_no + ", address_no=" + address_no + ", orders_no=" + orders_no
				+ ", deliver_date=" + deliver_date + ", tracking_no=" + tracking_no + "]";
	}
	
	
}
