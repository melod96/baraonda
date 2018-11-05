package com.kh.baraonda.admin.model.vo;

import java.sql.Date;

public class AdminGeneralMember implements java.io.Serializable{

	private int member_no;
	private String id;
	private String name;
	private String nick_name;
	private String phone;
	private String email;
	private Date enroll_date;
	private int member_status;
	
	public AdminGeneralMember() {
		
	}

	public AdminGeneralMember(int member_no, String id, String name, String nick_name, String phone, String email,
			Date enroll_date, int member_status) {
		super();
		this.member_no = member_no;
		this.id = id;
		this.name = name;
		this.nick_name = nick_name;
		this.phone = phone;
		this.email = email;
		this.enroll_date = enroll_date;
		this.member_status = member_status;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}

	public int getMember_status() {
		return member_status;
	}

	public void setMember_status(int member_status) {
		this.member_status = member_status;
	}

	@Override
	public String toString() {
		return "adminGeneralMember [member_no=" + member_no + ", id=" + id + ", name=" + name + ", nick_name="
				+ nick_name + ", phone=" + phone + ", email=" + email + ", enroll_date=" + enroll_date
				+ ", member_status=" + member_status + "]";
	}
	
	
	
}
