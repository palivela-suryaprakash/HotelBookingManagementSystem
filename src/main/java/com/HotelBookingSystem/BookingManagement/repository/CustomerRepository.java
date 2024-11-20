package com.HotelBookingSystem.BookingManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelBookingSystem.BookingManagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
