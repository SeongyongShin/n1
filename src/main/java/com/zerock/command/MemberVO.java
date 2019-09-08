package com.zerock.command;

import java.sql.Timestamp;

public class MemberVO {
	private String id;
	private String name;
	private String pw;
	private Timestamp regdate;
	
	public MemberVO() {}
	
	public MemberVO(String id, String name, String pw, Timestamp regdate) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.regdate = regdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
}
