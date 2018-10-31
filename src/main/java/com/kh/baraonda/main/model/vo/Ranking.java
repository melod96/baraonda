package com.kh.baraonda.main.model.vo;

import java.sql.Date;

public class Ranking {
	
	private int member_no;
	private String nick_name;
	private int member_status;
	private int point_no; //point_no=member_no
	private int accrue_point; //누적경험치
	
	public Ranking(){}

	public Ranking(int member_no, String nick_name, int member_status, int point_no, int accrue_point) {
		super();
		this.member_no = member_no;
		this.nick_name = nick_name;
		this.member_status = member_status;
		this.point_no = point_no;
		this.accrue_point = accrue_point;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public int getMember_status() {
		return member_status;
	}

	public void setMember_status(int member_status) {
		this.member_status = member_status;
	}

	public int getPoint_no() {
		return point_no;
	}

	public void setPoint_no(int point_no) {
		this.point_no = point_no;
	}

	public int getAccrue_point() {
		return accrue_point;
	}

	public void setAccrue_point(int accrue_point) {
		this.accrue_point = accrue_point;
	}

	@Override
	public String toString() {
		return "Ranking [member_no=" + member_no + ", nick_name=" + nick_name + ", member_status=" + member_status
				+ ", point_no=" + point_no + ", accrue_point=" + accrue_point + "]";
	}
	
	
	

}
