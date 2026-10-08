package com.example.customer.service;

import com.example.customer.dto.CustomerLoginDTO;
import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.dto.CustomerResponseDTO;

public interface CustomerService {

    CustomerResponseDTO register(CustomerRequestDTO request);

    CustomerResponseDTO findById(Long id);

    CustomerResponseDTO login(CustomerLoginDTO request);
}
