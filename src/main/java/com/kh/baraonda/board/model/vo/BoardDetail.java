package com.kh.baraonda.board.model.vo;

import java.sql.Date;

public class BoardDetail {
	private String BOARD_TITLE;
	private String BOARD_CONTENT;
	private Date BOARD_DATE;
	private int BOARD_COUNT;
	private String NICK_NAME;
	private int COMMENTS_COUNT;
	private int BOARD_NO;
	private int WRITING_TYPE;
	private int MEMBER_NO;
	private int COMMENTS_NO;
	
	public BoardDetail() {}

	public BoardDetail(String bOARD_TITLE, String bOARD_CONTENT, Date bOARD_DATE, int bOARD_COUNT, String nICK_NAME,
			int cOMMENTS_COUNT, int bOARD_NO, int wRITING_TYPE, int mEMBER_NO, int cOMMENTS_NO) {
		super();
		BOARD_TITLE = bOARD_TITLE;
		BOARD_CONTENT = bOARD_CONTENT;
		BOARD_DATE = bOARD_DATE;
		BOARD_COUNT = bOARD_COUNT;
		NICK_NAME = nICK_NAME;
		COMMENTS_COUNT = cOMMENTS_COUNT;
		BOARD_NO = bOARD_NO;
		WRITING_TYPE = wRITING_TYPE;
		MEMBER_NO = mEMBER_NO;
		COMMENTS_NO = cOMMENTS_NO;
	}

	public String getBOARD_TITLE() {
		return BOARD_TITLE;
	}

	public String getBOARD_CONTENT() {
		return BOARD_CONTENT;
	}

	public Date getBOARD_DATE() {
		return BOARD_DATE;
	}

	public int getBOARD_COUNT() {
		return BOARD_COUNT;
	}

	public String getNICK_NAME() {
		return NICK_NAME;
	}

	public int getCOMMENTS_COUNT() {
		return COMMENTS_COUNT;
	}

	public int getBOARD_NO() {
		return BOARD_NO;
	}

	public int getWRITING_TYPE() {
		return WRITING_TYPE;
	}

	public int getMEMBER_NO() {
		return MEMBER_NO;
	}

	public int getCOMMENTS_NO() {
		return COMMENTS_NO;
	}

	public void setBOARD_TITLE(String bOARD_TITLE) {
		BOARD_TITLE = bOARD_TITLE;
	}

	public void setBOARD_CONTENT(String bOARD_CONTENT) {
		BOARD_CONTENT = bOARD_CONTENT;
	}

	public void setBOARD_DATE(Date bOARD_DATE) {
		BOARD_DATE = bOARD_DATE;
	}

	public void setBOARD_COUNT(int bOARD_COUNT) {
		BOARD_COUNT = bOARD_COUNT;
	}

	public void setNICK_NAME(String nICK_NAME) {
		NICK_NAME = nICK_NAME;
	}

	public void setCOMMENTS_COUNT(int cOMMENTS_COUNT) {
		COMMENTS_COUNT = cOMMENTS_COUNT;
	}

	public void setBOARD_NO(int bOARD_NO) {
		BOARD_NO = bOARD_NO;
	}

	public void setWRITING_TYPE(int wRITING_TYPE) {
		WRITING_TYPE = wRITING_TYPE;
	}

	public void setMEMBER_NO(int mEMBER_NO) {
		MEMBER_NO = mEMBER_NO;
	}

	public void setCOMMENTS_NO(int cOMMENTS_NO) {
		COMMENTS_NO = cOMMENTS_NO;
	}

	@Override
	public String toString() {
		return "BoardDetail [BOARD_TITLE=" + BOARD_TITLE + ", BOARD_CONTENT=" + BOARD_CONTENT + ", BOARD_DATE="
				+ BOARD_DATE + ", BOARD_COUNT=" + BOARD_COUNT + ", NICK_NAME=" + NICK_NAME + ", COMMENTS_COUNT="
				+ COMMENTS_COUNT + ", BOARD_NO=" + BOARD_NO + ", WRITING_TYPE=" + WRITING_TYPE + ", MEMBER_NO="
				+ MEMBER_NO + ", COMMENTS_NO=" + COMMENTS_NO + "]";
	}

	
}
