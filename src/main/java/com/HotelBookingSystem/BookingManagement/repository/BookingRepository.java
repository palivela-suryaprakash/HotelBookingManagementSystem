package com.HotelBookingSystem.BookingManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelBookingSystem.BookingManagement.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
    Booking findByCustomerName(String name);


}
