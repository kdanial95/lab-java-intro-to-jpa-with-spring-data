package com.ironhack.week7hellojpa.service;

import com.ironhack.week7hellojpa.exception.CustomerNotFoundException;
import com.ironhack.week7hellojpa.exception.FlightBookingNotFoundException;
import com.ironhack.week7hellojpa.exception.FlightNotFoundException;
import com.ironhack.week7hellojpa.model.Customer;
import com.ironhack.week7hellojpa.model.Flight;
import com.ironhack.week7hellojpa.model.FlightBooking;
import com.ironhack.week7hellojpa.repository.CustomerRepository;
import com.ironhack.week7hellojpa.repository.FlightBookingRepository;
import com.ironhack.week7hellojpa.repository.FlightRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FlightBookingService {
    private final FlightBookingRepository flightBookingRepository;

    public FlightBookingService(FlightBookingRepository flightBookingRepository) {
        this.flightBookingRepository = flightBookingRepository;
    }

    public List<FlightBooking> getAll() {
        return flightBookingRepository.findAll();
    }

    public FlightBooking getById(UUID id) throws FlightBookingNotFoundException {
        return flightBookingRepository.findById(id).orElseThrow(
                () -> new FlightBookingNotFoundException(id));
    }

    public FlightBooking saveFlightBooking(FlightBooking flightBooking) {
        return flightBookingRepository.save(flightBooking);
    }

    public List<FlightBooking> getFlightBookingByCustomerId(UUID customerId) throws CustomerNotFoundException {
        if (flightBookingRepository.findByCustomerId(customerId).isEmpty()) {
            throw new CustomerNotFoundException(customerId);
        }

        return flightBookingRepository.findByCustomerId(customerId);
    }

    public List<FlightBooking> getFlightBookingByFlightId (long flightId) throws FlightNotFoundException {
        if (flightBookingRepository.findByFlightId(flightId).isEmpty()) {
            throw new FlightNotFoundException(flightId);
        }

        return flightBookingRepository.findByFlightId(flightId);
    }

    public FlightBooking updateFlightBooking(UUID id, FlightBooking flightBooking) throws FlightBookingNotFoundException {
        FlightBooking flightBookingToUpdate = flightBookingRepository.findById(id).orElseThrow(
                () -> new FlightBookingNotFoundException(id));

        flightBookingToUpdate.setFlight(flightBooking.getFlight() != 0 ? flightBooking.getFlight() : flightBookingToUpdate.getFlight());
        flightBookingToUpdate.setCustomer(flightBooking.getCustomer() != null ? flightBooking.getCustomer() : flightBookingToUpdate.getCustomer());

        return flightBookingRepository.save(flightBookingToUpdate);
    }

    public void deleteFlightBooking(UUID id) {
        flightBookingRepository.deleteById(id);
    }
}