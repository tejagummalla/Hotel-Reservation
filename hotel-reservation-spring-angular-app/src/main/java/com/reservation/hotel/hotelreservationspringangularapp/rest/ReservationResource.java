package com.reservation.hotel.hotelreservationspringangularapp.rest;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.hotel.hotelreservationspringangularapp.model.request.ReservationRequest;
import com.reservation.hotel.hotelreservationspringangularapp.model.response.ReservationResponse;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {
	
	@RequestMapping(path="", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> getAvailableRooms(
			@RequestParam(value ="checkIn")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkIn,
			@RequestParam(value ="checkOut")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkOut){
		return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
		
	}
	
	@RequestMapping(path="", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> createReservation(
			@RequestBody
			ReservationRequest reservationRequest){
		
		return new ResponseEntity<>(new ReservationResponse(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path="", method= RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> updateReservation(
			@RequestBody
			ReservationRequest reservationRequest){
		
		return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
	}

}
