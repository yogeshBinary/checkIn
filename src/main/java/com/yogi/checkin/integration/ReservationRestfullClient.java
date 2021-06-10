package com.yogi.checkin.integration;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.yogi.checkin.integration.dto.Reservation;
import com.yogi.checkin.integration.dto.ReservationUpdateRequest;

@Service
public interface ReservationRestfullClient {
	public Reservation findReservation(Long id);
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request);
}
