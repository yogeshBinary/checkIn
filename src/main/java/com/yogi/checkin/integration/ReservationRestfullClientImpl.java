package com.yogi.checkin.integration;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yogi.checkin.integration.dto.Reservation;
import com.yogi.checkin.integration.dto.ReservationUpdateRequest;

@Service
public class ReservationRestfullClientImpl implements ReservationRestfullClient {

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate rest = new RestTemplate();
		Reservation reservation = rest.getForObject("http://localhost:8080/flights/reservation/getReservation/"+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate rest = new RestTemplate();
		Reservation reservation = rest.postForObject("http://localhost:8080/flights/reservation/", request, Reservation.class);
		return reservation;
	}

}
