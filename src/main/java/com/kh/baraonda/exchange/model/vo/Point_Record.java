package com.kh.baraonda.exchange.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Point_Record implements Serializable{
	private int point_record_no;
	private int member_no;
	private Date point_record_date;
	private int before_point;
	private int after_point;
	private int point_type;
	private int sum_point;
	
	public Point_Record() {}

	public Point_Record(int point_record_no, int member_no, Date point_record_date, int before_point, int after_point,
			int point_type, int sum_point) {
		super();
		this.point_record_no = point_record_no;
		this.member_no = member_no;
		this.point_record_date = point_record_date;
		this.before_point = before_point;
		this.after_point = after_point;
		this.point_type = point_type;
		this.sum_point = sum_point;
	}

	public int getPoint_record_no() {
		return point_record_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public Date getPoint_record_date() {
		return point_record_date;
	}

	public int getBefore_point() {
		return before_point;
	}

	public int getAfter_point() {
		return after_point;
	}

	public int getPoint_type() {
		return point_type;
	}

	public int getSum_point() {
		return sum_point;
	}

	public void setPoint_record_no(int point_record_no) {
		this.point_record_no = point_record_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public void setPoint_record_date(Date point_record_date) {
		this.point_record_date = point_record_date;
	}

	public void setBefore_point(int before_point) {
		this.before_point = before_point;
	}

	public void setAfter_point(int after_point) {
		this.after_point = after_point;
	}

	public void setPoint_type(int point_type) {
		this.point_type = point_type;
	}

	public void setSum_point(int sum_point) {
		this.sum_point = sum_point;
	}

	@Override
	public String toString() {
		return "Point_Record [point_record_no=" + point_record_no + ", member_no=" + member_no + ", point_record_date="
				+ point_record_date + ", before_point=" + before_point + ", after_point=" + after_point
				+ ", point_type=" + point_type + ", sum_point=" + sum_point + "]";
	}

	
	
}
