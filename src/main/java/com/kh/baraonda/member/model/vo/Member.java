package com.kh.baraonda.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
	
	private int member_no;
	private String id;
	private String password;
	private String name;
	private String nick_name;
	private String phone;
	private String token;
	private Date enroll_date;
	private Date modify_date;
	private int member_status;
	private int admin_right;
	private int company_right;
	private String company_name;
	private String company_no;
	private String bank;
	private String account;
	private String ceo_name;
	private String ceo_type;
	private String self_introduction;
	private String email;
	public Member() {}
	public Member(int member_no, String id, String password, String name, String nick_name, String phone, String token,
			Date enroll_date, Date modify_date, int member_status, int admin_right, int company_right,
			String company_name, String company_no, String bank, String account, String ceo_name, String ceo_type,
			String self_introduction, String email) {
		super();
		this.member_no = member_no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.nick_name = nick_name;
		this.phone = phone;
		this.token = token;
		this.enroll_date = enroll_date;
		this.modify_date = modify_date;
		this.member_status = member_status;
		this.admin_right = admin_right;
		this.company_right = company_right;
		this.company_name = company_name;
		this.company_no = company_no;
		this.bank = bank;
		this.account = account;
		this.ceo_name = ceo_name;
		this.ceo_type = ceo_type;
		this.self_introduction = self_introduction;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Member [member_no=" + member_no + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", nick_name=" + nick_name + ", phone=" + phone + ", token=" + token + ", enroll_date=" + enroll_date
				+ ", modify_date=" + modify_date + ", member_status=" + member_status + ", admin_right=" + admin_right
				+ ", company_right=" + company_right + ", company_name=" + company_name + ", company_no=" + company_no
				+ ", bank=" + bank + ", account=" + account + ", ceo_name=" + ceo_name + ", ceo_type=" + ceo_type
				+ ", self_introduction=" + self_introduction + ", email=" + email + "]";
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	public int getMember_status() {
		return member_status;
	}
	public void setMember_status(int member_status) {
		this.member_status = member_status;
	}
	public int getAdmin_right() {
		return admin_right;
	}
	public void setAdmin_right(int admin_right) {
		this.admin_right = admin_right;
	}
	public int getCompany_right() {
		return company_right;
	}
	public void setCompany_right(int company_right) {
		this.company_right = company_right;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_no() {
		return company_no;
	}
	public void setCompany_no(String company_no) {
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
	public String getSelf_introduction() {
		return self_introduction;
	}
	public void setSelf_introduction(String self_introduction) {
		this.self_introduction = self_introduction;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}






	
}
