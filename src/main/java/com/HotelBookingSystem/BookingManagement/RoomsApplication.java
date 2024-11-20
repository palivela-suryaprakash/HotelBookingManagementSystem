package com.HotelBookingSystem.BookingManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
@OpenAPIDefinition(info = @Info(title=" HOTEL BOOKING MANAGEMENT SYSTEM",
        contact = @Contact(email = "novahotel@gmail.com",name="Nova hotel"
        ), description = "A Hotel booking  Management System (HMS) is a software application designed to manage and streamline Booking-related data and Room Booking processes within a Nova Hotel and it also provides management details of Hotel records, including Rooms,Customers and personal information.\n" +
        "A Hotel Booking Management System (HMS) is an all-encompassing solution designed to automate and simplify the Booking of various customer-related activities in Booking management.This hotel booking system improves accuracy of booking history, and enabling informed decision-making. "
))
@SpringBootApplication 
public class RoomsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomsApplication.class, args);
	}

}
