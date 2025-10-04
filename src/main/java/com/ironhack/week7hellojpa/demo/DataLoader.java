package com.ironhack.week7hellojpa.demo;

import com.ironhack.week7hellojpa.enums.CustomerStatus;
import com.ironhack.week7hellojpa.model.Customer;
import com.ironhack.week7hellojpa.model.Flight;
import com.ironhack.week7hellojpa.model.FlightBooking;
import com.ironhack.week7hellojpa.service.CustomerService;
import com.ironhack.week7hellojpa.service.FlightBookingService;
import com.ironhack.week7hellojpa.service.FlightService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "demo")
public class DataLoader implements CommandLineRunner {
    private final CustomerService customerService;
    private final FlightService flightService;
    private final FlightBookingService  flightBookingService;

    public DataLoader(CustomerService customerService,  FlightService flightService, FlightBookingService flightBookingService) {
        this.customerService = customerService;
        this.flightService = flightService;
        this.flightBookingService = flightBookingService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading data...");

        if (!customerService.getCustomers().isEmpty()) {
            System.out.println("Data already loaded!");
            return;
        }

        Customer customer = new Customer("Danial Khan", CustomerStatus.GOLD, 300000);
        Flight flight = new Flight("ABC123", "boeing", 300, 20000);

        Customer savedCustomer = customerService.saveCustomer(customer);
        Flight savedFlight = flightService.saveFlight(flight);

        FlightBooking flightBooking = new FlightBooking(savedCustomer.getId(), savedFlight.getId());
        flightBookingService.saveFlightBooking(flightBooking);
    }
}
