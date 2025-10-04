package com.ironhack.week7hellojpa.controller;

import com.ironhack.week7hellojpa.model.Flight;
import com.ironhack.week7hellojpa.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping()
    public List<Flight> getAll() {
        return flightService.getAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Flight saveFlight(Flight flight) {
        return flightService.saveFlight(flight);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flight updateFlight(@PathVariable long id, @RequestBody Flight flight) throws Exception {
        return flightService.updateFlight(id, flight);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFlight(@PathVariable long id) {
        flightService.deleteFlight(id);
    }
}
