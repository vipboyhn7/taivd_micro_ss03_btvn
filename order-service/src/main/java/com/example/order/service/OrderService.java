package com.example.order.service;

import com.example.order.dto.OrderRequestDTO;
import com.example.order.dto.OrderResponseDTO;

public interface OrderService {

    OrderResponseDTO create(OrderRequestDTO request);

    OrderResponseDTO findById(Long id);
}
