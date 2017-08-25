package com.bsr.air.domain;

public class CreditCard {
	
	private int ccid;
	private String cnumber;
	private String cvv;
	private double amount;
	
	public CreditCard() {
		super();
	}

	public CreditCard(String cnumber, String cvv, double amount) {
		super();
		this.cnumber = cnumber;
		this.cvv = cvv;
		this.amount = amount;
	}

	public CreditCard(int ccid, String cnumber, String cvv, double amount) {
		super();
		this.ccid = ccid;
		this.cnumber = cnumber;
		this.cvv = cvv;
		this.amount = amount;
	}



	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public int getCcid() {
		return ccid;
	}

	public void setCcid(int ccid) {
		this.ccid = ccid;
	}

	public String getCnumber() {
		return cnumber;
	}

	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	
	
}
