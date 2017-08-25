package com.bsr.air.domain;

public class User {

	private int uid;
	private String fname;
	private String lname;
	private String username;
	private String email;
	
	
	public User() {
		super();
	}

	public User(int uid, String fname, String lname, String username, String email) {
		super();
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.email = email;
	}

	public User(String fname, String lname, String username, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.email = email;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

	
}
