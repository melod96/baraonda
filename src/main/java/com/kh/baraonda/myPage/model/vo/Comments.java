package com.kh.baraonda.myPage.model.vo;

import java.sql.Date;

public class Comments {
	private int comments_no;
	private String comments_content;
	private int board_no;
	private int member_no;
	private Date comments_date;
	private int comments_status;
	private String board_title;
	private int board_type;


	public Comments() {
		super();
	}


	public Comments(int comments_no, String comments_content, int board_no, int member_no, Date comments_date,
			int comments_status, String board_title, int board_type) {
		super();
		this.comments_no = comments_no;
		this.comments_content = comments_content;
		this.board_no = board_no;
		this.member_no = member_no;
		this.comments_date = comments_date;
		this.comments_status = comments_status;
		this.board_title = board_title;
		this.board_type = board_type;
	}


	@Override
	public String toString() {
		return "Comments [comments_no=" + comments_no + ", comments_content=" + comments_content + ", board_no="
				+ board_no + ", member_no=" + member_no + ", comments_date=" + comments_date + ", comments_status="
				+ comments_status + ", board_title=" + board_title + ", board_type=" + board_type + "]";
	}


	public int getComments_no() {
		return comments_no;
	}


	public void setComments_no(int comments_no) {
		this.comments_no = comments_no;
	}


	public String getComments_content() {
		return comments_content;
	}


	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
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


	public Date getComments_date() {
		return comments_date;
	}


	public void setComments_date(Date comments_date) {
		this.comments_date = comments_date;
	}


	public int getComments_status() {
		return comments_status;
	}


	public void setComments_status(int comments_status) {
		this.comments_status = comments_status;
	}


	public String getBoard_title() {
		return board_title;
	}


	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}


	public int getBoard_type() {
		return board_type;
	}


	public void setBoard_type(int board_type) {
		this.board_type = board_type;
	}
	
	

}