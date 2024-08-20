package com.hotelbookingapp.service;

import com.hotelbookingapp.model.HotelManager;
import com.hotelbookingapp.model.User;

public interface HotelManagerService {

    HotelManager findByUser(User user);

}
