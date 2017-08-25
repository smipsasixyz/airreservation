package com.bsr.air.domain;

import java.sql.Date;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionUser {
	private int transid;
	private int uid;
	private double transamount;
	private Date transdate;
	private String transmsg;
	public TransactionUser() {
		super();
	}
	public int getTransid() {
		return transid;
	}
	public void setTransid(int transid) {
		this.transid = transid;
	}
	
	public TransactionUser(int uid, double transamount, Date transdate, String transmsg) {
		super();
		this.uid = uid;
		this.transamount = transamount;
		this.transdate = transdate;
		this.transmsg = transmsg;
	}
	public TransactionUser(int transid, int uid, double transamount, Date transdate, String transmsg) {
		super();
		this.transid = transid;
		this.uid = uid;
		this.transamount = transamount;
		this.transdate = transdate;
		this.transmsg = transmsg;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public double getTransamount() {
		return transamount;
	}
	public void setTransamount(double transamount) {
		this.transamount = transamount;
	}
	public Date getTransdate() {
		return transdate;
	}
	public void setTransdate(Date transdate) {
		this.transdate = transdate;
	}
	public String getTransmsg() {
		return transmsg;
	}
	public void setTransmsg(String transmsg) {
		this.transmsg = transmsg;
	}
	
	
}
