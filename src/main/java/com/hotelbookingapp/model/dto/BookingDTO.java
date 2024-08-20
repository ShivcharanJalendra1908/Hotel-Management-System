package com.hotelbookingapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.hotelbookingapp.model.enums.PaymentMethod;
import com.hotelbookingapp.model.enums.PaymentStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

    private Long id;
    private String confirmationNumber;
    private LocalDateTime bookingDate;
    private Long customerId;
    private Long hotelId;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private List<RoomSelectionDTO> roomSelections = new ArrayList<>();
    private BigDecimal totalPrice;
    private String hotelName;
    private AddressDTO hotelAddress;
    private String customerName;
    private String customerEmail;
    private PaymentStatus paymentStatus;
    private PaymentMethod paymentMethod;
    
}
