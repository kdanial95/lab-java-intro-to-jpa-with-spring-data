package com.ironhack.week7hellojpa.exception;

import java.util.UUID;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(UUID id) {
        super("Customer with ID: " + id + " -> Not found");
    }
}
