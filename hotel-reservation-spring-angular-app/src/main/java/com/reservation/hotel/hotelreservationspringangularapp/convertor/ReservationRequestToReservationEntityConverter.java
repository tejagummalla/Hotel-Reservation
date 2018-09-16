package com.reservation.hotel.hotelreservationspringangularapp.convertor;
import org.springframework.core.convert.converter.Converter;

import com.reservation.hotel.hotelreservationspringangularapp.entity.*;
import com.reservation.hotel.hotelreservationspringangularapp.model.request.*;

public class ReservationRequestToReservationEntityConverter implements Converter<ReservationRequest,ReservatioEntity> {

	@Override
	public ReservatioEntity convert(ReservationRequest source) {
		// TODO Auto-generated method stub
		ReservatioEntity reservationEntity = new ReservatioEntity();
		reservationEntity.setCheckIn(source.getCheckIn());
		reservationEntity.setCheckOut(source.getCheckOut());
		if (source.getId() != null)
			reservationEntity.setId(source.getId());
		
		return reservationEntity;
	}

}
