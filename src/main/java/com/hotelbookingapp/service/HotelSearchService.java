package com.hotelbookingapp.service;

import java.time.LocalDate;
import java.util.List;

import com.hotelbookingapp.model.Hotel;
import com.hotelbookingapp.model.dto.HotelAvailabilityDTO;

public interface HotelSearchService {

    List<HotelAvailabilityDTO> findAvailableHotelsByCityAndDate(String city, LocalDate checkinDate, LocalDate checkoutDate);

    HotelAvailabilityDTO findAvailableHotelById(Long hotelId, LocalDate checkinDate, LocalDate checkoutDate);

    HotelAvailabilityDTO mapHotelToHotelAvailabilityDto(Hotel hotel, LocalDate checkinDate, LocalDate checkoutDate);
}
