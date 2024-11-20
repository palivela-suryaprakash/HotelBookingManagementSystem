package com.HotelBookingSystem.BookingManagement.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustroomDto {
    @NotNull(message = "must be filled")
    private String customerName;
    @NotNull(message = "Email is mandatory")
    @Email(message = "E mail should be in format of  .gmail.com")
    private String email;
    private String address;
    private List<RoomsDto> roomList;

}
