package com.example.product.dto;

import java.math.BigDecimal;

public class ProductResponseDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private Integer stockQuantity;

    public ProductResponseDTO(Long id, String name, BigDecimal price, Integer stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }
}
