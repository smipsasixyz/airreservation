package com.bsr.air.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bsr.air.dal.ManageUser;
import com.bsr.air.domain.BookingInfo;

@Controller
@RequestMapping(value = { "/book" })
@SessionAttributes("SessionObject")

public class BookController {

	@RequestMapping(value = "/userpayment", method = RequestMethod.POST)
	public ModelAndView bookTicket(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute("SessionObject") BookingInfo BI,@RequestParam String email, @RequestParam String password,HttpServletRequest req) throws SQLException {

		ModelAndView mv = new ModelAndView();
		 boolean b=ManageUser.insertlog(email,password);
			if(b==true) {
				int uid=ManageUser.getUser(email);
				mv.setViewName("payment");
				mv.addObject("amount",BI.getAmount());
				BI.setUid(uid);
			}
			else
			{
				mv.setViewName("login");	
			}
		return mv;
	}
}
