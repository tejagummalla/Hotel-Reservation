package com.reservation.hotel.hotelreservationspringangularapp.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.reservation.hotel.hotelreservationspringangularapp.convertor.ReservationEntityToReservationResponseConverter;
import com.reservation.hotel.hotelreservationspringangularapp.convertor.ReservationRequestToReservationEntityConverter;
import com.reservation.hotel.hotelreservationspringangularapp.convertor.RoomEntityToReservableRoomResponseConvertor;

@Configuration
public class ConversionConfiguration {
	private Set<Converter> getConverters(){
		Set<Converter> converters = new HashSet<Converter>();
		converters.add(new RoomEntityToReservableRoomResponseConvertor());
		converters.add(new ReservationRequestToReservationEntityConverter());
		converters.add(new ReservationEntityToReservationResponseConverter());
		return converters;
	}
	
	@Bean
	public ConversionService conversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.setConverters(getConverters());
		bean.afterPropertiesSet();
		
		return bean.getObject();
	}
}
