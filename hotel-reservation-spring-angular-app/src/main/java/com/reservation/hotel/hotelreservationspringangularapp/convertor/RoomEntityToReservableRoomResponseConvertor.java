package com.reservation.hotel.hotelreservationspringangularapp.convertor;

import org.springframework.core.convert.converter.Converter;

import com.reservation.hotel.hotelreservationspringangularapp.entity.RoomEntity;
import com.reservation.hotel.hotelreservationspringangularapp.model.Links;
import com.reservation.hotel.hotelreservationspringangularapp.model.Self;
import com.reservation.hotel.hotelreservationspringangularapp.model.response.ReservableRoomResponse;
import com.reservation.hotel.hotelreservationspringangularapp.rest.ResourceConstants;


public class RoomEntityToReservableRoomResponseConvertor implements Converter<RoomEntity, ReservableRoomResponse>{

	@Override
	public ReservableRoomResponse convert(RoomEntity source) {
		// TODO Auto-generated method stub
		
		ReservableRoomResponse reservationResponse = new ReservableRoomResponse();
		reservationResponse.setRoomNumber(source.getRoomNumber());
		reservationResponse.setPrice(Integer.valueOf(source.getPrice()));
		
		Links links = new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
		links.setSelf(self);
		
		reservationResponse.setLinks(links);
		
		return reservationResponse;
	}
	
	
}
