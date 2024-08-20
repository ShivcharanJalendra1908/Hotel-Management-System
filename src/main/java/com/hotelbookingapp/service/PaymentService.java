package com.hotelbookingapp.service;

import com.hotelbookingapp.model.Booking;
import com.hotelbookingapp.model.Payment;
import com.hotelbookingapp.model.dto.BookingInitiationDTO;

public interface PaymentService {

    Payment savePayment(BookingInitiationDTO bookingInitiationDTO, Booking booking);
}
