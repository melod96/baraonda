package com.kh.baraonda.admin.model.vo;

import java.sql.Date;

public class adminCompanyMember {
	
	private int member_no;
	private String id;
	private String name;
	private String nick_name;
	private String phone;
	private String email;
	private String company_name;
	private int company_no;
	private String bank;
	private String account;
	private String ceo_name;
	private String ceo_type;
	private Date enroll_date;
	private int member_status;
	
	public adminCompanyMember() {
		
	}

	public adminCompanyMember(int member_no, String id, String name, String nick_name, String phone, String email,
			String company_name, int company_no, String bank, String account, String ceo_name, String ceo_type,
			Date enroll_date, int member_status) {
		super();
		this.member_no = member_no;
		this.id = id;
		this.name = name;
		this.nick_name = nick_name;
		this.phone = phone;
		this.email = email;
		this.company_name = company_name;
		this.company_no = company_no;
		this.bank = bank;
		this.account = account;
		this.ceo_name = ceo_name;
		this.ceo_type = ceo_type;
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

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getCompany_no() {
		return company_no;
	}

	public void setCompany_no(int company_no) {
		this.company_no = company_no;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCeo_name() {
		return ceo_name;
	}

	public void setCeo_name(String ceo_name) {
		this.ceo_name = ceo_name;
	}

	public String getCeo_type() {
		return ceo_type;
	}

	public void setCeo_type(String ceo_type) {
		this.ceo_type = ceo_type;
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
		return "adminCompanyMember [member_no=" + member_no + ", id=" + id + ", name=" + name + ", nick_name="
				+ nick_name + ", phone=" + phone + ", email=" + email + ", company_name=" + company_name
				+ ", company_no=" + company_no + ", bank=" + bank + ", account=" + account + ", ceo_name=" + ceo_name
				+ ", ceo_type=" + ceo_type + ", enroll_date=" + enroll_date + ", member_status=" + member_status + "]";
	}
	
	
	
}
