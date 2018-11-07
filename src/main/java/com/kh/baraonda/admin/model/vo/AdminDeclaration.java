package com.kh.baraonda.admin.model.vo;

import java.sql.Date;

public class AdminDeclaration implements java.io.Serializable {

	private int report_no;
	private int report_type;
	private String give_nick_name;
	private String get_nick_name;
	private Date report_date;
	private int report_approval;
	
	public AdminDeclaration() {
		
	}

	public AdminDeclaration(int report_no, int report_type, String give_nick_name, String get_nick_name,
			Date report_date, int report_approval) {
		super();
		this.report_no = report_no;
		this.report_type = report_type;
		this.give_nick_name = give_nick_name;
		this.get_nick_name = get_nick_name;
		this.report_date = report_date;
		this.report_approval = report_approval;
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

	public String getGet_nick_name() {
		return get_nick_name;
	}

	public void setGet_nick_name(String get_nick_name) {
		this.get_nick_name = get_nick_name;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public int getReport_approval() {
		return report_approval;
	}

	public void setReport_approval(int report_approval) {
		this.report_approval = report_approval;
	}

	@Override
	public String toString() {
		return "AdminDeclaration [report_no=" + report_no + ", report_type=" + report_type + ", give_nick_name="
				+ give_nick_name + ", get_nick_name=" + get_nick_name + ", report_date=" + report_date
				+ ", report_approval=" + report_approval + "]";
	}
	
	
	
}
