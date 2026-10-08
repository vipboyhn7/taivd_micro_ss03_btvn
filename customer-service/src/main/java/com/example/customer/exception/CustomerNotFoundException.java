package com.example.customer.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Khách hàng với ID " + id + " không tồn tại!");
    }
}
