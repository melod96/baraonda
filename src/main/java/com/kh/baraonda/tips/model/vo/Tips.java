package com.kh.baraonda.tips.model.vo;

import java.sql.Date;

public class Tips {
	
		private int board_no;
		private int board_type;
		private int writing_type;
		private String board_title;
		private String board_content;
		private int member_no;
		private Date board_date;
		private Date modify_date;
		private int board_status;
		private int board_count;
		
		private String nick_name;
		private int marking_type;
		
		//파일 관련 추가해야함
		
		public Tips() {}

		public Tips(int board_no, int board_type, int writing_type, String board_title, String board_content,
				int member_no, Date board_date, Date modify_date, int board_status, int board_count, String nick_name,
				int marking_type) {
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
			this.nick_name = nick_name;
			this.marking_type = marking_type;
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

		public String getNick_name() {
			return nick_name;
		}

		public void setNick_name(String nick_name) {
			this.nick_name = nick_name;
		}

		public int getMarking_type() {
			return marking_type;
		}

		public void setMarking_type(int marking_type) {
			this.marking_type = marking_type;
		}

		@Override
		public String toString() {
			return "Tips [board_no=" + board_no + ", board_type=" + board_type + ", writing_type=" + writing_type
					+ ", board_title=" + board_title + ", board_content=" + board_content + ", member_no=" + member_no
					+ ", board_date=" + board_date + ", modify_date=" + modify_date + ", board_status=" + board_status
					+ ", board_count=" + board_count + ", nick_name=" + nick_name + ", marking_type=" + marking_type
					+ "]";
		}
		
		


}