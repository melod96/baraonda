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
		private int board_good;
	
		private String nick_name;
		private int marking_type;
		
		//파일 관련 추가해야함
		private int files_no; //파일번호
		private int f_reference_no; //참조번호
		private String files_title;//파일 제목
		private String files_change_title;//변경 파일 제목
		private int files_type; //파일유형. 썸네일 4번
		private String files_root; //파일 경로
		private int files_secession; //파일 삭제여부
		private String profile_root;
		
		public Tips() {}

		public Tips(int board_no, int board_type, int writing_type, String board_title, String board_content,
				int member_no, Date board_date, Date modify_date, int board_status, int board_count, int board_good,
				String nick_name, int marking_type, int files_no, int f_reference_no, String files_title,
				String files_change_title, int files_type, String files_root, int files_secession,
				String profile_root) {
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
			this.board_good = board_good;
			this.nick_name = nick_name;
			this.marking_type = marking_type;
			this.files_no = files_no;
			this.f_reference_no = f_reference_no;
			this.files_title = files_title;
			this.files_change_title = files_change_title;
			this.files_type = files_type;
			this.files_root = files_root;
			this.files_secession = files_secession;
			this.profile_root = profile_root;
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

		public int getBoard_good() {
			return board_good;
		}

		public void setBoard_good(int board_good) {
			this.board_good = board_good;
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
			return "Tips [board_no=" + board_no + ", board_type=" + board_type + ", writing_type=" + writing_type
					+ ", board_title=" + board_title + ", board_content=" + board_content + ", member_no=" + member_no
					+ ", board_date=" + board_date + ", modify_date=" + modify_date + ", board_status=" + board_status
					+ ", board_count=" + board_count + ", board_good=" + board_good + ", nick_name=" + nick_name
					+ ", marking_type=" + marking_type + ", files_no=" + files_no + ", f_reference_no=" + f_reference_no
					+ ", files_title=" + files_title + ", files_change_title=" + files_change_title + ", files_type="
					+ files_type + ", files_root=" + files_root + ", files_secession=" + files_secession
					+ ", profile_root=" + profile_root + "]";
		}

		

		
		
}