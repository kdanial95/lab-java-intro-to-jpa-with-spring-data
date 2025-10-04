package com.ironhack.week7hellojpa.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "flight_bookings")
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "customer_id", nullable = false)
    private UUID customer;

    @Column(name = "flight_id", nullable = false)
    private long flight;

    public FlightBooking() {}

    public FlightBooking(UUID customer, long flight) {
        this.customer = customer;
        this.flight = flight;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCustomer() {
        return customer;
    }

    public void setCustomer(UUID customer) {
        this.customer = customer;
    }

    public long getFlight() {
        return flight;
    }

    public void setFlight(long flight) {
        this.flight = flight;
    }
}
