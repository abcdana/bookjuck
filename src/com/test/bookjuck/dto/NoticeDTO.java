package com.test.bookjuck.dto;

import java.sql.Date;

public class NoticeDTO {
	
	private int seq;		//번호
	private String title;	//제목
	private String content; //내용
	private String regdate; //작성일
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
	
	
}
