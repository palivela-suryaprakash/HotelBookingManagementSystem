package com.HotelBookingSystem.BookingManagement.dto;



import com.HotelBookingSystem.BookingManagement.entity.Customer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomsDto {
    private String roomNo;
    @NotNull(message ="plesae mention what type of room required?")
    private String roomType;
    private Customer customer;
}
