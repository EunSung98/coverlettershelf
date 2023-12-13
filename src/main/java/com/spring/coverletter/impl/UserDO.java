package com.spring.coverletter.impl;

import java.sql.Timestamp;

public class UserDO {
	private String name;
	private String id;
	private String pw;
	private String checkpw;
	private int age;
	private Timestamp lastLogin;
	private Timestamp deleteDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getCheckpw() {
		return checkpw;
	}
	public void setCheckpw(String checkpw) {
		this.checkpw = checkpw;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Timestamp getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Timestamp deleteDate) {
		this.deleteDate = deleteDate;
	}
}
