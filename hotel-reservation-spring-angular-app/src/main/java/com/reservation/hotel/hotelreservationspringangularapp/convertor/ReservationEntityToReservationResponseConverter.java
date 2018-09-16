package com.reservation.hotel.hotelreservationspringangularapp.convertor;

import org.springframework.core.convert.converter.Converter;

import com.reservation.hotel.hotelreservationspringangularapp.entity.ReservatioEntity;
import com.reservation.hotel.hotelreservationspringangularapp.model.response.ReservationResponse;

public class ReservationEntityToReservationResponseConverter implements Converter<ReservatioEntity, ReservationResponse>{

	@Override
	public ReservationResponse convert(ReservatioEntity source) {
		// TODO Auto-generated method stub
		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setCheackOut(source.getCheckOut());
		reservationResponse.setCheckIn(source.getCheckIn());
		
		if (null != source.getRoomEntity())
            reservationResponse.setId(source.getRoomEntity().getId());
		return reservationResponse;
	}
	

}
