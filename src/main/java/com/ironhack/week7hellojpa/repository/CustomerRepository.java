package com.ironhack.week7hellojpa.repository;

import com.ironhack.week7hellojpa.enums.CustomerStatus;
import com.ironhack.week7hellojpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    @Query(value = "SELECT * FROM customers a WHERE  a.status = :customerStatus", nativeQuery = true)
    List<Customer> findByCustomerStatus(@Param("customerStatus") CustomerStatus customerStatus);

    @Query(value = "SELECT * FROM customers a WHERE a.total_miles_flown > 100000" , nativeQuery = true)
    List<Customer> getCustomersOver100kMiles();

    @Override
    Optional<Customer> findById(UUID id);
}
