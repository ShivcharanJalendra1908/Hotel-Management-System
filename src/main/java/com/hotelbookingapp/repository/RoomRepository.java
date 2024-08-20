package com.hotelbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelbookingapp.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
