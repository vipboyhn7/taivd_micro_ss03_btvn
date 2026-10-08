package com.example.product.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Sản phẩm với ID " + id + " không tồn tại!");
    }
}
