package com.example.product.service;

import com.example.product.dto.ProductRequestDTO;
import com.example.product.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO create(ProductRequestDTO request);

    ProductResponseDTO findById(Long id);

    List<ProductResponseDTO> findAll();
}
