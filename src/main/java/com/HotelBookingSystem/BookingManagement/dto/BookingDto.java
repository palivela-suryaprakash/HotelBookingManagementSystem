package com.HotelBookingSystem.BookingManagement.dto;
import com.HotelBookingSystem.BookingManagement.entity.Payment;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
@NotNull(message ="Customer name should be required ")
    private String customerName;
    private String roomName;
    private String checkInDate;
    private String checkOutDate;
    private String  bookingStatus;
    @NotNull()
    @Digits(integer = 5,fraction =4,message = "should be 1 to 5 digits ")
    private  String amountPaid;
    private Payment payment;
    

}
