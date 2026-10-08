package com.example.order.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Đơn hàng với ID " + id + " không tồn tại!");
    }
}
