package com.bsr.air.dal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bsr.air.domain.Flight;
import com.bsr.air.domain.Passenger;

public class ManageBookingInfo {
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	@SuppressWarnings("unchecked")
	public static String manageBook(Flight f, List<Passenger> p, int not, int uid, double amount) {
		int tid = ManageTransactionUser.postTransaction(uid, amount);
		ManageFlights.updateFlight(f.getFid(), not);
		String alphanum = randomAlphaNumeric(6);
		int rid = ManageReservation.postReservation(alphanum, not, f.getFid(), uid, tid);
		ManagePassenger.addPassengers(p, rid);
		return ManageReservation.getReservationcode(uid, tid);
	}
}