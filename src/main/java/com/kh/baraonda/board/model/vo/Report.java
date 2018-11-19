package com.kh.baraonda.board.model.vo;

import java.sql.Date;

public class Report {
	private int report_no;
	private String report_comment;
	private int board_no;
	private Date report_date;
	private int report_give_no;
	private int report_get_no;
	private int report_type;
	private int report_approval;
	
	public Report() {}

	public Report(int report_no, String report_comment, int board_no, Date report_date, int report_give_no,
			int report_get_no, int report_type, int report_approval) {
		super();
		this.report_no = report_no;
		this.report_comment = report_comment;
		this.board_no = board_no;
		this.report_date = report_date;
		this.report_give_no = report_give_no;
		this.report_get_no = report_get_no;
		this.report_type = report_type;
		this.report_approval = report_approval;
	}

	public int getReport_no() {
		return report_no;
	}

	public String getReport_comment() {
		return report_comment;
	}

	public int getBoard_no() {
		return board_no;
	}

	public Date getReport_date() {
		return report_date;
	}

	public int getReport_give_no() {
		return report_give_no;
	}

	public int getReport_get_no() {
		return report_get_no;
	}

	public int getReport_type() {
		return report_type;
	}

	public int getReport_approval() {
		return report_approval;
	}

	public void setReport_no(int report_no) {
		this.report_no = report_no;
	}

	public void setReport_comment(String report_comment) {
		this.report_comment = report_comment;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public void setReport_give_no(int report_give_no) {
		this.report_give_no = report_give_no;
	}

	public void setReport_get_no(int report_get_no) {
		this.report_get_no = report_get_no;
	}

	public void setReport_type(int report_type) {
		this.report_type = report_type;
	}

	public void setReport_approval(int report_approval) {
		this.report_approval = report_approval;
	}

	@Override
	public String toString() {
		return "Report [report_no=" + report_no + ", report_comment=" + report_comment + ", board_no=" + board_no
				+ ", report_give_no=" + report_give_no + ", report_get_no=" + report_get_no + ", report_type="
				+ report_type + ", report_approval=" + report_approval + "]";
	}
	
	
}
