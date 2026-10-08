package com.example.order.service;

import com.example.order.client.ProductClient;
import com.example.order.dto.OrderRequestDTO;
import com.example.order.dto.OrderResponseDTO;
import com.example.order.dto.ProductResponseDTO;
import com.example.order.entity.Order;
import com.example.order.exception.OrderNotFoundException;
import com.example.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    @Override
    @Transactional
    public OrderResponseDTO create(OrderRequestDTO request) {
        ProductResponseDTO product = productClient.findById(request.getProductId());
        BigDecimal totalAmount = product.price()
                .multiply(BigDecimal.valueOf(request.getQuantity()));

        Order order = new Order(
                request.getCustomerId(),
                request.getProductId(),
                request.getQuantity(),
                LocalDateTime.now(),
                totalAmount
        );
        return toResponse(orderRepository.save(order));
    }

    @Override
    @Transactional(readOnly = true)
    public OrderResponseDTO findById(Long id) {
        return orderRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    private OrderResponseDTO toResponse(Order order) {
        return new OrderResponseDTO(
                order.getId(),
                order.getCustomerId(),
                order.getProductId(),
                order.getQuantity(),
                order.getOrderDate(),
                order.getTotalAmount()
        );
    }
}
