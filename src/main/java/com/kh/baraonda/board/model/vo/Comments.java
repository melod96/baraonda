package com.kh.baraonda.board.model.vo;

import java.sql.Date;

public class Comments {
	private String COMMENTS_CONTENT;
	private Date COMMENTS_DATE;
	private String NICK_NAME;
	private int COMMENTS_NO;
	private int BOARD_NO;
	private int MEMBER_NO;
	private int COMMENTS_STATUS;
	


	public Comments() {
		super();
	}



	public Comments(String cOMMENTS_CONTENT, Date cOMMENTS_DATE, String nICK_NAME, int cOMMENTS_NO, int bOARD_NO,
			int mEMBER_NO, int cOMMENTS_STATUS) {
		super();
		COMMENTS_CONTENT = cOMMENTS_CONTENT;
		COMMENTS_DATE = cOMMENTS_DATE;
		NICK_NAME = nICK_NAME;
		COMMENTS_NO = cOMMENTS_NO;
		BOARD_NO = bOARD_NO;
		MEMBER_NO = mEMBER_NO;
		COMMENTS_STATUS = cOMMENTS_STATUS;
	}



	public String getCOMMENTS_CONTENT() {
		return COMMENTS_CONTENT;
	}



	public Date getCOMMENTS_DATE() {
		return COMMENTS_DATE;
	}



	public String getNICK_NAME() {
		return NICK_NAME;
	}



	public int getCOMMENTS_NO() {
		return COMMENTS_NO;
	}



	public int getBOARD_NO() {
		return BOARD_NO;
	}



	public int getMEMBER_NO() {
		return MEMBER_NO;
	}



	public int getCOMMENTS_STATUS() {
		return COMMENTS_STATUS;
	}



	public void setCOMMENTS_CONTENT(String cOMMENTS_CONTENT) {
		COMMENTS_CONTENT = cOMMENTS_CONTENT;
	}



	public void setCOMMENTS_DATE(Date cOMMENTS_DATE) {
		COMMENTS_DATE = cOMMENTS_DATE;
	}



	public void setNICK_NAME(String nICK_NAME) {
		NICK_NAME = nICK_NAME;
	}



	public void setCOMMENTS_NO(int cOMMENTS_NO) {
		COMMENTS_NO = cOMMENTS_NO;
	}



	public void setBOARD_NO(int bOARD_NO) {
		BOARD_NO = bOARD_NO;
	}



	public void setMEMBER_NO(int mEMBER_NO) {
		MEMBER_NO = mEMBER_NO;
	}



	public void setCOMMENTS_STATUS(int cOMMENTS_STATUS) {
		COMMENTS_STATUS = cOMMENTS_STATUS;
	}



	@Override
	public String toString() {
		return "Comments [COMMENTS_CONTENT=" + COMMENTS_CONTENT + ", COMMENTS_DATE=" + COMMENTS_DATE + ", NICK_NAME="
				+ NICK_NAME + ", COMMENTS_NO=" + COMMENTS_NO + ", BOARD_NO=" + BOARD_NO + ", MEMBER_NO=" + MEMBER_NO
				+ ", COMMENTS_STATUS=" + COMMENTS_STATUS + "]";
	}





}
