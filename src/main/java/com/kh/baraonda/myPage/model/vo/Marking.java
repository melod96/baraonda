package com.kh.baraonda.myPage.model.vo;

import java.sql.Date;

public class Marking {

	
	private int marking_no;
	private int marking_type;
	private Date marking_date;
	private int board_no;
	private int member_no;
	private int marking_count;

	public Marking() {}

	public Marking(int marking_no, int marking_type, Date marking_date, int board_no, int member_no,
			int marking_count) {
		super();
		this.marking_no = marking_no;
		this.marking_type = marking_type;
		this.marking_date = marking_date;
		this.board_no = board_no;
		this.member_no = member_no;
		this.marking_count = marking_count;
	}

	@Override
	public String toString() {
		return "Marking [marking_no=" + marking_no + ", marking_type=" + marking_type + ", marking_date=" + marking_date
				+ ", board_no=" + board_no + ", member_no=" + member_no + ", marking_count=" + marking_count + "]";
	}

	public int getMarking_no() {
		return marking_no;
	}

	public void setMarking_no(int marking_no) {
		this.marking_no = marking_no;
	}

	public int getMarking_type() {
		return marking_type;
	}

	public void setMarking_type(int marking_type) {
		this.marking_type = marking_type;
	}

	public Date getMarking_date() {
		return marking_date;
	}

	public void setMarking_date(Date marking_date) {
		this.marking_date = marking_date;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getMarking_count() {
		return marking_count;
	}

	public void setMarking_count(int marking_count) {
		this.marking_count = marking_count;
	}

	
}