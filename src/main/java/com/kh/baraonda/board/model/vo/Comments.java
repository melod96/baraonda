package com.kh.baraonda.board.model.vo;

import java.sql.Date;

public class Comments {
	private String COMMENTS_CONTENT;
	private Date COMMENTS_DATE;
	private String NICK_NAME;




	public Comments() {
		super();
	}




	public Comments(String cOMMENTS_CONTENT, Date cOMMENTS_DATE, String nICK_NAME) {
		super();
		COMMENTS_CONTENT = cOMMENTS_CONTENT;
		COMMENTS_DATE = cOMMENTS_DATE;
		NICK_NAME = nICK_NAME;
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




	public void setCOMMENTS_CONTENT(String cOMMENTS_CONTENT) {
		COMMENTS_CONTENT = cOMMENTS_CONTENT;
	}




	public void setCOMMENTS_DATE(Date cOMMENTS_DATE) {
		COMMENTS_DATE = cOMMENTS_DATE;
	}




	public void setNICK_NAME(String nICK_NAME) {
		NICK_NAME = nICK_NAME;
	}




	@Override
	public String toString() {
		return "Comments [COMMENTS_CONTENT=" + COMMENTS_CONTENT + ", COMMENTS_DATE=" + COMMENTS_DATE + ", NICK_NAME="
				+ NICK_NAME + "]";
	}





}
