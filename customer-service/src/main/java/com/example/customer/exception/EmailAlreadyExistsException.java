package com.example.customer.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String email) {
        super("Email " + email + " đã tồn tại!");
    }
}
