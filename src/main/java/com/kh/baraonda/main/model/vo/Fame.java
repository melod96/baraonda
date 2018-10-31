package com.kh.baraonda.main.model.vo;

public class Fame {
	
	private int board_no;
	private String board_title;
	private int member_no;
	private int marking_type;
	
	public Fame() {}

	public Fame(int board_no, String board_title, int member_no, int marking_type) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.member_no = member_no;
		this.marking_type = marking_type;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getMarking_type() {
		return marking_type;
	}

	public void setMarking_type(int marking_type) {
		this.marking_type = marking_type;
	}

	@Override
	public String toString() {
		return "Fame [board_no=" + board_no + ", board_title=" + board_title + ", member_no=" + member_no
				+ ", marking_type=" + marking_type + "]";
	}
	
	

}
