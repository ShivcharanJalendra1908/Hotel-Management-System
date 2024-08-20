package com.hotelbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelbookingapp.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
