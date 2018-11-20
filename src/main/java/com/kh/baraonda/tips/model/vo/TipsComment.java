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
	private String profile;
	private String files_change_title;
	
	public TipsComment() {
		
	}

	public TipsComment(int comments_no, String comments_content, int board_no, int member_no, Date comments_date,
			int comments_status, String nick_name, String profile, String files_change_title) {
		super();
		this.comments_no = comments_no;
		this.comments_content = comments_content;
		this.board_no = board_no;
		this.member_no = member_no;
		this.comments_date = comments_date;
		this.comments_status = comments_status;
		this.nick_name = nick_name;
		this.profile = profile;
		this.files_change_title = files_change_title;
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

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getFiles_change_title() {
		return files_change_title;
	}

	public void setFiles_change_title(String files_change_title) {
		this.files_change_title = files_change_title;
	}

	@Override
	public String toString() {
		return "TipsComment [comments_no=" + comments_no + ", comments_content=" + comments_content + ", board_no="
				+ board_no + ", member_no=" + member_no + ", comments_date=" + comments_date + ", comments_status="
				+ comments_status + ", nick_name=" + nick_name + ", profile=" + profile + ", files_change_title="
				+ files_change_title + "]";
	}

	
	
	
}
