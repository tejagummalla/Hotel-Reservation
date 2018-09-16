package com.reservation.hotel.hotelreservationspringangularapp.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.reservation.hotel.hotelreservationspringangularapp.entity.*;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
	Optional<RoomEntity> findById(Long id);
}
