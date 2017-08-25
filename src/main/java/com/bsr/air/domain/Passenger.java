package com.bsr.air.domain;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Passenger {
	private int pid;
	private String fname;
	private String lname;
	private Date dob;
	private String email; 
	private int rid;
	
	
   	public Passenger() {}

   	

	public Passenger(String fname, String lname, Date dob, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.email = email;
	}



	public Passenger(String fname, String lname, Date dob, String email, int rid) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.email = email;
		this.rid = rid;
	}



	public Passenger(int pid, String fname, String lname, Date dob, String email, int rid) {
		super();
		this.pid = pid;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.email = email;
		this.rid = rid;
	}



	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
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


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getRid() {
		return rid;
	}


	public void setRid(int rid) {
		this.rid = rid;
	}
	
   	
	
}
