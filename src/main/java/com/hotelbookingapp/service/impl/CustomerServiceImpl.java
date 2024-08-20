package com.hotelbookingapp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.hotelbookingapp.model.Customer;
import com.hotelbookingapp.repository.CustomerRepository;
import com.hotelbookingapp.service.CustomerService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> findByUserId(Long userId) {
        return customerRepository.findByUserId(userId);
    }

    @Override
    public Optional<Customer> findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

}
