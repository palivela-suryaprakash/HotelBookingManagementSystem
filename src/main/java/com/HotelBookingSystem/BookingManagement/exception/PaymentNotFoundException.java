package com.HotelBookingSystem.BookingManagement.exception;

public class PaymentNotFoundException extends RuntimeException{
    public PaymentNotFoundException(String message){
        super(message);
    }

}
