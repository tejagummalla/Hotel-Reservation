package com.reservation.hotel.hotelreservationspringangularapp.rest;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.hotel.hotelreservationspringangularapp.convertor.RoomEntityToReservableRoomResponseConvertor;
import com.reservation.hotel.hotelreservationspringangularapp.entity.ReservatioEntity;
import com.reservation.hotel.hotelreservationspringangularapp.entity.RoomEntity;
import com.reservation.hotel.hotelreservationspringangularapp.model.request.ReservationRequest;
import com.reservation.hotel.hotelreservationspringangularapp.model.response.ReservableRoomResponse;
import com.reservation.hotel.hotelreservationspringangularapp.model.response.ReservationResponse;
import com.reservation.hotel.hotelreservationspringangularapp.repository.PageableRoomRepository;
import com.reservation.hotel.hotelreservationspringangularapp.repository.ReservationRepository;
import com.reservation.hotel.hotelreservationspringangularapp.repository.RoomRepository;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
@CrossOrigin
public class ReservationResource {
	
	@Autowired
	PageableRoomRepository pageableRoomRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	ConversionService conversionService;
	
	RoomEntityToReservableRoomResponseConvertor converter = new RoomEntityToReservableRoomResponseConvertor();
	
	@RequestMapping(path="", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<ReservableRoomResponse> getAvailableRooms(
			@RequestParam(value ="checkIn")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkIn,
			@RequestParam(value ="checkOut")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkOut, Pageable pageable){
		
		Page<RoomEntity> roomEntityList = pageableRoomRepository.findAll(pageable);
		// Spring data2 does not take a converter, takes a function
		return roomEntityList.map(converter::convert);		
	}
	
	@RequestMapping(path="/{roomId}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RoomEntity> getRoomById(
			@PathVariable
			Long roomId){
		Optional<RoomEntity> roomEntity = roomRepository.findById(roomId);
		
		return new ResponseEntity<>(roomEntity.get(), HttpStatus.OK);
		
	}
	
	@RequestMapping(path="", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> createReservation(
			@RequestBody
			ReservationRequest reservationRequest){
		
		ReservatioEntity reservationEntity = conversionService.convert(reservationRequest, ReservatioEntity.class);
		
		reservationRepository.save(reservationEntity);
		RoomEntity roomEntity = roomRepository.findById(reservationRequest.getRoomId()).get();
		roomEntity.addReservationEntity(reservationEntity);
		roomRepository.save(roomEntity);
		
		reservationEntity.setRoomEntity(roomEntity);
		
		ReservationResponse reservationResponse = conversionService.convert(reservationEntity,ReservationResponse.class);
		
		return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
	}
	
	
	
	@RequestMapping(path="", method= RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservableRoomResponse> updateReservation(
			@RequestBody
			ReservationRequest reservationRequest){
		
		return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.OK);
	}
	
	@RequestMapping(path="/{reservationId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReservation(
			@PathVariable
			long reservationId){
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
