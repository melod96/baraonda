package com.kh.baraonda.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
	
	private int member_no;
	private String id;
	private String password;
	private String name;
	private int status;
	private int admin_right;
	private String token;
	private String phone;
	private String email;
	private String nick_name;
	private Date enroll_date;
	private Date modify_date;
	private String introduction;
	private int enterprise_right;
	private int enterprise_number;
	private String bank;
	private String account;
	private String representative;
	private int business_type;
	
	public Member() {}





	@Override
	public String toString() {
		return "Member [member_no=" + member_no + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", status=" + status + ", admin_right=" + admin_right + ", token=" + token + ", phone=" + phone
				+ ", email=" + email + ", nick_name=" + nick_name + ", enroll_date=" + enroll_date + ", modify_date="
				+ modify_date + ", introduction=" + introduction + ", enterprise_right=" + enterprise_right
				+ ", enterprise_number=" + enterprise_number + ", bank=" + bank + ", account=" + account
				+ ", representative=" + representative + ", business_type=" + business_type + "]";
	}



	public Member(int member_no, String id, String password, String name, int status, int admin_right, String token,
			String phone, String email, String nick_name, Date enroll_date, Date modify_date, String introduction,
			int enterprise_right, int enterprise_number, String bank, String account, String representative,
			int business_type) {
		super();
		this.member_no = member_no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.status = status;
		this.admin_right = admin_right;
		this.token = token;
		this.phone = phone;
		this.email = email;
		this.nick_name = nick_name;
		this.enroll_date = enroll_date;
		this.modify_date = modify_date;
		this.introduction = introduction;
		this.enterprise_right = enterprise_right;
		this.enterprise_number = enterprise_number;
		this.bank = bank;
		this.account = account;
		this.representative = representative;
		this.business_type = business_type;
	}



	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public int getAdmin_right() {
		return admin_right;
	}

	public void setAdmin_right(int admin_right) {
		this.admin_right = admin_right;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getEnterprise_right() {
		return enterprise_right;
	}

	public void setEnterprise_right(int enterprise_right) {
		this.enterprise_right = enterprise_right;
	}

	public int getEnterprise_number() {
		return enterprise_number;
	}

	public void setEnterprise_number(int enterprise_number) {
		this.enterprise_number = enterprise_number;
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

	public String getRepresentative() {
		return representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	public int getBusiness_type() {
		return business_type;
	}

	public void setBusiness_type(int business_type) {
		this.business_type = business_type;
	}
	
	
}
