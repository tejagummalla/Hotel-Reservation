package com.reservation.hotel.hotelreservationspringangularapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.reservation.hotel.hotelreservationspringangularapp.entity.ReservatioEntity;

public interface ReservationRepository extends CrudRepository<ReservatioEntity, Long> {

}
