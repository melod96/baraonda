package com.kh.baraonda.admin.model.vo;

import java.sql.Date;

public class AdminDeclarationForMemberDetail implements java.io.Serializable {

	private int report_no;
	private int report_type;
	private String give_nick_name;
	private Date report_date;
	
	public AdminDeclarationForMemberDetail() {
		
	}

	public AdminDeclarationForMemberDetail(int report_no, int report_type, String give_nick_name, Date report_date) {
		super();
		this.report_no = report_no;
		this.report_type = report_type;
		this.give_nick_name = give_nick_name;
		this.report_date = report_date;
	}

	public int getReport_no() {
		return report_no;
	}

	public void setReport_no(int report_no) {
		this.report_no = report_no;
	}

	public int getReport_type() {
		return report_type;
	}

	public void setReport_type(int report_type) {
		this.report_type = report_type;
	}

	public String getGive_nick_name() {
		return give_nick_name;
	}

	public void setGive_nick_name(String give_nick_name) {
		this.give_nick_name = give_nick_name;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	@Override
	public String toString() {
		return "AdminDeclarationForMemberDetail [report_no=" + report_no + ", report_type=" + report_type
				+ ", give_nick_name=" + give_nick_name + ", report_date=" + report_date + "]";
	}
	
	
	
}
