package com.hotelbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelbookingapp.model.HotelManager;
import com.hotelbookingapp.model.User;

import java.util.Optional;

@Repository
public interface HotelManagerRepository extends JpaRepository<HotelManager, Long> {

    Optional<HotelManager> findByUser(User user);
}
