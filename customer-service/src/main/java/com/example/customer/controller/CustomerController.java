package com.example.customer.controller;

import com.example.customer.dto.CustomerLoginDTO;
import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.dto.CustomerResponseDTO;
import com.example.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerResponseDTO> register(
            @Valid @RequestBody CustomerRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.register(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PutMapping("/login")
    public ResponseEntity<CustomerResponseDTO> login(
            @Valid @RequestBody CustomerLoginDTO request) {
        return ResponseEntity.ok(customerService.login(request));
    }
}
