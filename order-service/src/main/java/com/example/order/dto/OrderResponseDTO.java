package com.example.order.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponseDTO(
        Long id,
        Long customerId,
        Long productId,
        Integer quantity,
        LocalDateTime orderDate,
        BigDecimal totalAmount
) {
}
