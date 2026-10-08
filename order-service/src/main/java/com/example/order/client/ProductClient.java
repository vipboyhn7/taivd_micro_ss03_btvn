package com.example.order.client;

import com.example.order.dto.ProductResponseDTO;
import com.example.order.exception.ProductServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Component
public class ProductClient {

    private final RestClient restClient;

    public ProductClient(
            RestClient.Builder restClientBuilder,
            @Value("${services.product.base-url}") String productServiceUrl) {
        this.restClient = restClientBuilder.baseUrl(productServiceUrl).build();
    }

    public ProductResponseDTO findById(Long productId) {
        try {
            ProductResponseDTO product = restClient.get()
                    .uri("/api/v1/products/{id}", productId)
                    .retrieve()
                    .body(ProductResponseDTO.class);
            if (product == null || product.price() == null) {
                throw new ProductServiceException("Product Service trả về dữ liệu không hợp lệ");
            }
            return product;
        } catch (RestClientException exception) {
            throw new ProductServiceException(
                    "Không thể lấy giá sản phẩm từ Product Service", exception);
        }
    }
}
