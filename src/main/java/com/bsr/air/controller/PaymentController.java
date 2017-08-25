package com.bsr.air.controller;

import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bsr.air.dal.ManageBookingInfo;
import com.bsr.air.dal.ManageFlights;
import com.bsr.air.domain.BookingInfo;
import com.bsr.air.domain.Flight;

@Controller
@RequestMapping(value = { "/payment" })
@SessionAttributes("SessionObject")

public class PaymentController {
	private Client client;
	   private static String REST_SERVICE_URL = "http://localhost:8080/creditcardservice/rest/CardService";
	   private static final String SUCCESS_RESULT="<response>SUCCESS</response>";
	
	@RequestMapping(value = "/processpayment", method = RequestMethod.POST)
	public ModelAndView bookTicket(@ModelAttribute("SessionObject") BookingInfo BI,HttpServletRequest req,SessionStatus status) {
		ModelAndView mv = new ModelAndView();
		init();
		String cnumber=req.getParameter("creditnumber");
		String cvv=req.getParameter("cvv");
		Form form = new Form();
	      form.param("cnumber", ""+getSHA256Hash(cnumber));
	      form.param("cvv", ""+getSHA256Hash(cvv));
	      form.param("amount", ""+ BI.getAmount());
	      String callResult = client.target(REST_SERVICE_URL).path("/modify").request(MediaType.APPLICATION_XML).put(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
		if(SUCCESS_RESULT.equals(callResult)){
			mv.setViewName("conform");     
			Flight  f=ManageFlights.getFlight(BI.getFlightid());
			String confnbr=ManageBookingInfo.manageBook(f, BI.getPassengers(),BI.getNooftickets(),BI.getUid(),BI.getAmount());
			mv.addObject("confnbr",confnbr);
			mv.addObject("flight",f);
			mv.addObject("passengers",BI.getPassengers());
			mv.addObject("amount",BI.getAmount());
			mv.addObject("nooftickets",BI.getNooftickets());
			System.err.println("EndSession  : " + BI.toString());
			status.setComplete();
		}
		else {
			mv.setViewName("payment");
			mv.addObject("sorry", "Sorry!!! Problem with your card");
		}
		return mv;
	}
	
	private void init(){
	      this.client = ClientBuilder.newClient();
	   }
	
	private String getSHA256Hash(String data) {
	        String result = null;
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(data.getBytes("UTF-8"));
	            return bytesToHex(hash); // make it printable
	        }catch(Exception ex) {
		            ex.printStackTrace();
	        }

	        return result;
	    }
	    private String  bytesToHex(byte[] hash) {
	        return DatatypeConverter.printHexBinary(hash);
	    }

}
