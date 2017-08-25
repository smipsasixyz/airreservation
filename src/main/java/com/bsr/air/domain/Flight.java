package com.bsr.air.domain;

import java.sql.Time;

public class Flight {
	  
	private int fid;
	private int fnum;
	private String origin;
	private String destination;
	private Time dtime;
	private Time atime;
	private int nseats;
	private double price;
	
	public Flight() {
	}

	public Flight(int fnum, String origin, String destination, Time dtime, Time atime, int nseats, double price) {
		super();
		this.fnum = fnum;
		this.origin = origin;
		this.destination = destination;
		this.dtime = dtime;
		this.atime = atime;
		this.nseats = nseats;
		this.price = price;
	}
	
	
	public Flight(int fid, int fnum, String origin, String destination, Time dtime, Time atime, int nseats,
			double price) {
		super();
		this.fid = fid;
		this.fnum = fnum;
		this.origin = origin;
		this.destination = destination;
		this.dtime = dtime;
		this.atime = atime;
		this.nseats = nseats;
		this.price = price;
	}


	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Time getDtime() {
		return dtime;
	}
	public void setDtime(Time dtime) {
		this.dtime = dtime;
	}
	public Time getAtime() {
		return atime;
	}
	public void setAtime(Time atime) {
		this.atime = atime;
	}
	public int getNseats() {
		return nseats;
	}
	public void setNseats(int nseats) {
		this.nseats = nseats;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
