package com.ironhack.week7hellojpa.service;

import com.ironhack.week7hellojpa.enums.CustomerStatus;
import com.ironhack.week7hellojpa.exception.CustomerNotFoundException;
import com.ironhack.week7hellojpa.model.Customer;
import com.ironhack.week7hellojpa.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(UUID id) throws CustomerNotFoundException {
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException(id));
    }

    public List<Customer> getCustomerByStatus(CustomerStatus status) {
        return customerRepository.findByCustomerStatus(status);
    }

    public List<Customer> getCustomersOver100kMiles() {
        return customerRepository.getCustomersOver100kMiles();
    }

    public Customer updateCustomer(UUID id, Customer customer) throws CustomerNotFoundException {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException(id));

        customerToUpdate.setStatus(customer.getStatus() != null ? customer.getStatus() : customerToUpdate.getStatus());
        customerToUpdate.setName(customer.getName() != null ? customer.getName() : customerToUpdate.getName());
        customerToUpdate.setTotalMilesFlown(customer.getTotalMilesFlown());

        return customerRepository.save(customerToUpdate);
    }

    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }
}
