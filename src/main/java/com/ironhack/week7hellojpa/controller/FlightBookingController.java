package com.ironhack.week7hellojpa.controller;

import com.ironhack.week7hellojpa.exception.CustomerNotFoundException;
import com.ironhack.week7hellojpa.exception.FlightBookingNotFoundException;
import com.ironhack.week7hellojpa.exception.FlightNotFoundException;
import com.ironhack.week7hellojpa.model.FlightBooking;
import com.ironhack.week7hellojpa.service.FlightBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/flightbookings")
public class FlightBookingController {
    private final FlightBookingService flightBookingService;

    public FlightBookingController(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    @GetMapping()
    public List<FlightBooking> getFlightBookings() {
        return flightBookingService.getAll();
    }

    @GetMapping("/{id}")
    public FlightBooking getFlightBookingById(@PathVariable UUID id) throws FlightBookingNotFoundException {
        return flightBookingService.getById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<FlightBooking> getFlightBookingByCustomerId(@PathVariable UUID customerId) throws CustomerNotFoundException {
        return flightBookingService.getFlightBookingByCustomerId(customerId);
    }

    @GetMapping("/flight/{flightId}")
    public List<FlightBooking> getFlightBookingByFlightId(@PathVariable int flightId) throws FlightNotFoundException {
        return flightBookingService.getFlightBookingByFlightId(flightId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public FlightBooking saveFlightBooking(@RequestBody FlightBooking flightBooking) {
        return flightBookingService.saveFlightBooking(flightBooking);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FlightBooking updateFlightBooking(@PathVariable UUID id, @RequestBody FlightBooking flightBooking) throws Exception {
        return flightBookingService.updateFlightBooking(id, flightBooking);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFlightBooking(@PathVariable UUID id) {
        flightBookingService.deleteFlightBooking(id);
    }
}
