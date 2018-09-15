package com.reservation.hotel.hotelreservationspringangularapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class HotelReservationSpringAngularAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HotelReservationSpringAngularAppApplication.class, args);
	}
}
