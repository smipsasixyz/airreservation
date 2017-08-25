package com.bsr.air.domain;

import java.sql.Date;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Reservation {
	private int rid;
	private String confnbr;
	private int not;
	private int fid;
	private int uid;
	private int transid;
	
	public Reservation() {
		super();
	}
	public Reservation(int rid, String confnbr, int not, int fid, int uid, int transid) {
		super();
		this.rid = rid;
		this.confnbr = confnbr;
		this.not = not;
		this.fid = fid;
		this.uid = uid;
		this.transid = transid;
	}
	public Reservation(String confnbr, int not, int fid, int uid, int transid) {
		this.confnbr = confnbr;
		this.not = not;
		this.fid = fid;
		this.uid = uid;
		this.transid = transid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getConfnbr() {
		return confnbr;
	}
	public void setConfnbr(String confnbr) {
		this.confnbr = confnbr;
	}
	public int getNot() {
		return not;
	}
	public void setNot(int not) {
		this.not = not;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getTransid() {
		return transid;
	}
	public void setTransid(int transid) {
		this.transid = transid;
	}
	
	
	
	
}
