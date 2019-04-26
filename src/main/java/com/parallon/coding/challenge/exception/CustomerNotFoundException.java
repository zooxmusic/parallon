package com.parallon.coding.challenge.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("Customer Not Found");
    }
}
