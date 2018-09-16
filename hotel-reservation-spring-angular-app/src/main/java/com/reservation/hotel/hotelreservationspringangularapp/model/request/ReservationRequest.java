package com.reservation.hotel.hotelreservationspringangularapp.model.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservationRequest {
	private Long id;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkIn;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkOut;
	
	private Long roomId;
	
	
	public ReservationRequest(LocalDate checkIn, LocalDate checkOut, Long roomId) {
		super();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomId = roomId;
	}


	public Long getRoomId() {
		return roomId;
	}


	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}


	public ReservationRequest() {
		super();
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	

}
