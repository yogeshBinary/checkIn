package com.yogi.checkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yogi.checkin.integration.ReservationRestfullClient;
import com.yogi.checkin.integration.dto.Reservation;
import com.yogi.checkin.integration.dto.ReservationUpdateRequest;


@Controller
public class CheckInController {
	
	@Autowired
	private ReservationRestfullClient reservationRestfullClient;
	
	@RequestMapping("/startCheckin")
	public String startCheckin() {
		return "startCheckin";
	}
	
	@RequestMapping("/proceedCheckin")
	public String proceedCheckin(@RequestParam("id") long id,ModelMap modelMap) {
		Reservation reservation = reservationRestfullClient.findReservation(id);
		modelMap.addAttribute("reservation", reservation);
		
		return"displayReservation";
	}
	
	@RequestMapping("/proceedToCheckin")
	public String proceedToCheckin(@RequestParam("id") Long id,@RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest request = new ReservationUpdateRequest();
		request.setId(id);
		request.setNumberOfBags(numberOfBags);
		request.setCheckedIn(true);
		
		reservationRestfullClient.updateReservation(request);
		
		return "confirmationPage";
	}
}