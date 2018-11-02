package com.kh.baraonda.main.model.vo;

import java.sql.Date;

public class Ranking {
	
	private int member_no;
	private String nick_name;
	private int member_status;
	private int point_no; //point_no=member_no
	private int accrue_point; //누적경험치
	private String self_introduction;//자기소개
	
	private int files_no; //파일번호
	private int f_reference_no; //참조번호
	private String files_title;//파일 제목
	private String files_change_title;//변경 파일 제목
	private int files_type; //파일유형. 썸네일 4번
	private String files_root; //파일 경로
	private int files_secession; //파일 삭제여부
	private String profile_root;
	
	public Ranking(){}

	public Ranking(int member_no, String nick_name, int member_status, int point_no, int accrue_point,
			String self_introduction, int files_no, int f_reference_no, String files_title, String files_change_title,
			int files_type, String files_root, int files_secession, String profile_root) {
		super();
		this.member_no = member_no;
		this.nick_name = nick_name;
		this.member_status = member_status;
		this.point_no = point_no;
		this.accrue_point = accrue_point;
		this.self_introduction = self_introduction;
		this.files_no = files_no;
		this.f_reference_no = f_reference_no;
		this.files_title = files_title;
		this.files_change_title = files_change_title;
		this.files_type = files_type;
		this.files_root = files_root;
		this.files_secession = files_secession;
		this.profile_root = profile_root;
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

	public String getSelf_introduction() {
		return self_introduction;
	}

	public void setSelf_introduction(String self_introduction) {
		this.self_introduction = self_introduction;
	}

	public int getFiles_no() {
		return files_no;
	}

	public void setFiles_no(int files_no) {
		this.files_no = files_no;
	}

	public int getF_reference_no() {
		return f_reference_no;
	}

	public void setF_reference_no(int f_reference_no) {
		this.f_reference_no = f_reference_no;
	}

	public String getFiles_title() {
		return files_title;
	}

	public void setFiles_title(String files_title) {
		this.files_title = files_title;
	}

	public String getFiles_change_title() {
		return files_change_title;
	}

	public void setFiles_change_title(String files_change_title) {
		this.files_change_title = files_change_title;
	}

	public int getFiles_type() {
		return files_type;
	}

	public void setFiles_type(int files_type) {
		this.files_type = files_type;
	}

	public String getFiles_root() {
		return files_root;
	}

	public void setFiles_root(String files_root) {
		this.files_root = files_root;
	}

	public int getFiles_secession() {
		return files_secession;
	}

	public void setFiles_secession(int files_secession) {
		this.files_secession = files_secession;
	}

	public String getProfile_root() {
		return profile_root;
	}

	public void setProfile_root(String profile_root) {
		this.profile_root = profile_root;
	}

	@Override
	public String toString() {
		return "Ranking [member_no=" + member_no + ", nick_name=" + nick_name + ", member_status=" + member_status
				+ ", point_no=" + point_no + ", accrue_point=" + accrue_point + ", self_introduction="
				+ self_introduction + ", files_no=" + files_no + ", f_reference_no=" + f_reference_no + ", files_title="
				+ files_title + ", files_change_title=" + files_change_title + ", files_type=" + files_type
				+ ", files_root=" + files_root + ", files_secession=" + files_secession + ", profile_root="
				+ profile_root + "]";
	}

	
	
	
	
	

}
