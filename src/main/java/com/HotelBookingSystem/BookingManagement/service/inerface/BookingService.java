package com.HotelBookingSystem.BookingManagement.service.inerface;

import com.HotelBookingSystem.BookingManagement.dto.BookingDto;

public interface BookingService {
    public BookingDto addBooking(BookingDto book);
    public BookingDto getBookingById(Long id);
    public BookingDto getBookingByName(String name);
    public BookingDto updateBooking(Long id,BookingDto booking);
    public String deleteBooking(Long id);
}
