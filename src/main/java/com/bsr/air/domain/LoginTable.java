package com.bsr.air.domain;

public class LoginTable {
	public int LTID;
	String email;
	String password;

	public LoginTable() {
	}

	public LoginTable(int id) {
		this.LTID = id;
	}

	public LoginTable(int lTID, String email, String password) {
		super();
		LTID = lTID;
		this.email = email;
		this.password = password;
	}

	public LoginTable(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public int getLTID() {
		return LTID;
	}

	public void setLTID(int lTID) {
		LTID = lTID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
