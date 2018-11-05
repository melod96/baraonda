package com.kh.baraonda.tips.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class TipsComment implements Serializable{
	private int comments_no;
	private String comments_content;
	private int board_no;
	private int member_no;
	private Date comments_date;
	private int comments_status;
	private String nick_name;
	
	public TipsComment() {
		
	}

	public TipsComment(int comments_no, String comments_content, int board_no, int member_no, Date comments_date,
			int comments_status, String nick_name) {
		super();
		this.comments_no = comments_no;
		this.comments_content = comments_content;
		this.board_no = board_no;
		this.member_no = member_no;
		this.comments_date = comments_date;
		this.comments_status = comments_status;
		this.nick_name = nick_name;
	}

	public int getComments_no() {
		return comments_no;
	}

	public String getComments_content() {
		return comments_content;
	}

	public int getBoard_no() {
		return board_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public Date getComments_date() {
		return comments_date;
	}

	public int getComments_status() {
		return comments_status;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setComments_no(int comments_no) {
		this.comments_no = comments_no;
	}

	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public void setComments_date(Date comments_date) {
		this.comments_date = comments_date;
	}

	public void setComments_status(int comments_status) {
		this.comments_status = comments_status;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	@Override
	public String toString() {
		return "NoticeComment [comments_no=" + comments_no + ", comments_content=" + comments_content + ", board_no="
				+ board_no + ", member_no=" + member_no + ", comments_date=" + comments_date + ", comments_status="
				+ comments_status + ", nick_name=" + nick_name + "]";
	}

	
	
}
