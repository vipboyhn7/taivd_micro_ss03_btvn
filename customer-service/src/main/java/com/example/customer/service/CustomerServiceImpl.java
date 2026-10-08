package com.example.customer.service;

import com.example.customer.dto.CustomerLoginDTO;
import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.dto.CustomerResponseDTO;
import com.example.customer.entity.Customer;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.exception.EmailAlreadyExistsException;
import com.example.customer.exception.InvalidCredentialsException;
import com.example.customer.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerServiceImpl(
            CustomerRepository customerRepository,
            PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public CustomerResponseDTO register(CustomerRequestDTO request) {
        String email = request.getEmail().trim().toLowerCase();
        if (customerRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException(email);
        }

        Customer customer = new Customer(
                request.getFullName().trim(),
                email,
                passwordEncoder.encode(request.getPassword())
        );

        return toResponse(customerRepository.save(customer));
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerResponseDTO findById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return toResponse(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerResponseDTO login(CustomerLoginDTO request) {
        String email = request.getEmail().trim().toLowerCase();
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            throw new InvalidCredentialsException();
        }

        return toResponse(customer);
    }

    private CustomerResponseDTO toResponse(Customer customer) {
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getFullName(),
                customer.getEmail()
        );
    }
}
