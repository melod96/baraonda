package com.kh.baraonda.notice.model.vo;

import java.sql.Date;

public class Notice {

	private int board_no; //게시글번호
	private int board_type; //게시판유형 공지사항은 6번
	private int writing_type; //게시글유형 공지사항은 없음.
	private String board_title; //제목
	private String board_content; //내용
	private int member_no; //작성자
	private Date board_date; //등록일
	private Date modify_date; //수정일
	private int board_status; //게시글상태 0번 미삭제 1번 삭제
	private int board_count; //조회수
	
	public Notice(){}

	public Notice(int board_no, int board_type, int writing_type, String board_title, String board_content,
			int member_no, Date board_date, Date modify_date, int board_status, int board_count) {
		super();
		this.board_no = board_no;
		this.board_type = board_type;
		this.writing_type = writing_type;
		this.board_title = board_title;
		this.board_content = board_content;
		this.member_no = member_no;
		this.board_date = board_date;
		this.modify_date = modify_date;
		this.board_status = board_status;
		this.board_count = board_count;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getBoard_type() {
		return board_type;
	}

	public void setBoard_type(int board_type) {
		this.board_type = board_type;
	}

	public int getWriting_type() {
		return writing_type;
	}

	public void setWriting_type(int writing_type) {
		this.writing_type = writing_type;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

	public int getBoard_status() {
		return board_status;
	}

	public void setBoard_status(int board_status) {
		this.board_status = board_status;
	}

	public int getBoard_count() {
		return board_count;
	}

	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}

	@Override
	public String toString() {
		return "Notice [board_no=" + board_no + ", board_type=" + board_type + ", writing_type=" + writing_type
				+ ", board_title=" + board_title + ", board_content=" + board_content + ", member_no=" + member_no
				+ ", board_date=" + board_date + ", modify_date=" + modify_date + ", board_status=" + board_status
				+ ", board_count=" + board_count + "]";
	}
	
	

}
