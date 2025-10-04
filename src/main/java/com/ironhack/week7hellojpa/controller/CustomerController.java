package com.ironhack.week7hellojpa.controller;

import com.ironhack.week7hellojpa.enums.CustomerStatus;
import com.ironhack.week7hellojpa.exception.CustomerNotFoundException;
import com.ironhack.week7hellojpa.model.Customer;
import com.ironhack.week7hellojpa.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById (@PathVariable UUID id) throws CustomerNotFoundException {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/status/{status}")
    public List<Customer> getCustomerByStatus (@PathVariable CustomerStatus status) {
        return customerService.getCustomerByStatus(status);
    }

    @GetMapping("/over100k")
    public List<Customer> getCustomersOver100kMiles() {
        return customerService.getCustomersOver100kMiles();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Customer updateCustomer(@PathVariable UUID id, @RequestBody Customer customer) throws CustomerNotFoundException {
        return customerService.updateCustomer(id, customer);
    }
}
