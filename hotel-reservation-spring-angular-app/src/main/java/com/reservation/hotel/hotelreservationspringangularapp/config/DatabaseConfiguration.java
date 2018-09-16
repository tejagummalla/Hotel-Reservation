package com.reservation.hotel.hotelreservationspringangularapp.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.reservation.hotel.hotelreservationspringangularapp.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {
	
}
