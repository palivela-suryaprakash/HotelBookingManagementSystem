package com.HotelBookingSystem.BookingManagement.dto;
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
public class PaymentDto {
    private String paymentDate;
    private String paymentType;
    private String paymentStatus;
    @NotNull(message = "payment is mandatory for booking")
    @Digits(integer = 6,fraction = 4, message = "should be in between -1 to 6")
    private String paymentAmount;

}
