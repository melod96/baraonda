package com.kh.baraonda.admin.model.vo;

import java.sql.Date;

public class AdminBlackMember implements java.io.Serializable{

	private int member_no;
	private String id;
	private String name;
	private String nick_name;
	private String phone;
	private String email;
	private Date enroll_date;
	private Date black_date;
	private Date lift_date;
	private int declarationCount;
	
	public AdminBlackMember() {
		
	}

	public AdminBlackMember(int member_no, String id, String name, String nick_name, String phone, String email,
			Date enroll_date, Date black_date, Date lift_date, int declarationCount) {
		super();
		this.member_no = member_no;
		this.id = id;
		this.name = name;
		this.nick_name = nick_name;
		this.phone = phone;
		this.email = email;
		this.enroll_date = enroll_date;
		this.black_date = black_date;
		this.lift_date = lift_date;
		this.declarationCount = declarationCount;
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

	public Date getBlack_date() {
		return black_date;
	}

	public void setBlack_date(Date black_date) {
		this.black_date = black_date;
	}

	public Date getLift_date() {
		return lift_date;
	}

	public void setLift_date(Date lift_date) {
		this.lift_date = lift_date;
	}

	public int getDeclarationCount() {
		return declarationCount;
	}

	public void setDeclarationCount(int declarationCount) {
		this.declarationCount = declarationCount;
	}

	@Override
	public String toString() {
		return "AdminBlackMember [member_no=" + member_no + ", id=" + id + ", name=" + name + ", nick_name=" + nick_name
				+ ", phone=" + phone + ", email=" + email + ", enroll_date=" + enroll_date + ", black_date="
				+ black_date + ", lift_date=" + lift_date + ", declarationCount=" + declarationCount + "]";
	}
	
	
	
}
