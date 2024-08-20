package com.hotelbookingapp.service;

import java.time.LocalDate;
import java.util.List;

import com.hotelbookingapp.model.dto.RoomSelectionDTO;

public interface AvailabilityService {

    Integer getMinAvailableRooms(Long roomId, LocalDate checkinDate, LocalDate checkoutDate);

    void updateAvailabilities(long hotelId, LocalDate checkinDate, LocalDate checkoutDate, List<RoomSelectionDTO> roomSelections);

}
