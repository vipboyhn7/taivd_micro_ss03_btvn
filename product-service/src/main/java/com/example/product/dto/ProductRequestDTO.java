package com.example.product.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ProductRequestDTO {

    @NotBlank(message = "name không được để trống")
    private String name;

    @NotNull(message = "price không được để trống")
    @DecimalMin(value = "0.01", message = "price phải lớn hơn 0")
    private BigDecimal price;

    @NotNull(message = "stockQuantity không được để trống")
    @Min(value = 0, message = "stockQuantity không được âm")
    private Integer stockQuantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
