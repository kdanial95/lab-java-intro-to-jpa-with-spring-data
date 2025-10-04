package com.ironhack.week7hellojpa.exception;

public class FlightNotFoundException extends Exception {
    public FlightNotFoundException(long id) {
        super("Flight with ID: " + id + " -> Not found");
    }
}
