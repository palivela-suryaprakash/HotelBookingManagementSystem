package com.HotelBookingSystem.BookingManagement.mappers;

import com.HotelBookingSystem.BookingManagement.dto.PaymentDto;
import com.HotelBookingSystem.BookingManagement.entity.Payment;

public class PaymentMappers {
    public static Payment PaymentDtoToPayment (PaymentDto paymentDto){
        Payment payment = new Payment();
        payment.setPaymentDate(paymentDto.getPaymentDate());
        payment.setPaymentAmount(paymentDto.getPaymentAmount());
        payment.setPaymentType(paymentDto.getPaymentType());
        payment.setPaymentStatus(paymentDto.getPaymentStatus());
        return payment;
    }
    public static PaymentDto PaymentToPaymentDto (Payment payment){
        PaymentDto paymentdto = new PaymentDto();
        paymentdto.setPaymentDate(payment.getPaymentDate());
        paymentdto.setPaymentAmount(payment.getPaymentAmount());
        paymentdto.setPaymentType(payment.getPaymentType());
        paymentdto.setPaymentStatus(payment.getPaymentStatus());
        return paymentdto;
    }
}
