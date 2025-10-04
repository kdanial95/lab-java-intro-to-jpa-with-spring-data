package com.ironhack.week7hellojpa.repository;

import com.ironhack.week7hellojpa.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, UUID> {
    @Query(value = "SELECT * FROM flight_bookings a WHERE a.customer_id = :customerId", nativeQuery = true)
    List<FlightBooking> findByCustomerId(@Param("customerId") UUID customerId);

    @Query(value = "SELECT * FROM flight_bookings a WHERE a.flight_id = :flightId", nativeQuery = true)
    List<FlightBooking> findByFlightId(@Param("flightId") long flightId);
}
