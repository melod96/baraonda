package com.kh.baraonda.myPage.model.vo;

import java.sql.Date;

public class Footprints {

	private int check_count;
	private int board_count;
	private int comments_count;
	private int marking_count;
	private int accrue_point;
	private Date enroll_date;
	
	
	public Footprints() {}


	public Footprints(int check_count, int board_count, int comments_count, int marking_count, int accrue_point,
			Date enroll_date) {
		super();
		this.check_count = check_count;
		this.board_count = board_count;
		this.comments_count = comments_count;
		this.marking_count = marking_count;
		this.accrue_point = accrue_point;
		this.enroll_date = enroll_date;
	}


	@Override
	public String toString() {
		return "Footprints [check_count=" + check_count + ", board_count=" + board_count + ", comments_count="
				+ comments_count + ", marking_count=" + marking_count + ", accrue_point=" + accrue_point
				+ ", enroll_date=" + enroll_date + "]";
	}


	public int getCheck_count() {
		return check_count;
	}


	public void setCheck_count(int check_count) {
		this.check_count = check_count;
	}


	public int getBoard_count() {
		return board_count;
	}


	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}


	public int getComments_count() {
		return comments_count;
	}


	public void setComments_count(int comments_count) {
		this.comments_count = comments_count;
	}


	public int getMarking_count() {
		return marking_count;
	}


	public void setMarking_count(int marking_count) {
		this.marking_count = marking_count;
	}


	public int getAccrue_point() {
		return accrue_point;
	}


	public void setAccrue_point(int accrue_point) {
		this.accrue_point = accrue_point;
	}


	public Date getEnroll_date() {
		return enroll_date;
	}


	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}
	
	
	
}
