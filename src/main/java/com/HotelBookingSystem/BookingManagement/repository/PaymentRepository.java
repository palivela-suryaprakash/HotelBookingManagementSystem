package com.HotelBookingSystem.BookingManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelBookingSystem.BookingManagement.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long>  {

}
