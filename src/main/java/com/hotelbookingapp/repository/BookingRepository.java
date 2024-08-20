package com.hotelbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelbookingapp.model.Booking;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingsByCustomerId(Long customerId);

    Optional<Booking> findBookingByIdAndCustomerId(Long bookingId, Long customerId);

    List<Booking> findBookingsByHotelId(Long hotelId);

    Optional<Booking> findBookingByIdAndHotel_HotelManagerId(Long bookingId, Long hotelManagerId);

}
