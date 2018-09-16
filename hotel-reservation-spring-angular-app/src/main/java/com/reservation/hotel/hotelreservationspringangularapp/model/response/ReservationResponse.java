package com.reservation.hotel.hotelreservationspringangularapp.model.response;

import java.time.LocalDate;

public class ReservationResponse {
	
	private Long id;
	private LocalDate checkIn;
	private LocalDate cheackOut;
	
	
	
	public ReservationResponse() {
		super();
	}
	public ReservationResponse(Long id, LocalDate checkIn, LocalDate cheackOut) {
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.cheackOut = cheackOut;
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
	public LocalDate getCheackOut() {
		return cheackOut;
	}
	public void setCheackOut(LocalDate cheackOut) {
		this.cheackOut = cheackOut;
	}
	
	

}
