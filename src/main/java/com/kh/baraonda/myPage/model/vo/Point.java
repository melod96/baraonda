package com.kh.baraonda.myPage.model.vo;

import java.sql.Date;

public class Point {

	private int point_no;
	private int member_no;
	private Date point_change_date;
	private int accrue_point;
	
	public Point() {}
	
	public Point(int point_no, int member_no, Date point_change_date, int accrue_point) {
		super();
		this.point_no = point_no;
		this.member_no = member_no;
		this.point_change_date = point_change_date;
		this.accrue_point = accrue_point;
	}


	@Override
	public String toString() {
		return "Point [point_no=" + point_no + ", member_no=" + member_no + ", point_change_date=" + point_change_date
				+ ", accrue_point=" + accrue_point + "]";
	}


	public int getPoint_no() {
		return point_no;
	}


	public void setPoint_no(int point_no) {
		this.point_no = point_no;
	}


	public int getMember_no() {
		return member_no;
	}


	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}


	public Date getPoint_change_date() {
		return point_change_date;
	}


	public void setPoint_change_date(Date point_change_date) {
		this.point_change_date = point_change_date;
	}


	public int getAccrue_point() {
		return accrue_point;
	}


	public void setAccrue_point(int accrue_point) {
		this.accrue_point = accrue_point;
	}
	
	
	
	
}
