package com.ironhack.week7hellojpa.service;

import com.ironhack.week7hellojpa.exception.FlightNotFoundException;
import com.ironhack.week7hellojpa.model.Flight;
import com.ironhack.week7hellojpa.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(long id, Flight flight) throws FlightNotFoundException {
        Flight flightToUpdate = flightRepository.findById(id).orElseThrow(
                () -> new FlightNotFoundException(id));

        flightToUpdate.setFlightNumber(flight.getFlightNumber() != null ? flight.getFlightNumber() : flightToUpdate.getFlightNumber());
        flightToUpdate.setAircraft(flight.getAircraft() != null ? flight.getAircraft() : flightToUpdate.getAircraft());
        flightToUpdate.setTotalNoOfSeats(flight.getTotalNoOfSeats() != 0 ? flight.getTotalNoOfSeats() : flightToUpdate.getTotalNoOfSeats());
        flightToUpdate.setMileage(flight.getMileage() != 0 ? flight.getMileage() : flightToUpdate.getMileage());

        return flightRepository.save(flightToUpdate);
    }

    public void deleteFlight(long id) {
        flightRepository.deleteById(id);
    }
}
