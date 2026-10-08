package com.example.customer.exception;

public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException() {
        super("email or password incorrect");
    }
}
