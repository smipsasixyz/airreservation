package com.bsr.air.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bsr.air.dal.ManageFlights;
import com.bsr.air.domain.BookingInfo;
import com.bsr.air.domain.Flight;
import com.bsr.air.domain.Passenger;

@Controller
@RequestMapping(value = { "/search" })
@SessionAttributes("SessionObject")
public class SearchController {
	
	@ModelAttribute("SessionObject")
	public BookingInfo addStuffToRequestScope() {
		BookingInfo bean = new BookingInfo();
		return bean;
	}
	

	
	@RequestMapping(value = "/savepassengers", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("SessionObject") BookingInfo BI,HttpServletRequest req) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		List<Passenger> passengers = new ArrayList<Passenger>();
		ModelAndView mv = new ModelAndView();

		for (int x = 1; x <=BI.getNooftickets() ; x++) {
			String fn = req.getParameter("fname" + x);
			String ln = req.getParameter("lname" + x);
			Date d =new Date( formatter.parse(req.getParameter("dob" + x)).getTime());
			String e = req.getParameter("email" + x);
			Passenger p = new Passenger(fn, ln, d, e);	
			passengers.add(p);
		}
		Flight  f=ManageFlights.getFlight(BI.getFlightid());
		mv.setViewName("review");
		BI.setPassengers(passengers);
		BI.setAmount(BI.getNooftickets()*f.getPrice());
		mv.addObject("listpassengers", passengers);
		mv.addObject("nooftickets", BI.getNooftickets());
		mv.addObject("flight", f);
		return mv;
	}

	@RequestMapping(value = "/passengerinfo", method = RequestMethod.POST)
	public ModelAndView processPassengerInfo(@ModelAttribute("SessionObject") BookingInfo BI,HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("booking");
        BI.setFlightid(Integer.parseInt(req.getParameter("fid")));		
		mv.addObject("nseats", BI.getNooftickets());
		return mv;
	}

	@RequestMapping(value = "/results", method = RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute("SessionObject") BookingInfo BI,@RequestParam String origin, @RequestParam String destination,
			@RequestParam int nseats) {
		ModelAndView mv = new ModelAndView();
		List<Flight> l = ManageFlights.listFlights(origin, destination);

		if (l.isEmpty()) {
			mv.setViewName("noflights");

		} else {
			mv.setViewName("results");
			mv.addObject("flights", l);
			BI.setNooftickets(nseats);
		}
		return mv;
	}
}
