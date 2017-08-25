package com.bsr.air.domain;

import java.util.List;

public class BookingInfo {
	private int nooftickets;
	private int flightid;
	private List<Passenger> passengers;
	private double amount;
	int uid;
	
	public BookingInfo() {
	}

	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getNooftickets() {
		return nooftickets;
	}

	public void setNooftickets(int nooftickets) {
		this.nooftickets = nooftickets;
	}

	public int getFlightid() {
		return flightid;
	}

	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
