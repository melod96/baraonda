package com.kh.baraonda.admin.model.vo;

import java.sql.Date;

public class AdminNotice implements java.io.Serializable{
	
	private int board_no;
	private String board_title;
	private String nick_name;
	private int board_count;
	private Date board_date;
	
	public AdminNotice() {
		
	}

	public AdminNotice(int board_no, String board_title, String nick_name, int board_count, Date board_date) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.nick_name = nick_name;
		this.board_count = board_count;
		this.board_date = board_date;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public int getBoard_count() {
		return board_count;
	}

	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	@Override
	public String toString() {
		return "AdminNotice [board_no=" + board_no + ", board_title=" + board_title + ", nick_name=" + nick_name
				+ ", board_count=" + board_count + ", board_date=" + board_date + "]";
	}

	
	
}
