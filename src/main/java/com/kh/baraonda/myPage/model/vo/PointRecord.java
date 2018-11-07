package com.kh.baraonda.myPage.model.vo;

import java.sql.Date;

public class PointRecord {

	private int point_record_no;
	private int point_no;
	private Date point_record_date;
	private int before_point;
	private int after_point;
	private int point_type;
	
	public PointRecord() {}

	public PointRecord(int point_record_no, int point_no, Date point_record_date, int before_point, int after_point,
			int point_type) {
		super();
		this.point_record_no = point_record_no;
		this.point_no = point_no;
		this.point_record_date = point_record_date;
		this.before_point = before_point;
		this.after_point = after_point;
		this.point_type = point_type;
	}

	@Override
	public String toString() {
		return "PointRecord [point_record_no=" + point_record_no + ", point_no=" + point_no + ", point_record_date="
				+ point_record_date + ", before_point=" + before_point + ", after_point=" + after_point
				+ ", point_type=" + point_type + "]";
	}

	public int getPoint_record_no() {
		return point_record_no;
	}

	public void setPoint_record_no(int point_record_no) {
		this.point_record_no = point_record_no;
	}

	public int getPoint_no() {
		return point_no;
	}

	public void setPoint_no(int point_no) {
		this.point_no = point_no;
	}

	public Date getPoint_record_date() {
		return point_record_date;
	}

	public void setPoint_record_date(Date point_record_date) {
		this.point_record_date = point_record_date;
	}

	public int getBefore_point() {
		return before_point;
	}

	public void setBefore_point(int before_point) {
		this.before_point = before_point;
	}

	public int getAfter_point() {
		return after_point;
	}

	public void setAfter_point(int after_point) {
		this.after_point = after_point;
	}

	public int getPoint_type() {
		return point_type;
	}

	public void setPoint_type(int point_type) {
		this.point_type = point_type;
	}
	
	
}
