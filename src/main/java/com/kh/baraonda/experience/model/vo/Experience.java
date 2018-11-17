package com.kh.baraonda.experience.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Experience implements Serializable{
	private int experience_no;
	private int company_no;
	private int board_no;
	private Date experience_date;
	private int experience_approval;
	private String approval_content;
	private Date approval_date;
	
	public Experience() {}

	public Experience(int experience_no, int company_no, int board_no, Date experience_date, int experience_approval,
			String approval_content, Date approval_date) {
		super();
		this.experience_no = experience_no;
		this.company_no = company_no;
		this.board_no = board_no;
		this.experience_date = experience_date;
		this.experience_approval = experience_approval;
		this.approval_content = approval_content;
		this.approval_date = approval_date;
	}

	public int getExperience_no() {
		return experience_no;
	}

	public int getCompany_no() {
		return company_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public Date getExperience_date() {
		return experience_date;
	}

	public int getExperience_approval() {
		return experience_approval;
	}

	public String getApproval_content() {
		return approval_content;
	}

	public Date getApproval_date() {
		return approval_date;
	}

	public void setExperience_no(int experience_no) {
		this.experience_no = experience_no;
	}

	public void setCompany_no(int company_no) {
		this.company_no = company_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public void setExperience_date(Date experience_date) {
		this.experience_date = experience_date;
	}

	public void setExperience_approval(int experience_approval) {
		this.experience_approval = experience_approval;
	}

	public void setApproval_content(String approval_content) {
		this.approval_content = approval_content;
	}

	public void setApproval_date(Date approval_date) {
		this.approval_date = approval_date;
	}

	@Override
	public String toString() {
		return "Experience [experience_no=" + experience_no + ", company_no=" + company_no + ", board_no=" + board_no
				+ ", experience_date=" + experience_date + ", experience_approval=" + experience_approval
				+ ", approval_content=" + approval_content + ", approval_date=" + approval_date + "]";
	}

	
	
	
}
