package com.bsr.air.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bsr.air.dal.ManageFlights;
import com.bsr.air.dal.ManagePassenger;
import com.bsr.air.dal.ManageReservation;
import com.bsr.air.dal.ManageTransactionUser;
import com.bsr.air.dal.ManageUser;
import com.bsr.air.domain.Flight;
import com.bsr.air.domain.Passenger;
import com.bsr.air.domain.Reservation;
import com.bsr.air.domain.TransactionUser;
import com.bsr.air.domain.User;

@Controller
@RequestMapping(value = { "/managebook" })

public class ManageBookingController {

	@RequestMapping(value = "/viewReservation", method = RequestMethod.GET)
	public ModelAndView enterConformationNumber() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("enterconformnumber");
		return mv;
	}

	@RequestMapping(value = "/processConformationnumber", method = RequestMethod.POST)
	public ModelAndView authenticate(@RequestParam String confnbr) throws SQLException {

		ModelAndView mv = new ModelAndView();
		Reservation reserve = ManageReservation.getReservation(confnbr);
		Flight flight = ManageFlights.getFlight(reserve.getFid());
		int not=reserve.getNot();
		List<Passenger> listPassengers = ManagePassenger.getPassengers(reserve.getRid());
		User user = ManageUser.getUserByID(reserve.getUid());
		TransactionUser tu = ManageTransactionUser.getTransactionUserByID(reserve.getTransid());
		mv.addObject("reservationnumber", confnbr);
		mv.addObject("transaction", tu);
		mv.addObject("list", listPassengers);
		mv.addObject("user", user);
		mv.addObject("flight", flight);
		mv.addObject("nooftickets", not);
		mv.setViewName("reviewreservation");
		return mv;
	}

	@RequestMapping(value = "/cancelReservation", method = RequestMethod.POST)
	public ModelAndView cancelConformationNumber(@RequestParam String confnbr) throws SQLException {

		ModelAndView mv = new ModelAndView();
		Reservation reserve = ManageReservation.getReservation(confnbr);
		System.out.println(reserve.getConfnbr());
		Flight flight = ManageFlights.getFlight(reserve.getFid());
		List<Passenger> listPassengers = ManagePassenger.getPassengers(reserve.getRid());
		User user = ManageUser.getUserByID(reserve.getUid());
		TransactionUser tu = ManageTransactionUser.getTransactionUserByID(reserve.getTransid());
		ManageTransactionUser.changeStatus(tu.getTransid());
		TransactionUser ntu = ManageTransactionUser.getTransactionUserByID(reserve.getTransid());
		mv.addObject("reservationnumber", confnbr);
		mv.addObject("transaction", ntu);
		mv.addObject("list", listPassengers);
		mv.addObject("user", user);
		mv.addObject("flight", flight);
		mv.setViewName("cancelreservation");
		return mv;
	}
}
