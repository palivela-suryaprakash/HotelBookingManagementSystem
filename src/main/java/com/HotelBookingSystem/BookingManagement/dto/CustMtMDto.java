package com.HotelBookingSystem.BookingManagement.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class CustMtMDto {
    @NotNull(message ="must be filed ")
    @Size(min = 2 ,max = 40, message ="Teacher name must be char 2 - 40")
    private String customerName;
    @Email(message = "Invalid email format must @gmail.com")
    @NotBlank(message = "Email is required")
    private String email;
    @NotNull(message = "addres is mandatory")
    private String address;
    private List<RoomMtMDto> assignedRooms = new ArrayList<>();

}
