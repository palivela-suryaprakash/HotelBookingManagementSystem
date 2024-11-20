package com.HotelBookingSystem.BookingManagement.service.inerface;

import com.HotelBookingSystem.BookingManagement.dto.PaymentDto;

public interface PaymentService {
    public PaymentDto addPayment(PaymentDto paymentDto);
    public PaymentDto GetPaymentById(Long id);
    public PaymentDto updatePayment(Long id ,PaymentDto paymentDto);
    public String deletePayments(Long id);

}
