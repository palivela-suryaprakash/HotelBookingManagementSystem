package com.HotelBookingSystem.BookingManagement.mappers;

import com.HotelBookingSystem.BookingManagement.dto.BookingDto;
import com.HotelBookingSystem.BookingManagement.entity.Booking;

public class BookingMappers {
    public static Booking BookingDtoToBooking(BookingDto bookingDto){
        Booking booking = new Booking();
        booking.setCustomerName(bookingDto.getCustomerName());
        booking.setRoomName(bookingDto.getRoomName());
        booking.setCheckInDate(bookingDto.getCheckInDate());
        booking.setCheckOutDate(bookingDto.getCheckOutDate());
        booking.setBookingStatus(bookingDto.getBookingStatus());
        booking.setAmountPaid(bookingDto.getAmountPaid());
        booking.setPayment(bookingDto.getPayment());
        return booking;

    }
    public static BookingDto BookingToBookingDto(Booking booking){
        BookingDto bookingDto = new BookingDto();
        bookingDto.setCustomerName(booking.getCustomerName());
        bookingDto.setRoomName(booking.getRoomName());
        bookingDto.setCheckInDate(booking.getCheckInDate());
        bookingDto.setCheckOutDate(booking.getCheckOutDate());
        bookingDto.setBookingStatus(booking.getBookingStatus());
        bookingDto.setAmountPaid(booking.getAmountPaid());
        bookingDto.setPayment(booking.getPayment());
        return bookingDto;
    }
}
