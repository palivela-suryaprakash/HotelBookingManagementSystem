package com.HotelBookingSystem.BookingManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelBookingSystem.BookingManagement.entity.Rooms;

public interface RoomsRepository extends JpaRepository<Rooms,Long>{

    Optional<Rooms> findByroomNo(String roomNo);

    
}
