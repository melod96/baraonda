package com.kh.baraonda.myPage.model.vo;

import java.sql.Date;

public class Message {

	private int message_no;
	private String message_title;
	private String message_content;
	private Date message_date;
	private int dispatch_member_no;
	private String dispatch_nickname;
	private int receive_member_no;
	private String receive_nickname;
	private Date check_date;
	
	public Message() {}

	public Message(int message_no, String message_title, String message_content, Date message_date,
			int dispatch_member_no, String dispatch_nickname, int receive_member_no, String receive_nickname,
			Date check_date) {
		super();
		this.message_no = message_no;
		this.message_title = message_title;
		this.message_content = message_content;
		this.message_date = message_date;
		this.dispatch_member_no = dispatch_member_no;
		this.dispatch_nickname = dispatch_nickname;
		this.receive_member_no = receive_member_no;
		this.receive_nickname = receive_nickname;
		this.check_date = check_date;
	}

	@Override
	public String toString() {
		return "Message [message_no=" + message_no + ", message_title=" + message_title + ", message_content="
				+ message_content + ", message_date=" + message_date + ", dispatch_member_no=" + dispatch_member_no
				+ ", dispatch_nickname=" + dispatch_nickname + ", receive_member_no=" + receive_member_no
				+ ", receive_nickname=" + receive_nickname + ", check_date=" + check_date + "]";
	}

	public int getMessage_no() {
		return message_no;
	}

	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}

	public String getMessage_title() {
		return message_title;
	}

	public void setMessage_title(String message_title) {
		this.message_title = message_title;
	}

	public String getMessage_content() {
		return message_content;
	}

	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}

	public Date getMessage_date() {
		return message_date;
	}

	public void setMessage_date(Date message_date) {
		this.message_date = message_date;
	}

	public int getDispatch_member_no() {
		return dispatch_member_no;
	}

	public void setDispatch_member_no(int dispatch_member_no) {
		this.dispatch_member_no = dispatch_member_no;
	}

	public String getDispatch_nickname() {
		return dispatch_nickname;
	}

	public void setDispatch_nickname(String dispatch_nickname) {
		this.dispatch_nickname = dispatch_nickname;
	}

	public int getReceive_member_no() {
		return receive_member_no;
	}

	public void setReceive_member_no(int receive_member_no) {
		this.receive_member_no = receive_member_no;
	}

	public String getReceive_nickname() {
		return receive_nickname;
	}

	public void setReceive_nickname(String receive_nickname) {
		this.receive_nickname = receive_nickname;
	}

	public Date getCheck_date() {
		return check_date;
	}

	public void setCheck_date(Date check_date) {
		this.check_date = check_date;
	}

	

}
