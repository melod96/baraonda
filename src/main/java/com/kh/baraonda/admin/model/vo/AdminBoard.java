package com.kh.baraonda.admin.model.vo;

public class AdminBoard implements java.io.Serializable{

	private String board_no;
	private String title;
	private String content;
	
	public AdminBoard() {
		
	}
	
	public AdminBoard(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public AdminBoard(String board_no, String title, String content) {
		super();
		this.board_no = board_no;
		this.title = title;
		this.content = content;
	}

	public String getBoard_no() {
		return board_no;
	}

	public void setBoard_no(String board_no) {
		this.board_no = board_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "AdminBoard [board_no=" + board_no + ", title=" + title + ", content=" + content + "]";
	}

	
}
