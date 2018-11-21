package com.kh.baraonda.admin.model.vo;

public class Member implements java.io.Serializable{
 
	private int member_no;
	private String nick_name;
	private String files_root;
	private String files_change_title;
	
	public Member() {
		
	}

	public Member(int member_no, String nick_name, String files_root, String files_change_title) {
		super();
		this.member_no = member_no;
		this.nick_name = nick_name;
		this.files_root = files_root;
		this.files_change_title = files_change_title;
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

	public String getFiles_root() {
		return files_root;
	}

	public void setFiles_root(String files_root) {
		this.files_root = files_root;
	}

	public String getFiles_change_title() {
		return files_change_title;
	}

	public void setFiles_change_title(String files_change_title) {
		this.files_change_title = files_change_title;
	}

	@Override
	public String toString() {
		return "Member [member_no=" + member_no + ", nick_name=" + nick_name + ", files_root=" + files_root
				+ ", files_change_title=" + files_change_title + "]";
	}
	
	
	
}
