package com.ironhack.week7hellojpa.exception;

import java.util.UUID;

public class FlightBookingNotFoundException extends Exception{
    public FlightBookingNotFoundException(UUID id) {
        super("Flight booking with ID: " + id + " -> Not found");
    }
}
