package com.reservation.hotel.hotelreservationspringangularapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.reservation.hotel.hotelreservationspringangularapp.entity.RoomEntity;
import com.reservation.hotel.hotelreservationspringangularapp.repository.RoomRepository;

@Component
public class H2Bootstrap implements CommandLineRunner {
	
	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public void run(String... args) throws Exception{
		roomRepository.save(new RoomEntity(105,"130"));
		roomRepository.save(new RoomEntity(205,"340"));
		roomRepository.save(new RoomEntity(305,"1200"));
		roomRepository.save(new RoomEntity(405,"223"));
		roomRepository.save(new RoomEntity(505,"2234"));
		
		Iterable<RoomEntity> itr = roomRepository.findAll();
		
		for(RoomEntity room : itr) {
			System.out.println(room.getRoomNumber());
		}
		
	}

}
