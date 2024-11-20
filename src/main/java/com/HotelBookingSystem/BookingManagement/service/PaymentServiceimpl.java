package com.HotelBookingSystem.BookingManagement.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.HotelBookingSystem.BookingManagement.dto.PaymentDto;
import com.HotelBookingSystem.BookingManagement.entity.Payment;
import com.HotelBookingSystem.BookingManagement.exception.PaymentNotFoundException;
import com.HotelBookingSystem.BookingManagement.mappers.PaymentMappers;
import com.HotelBookingSystem.BookingManagement.repository.PaymentRepository;
import com.HotelBookingSystem.BookingManagement.service.inerface.PaymentService;
@Service
public class PaymentServiceimpl implements PaymentService{
    @Autowired
    private PaymentRepository repoo;
    @Override
    public PaymentDto addPayment(PaymentDto paymentDto) {
        Payment payment = PaymentMappers.PaymentDtoToPayment(paymentDto);
        return PaymentMappers.PaymentToPaymentDto(repoo.save(payment));
        }

    // @SuppressWarnings("deprecation")
    @Override
    public PaymentDto GetPaymentById(Long id) {
        Payment p =  repoo.findById(id).orElseThrow(()-> new PaymentNotFoundException("Sorry yaar not found"+id)); 
        return PaymentMappers.PaymentToPaymentDto(p);
    }

    @Override
    public PaymentDto updatePayment(Long id, PaymentDto paymentDto) {
        Payment existingPayment= repoo.findById(id).orElseThrow(()-> new PaymentNotFoundException("Sorry payment not found by id is"+id));
        existingPayment.setPaymentDate(paymentDto.getPaymentDate());
        existingPayment.setPaymentAmount(paymentDto.getPaymentAmount());
        existingPayment.setPaymentType(paymentDto.getPaymentType());
        existingPayment.setPaymentStatus(paymentDto.getPaymentStatus());
        Payment updatedPayment =  repoo.save(existingPayment);
        return PaymentMappers.PaymentToPaymentDto(updatedPayment);
        

        // return repoo.save(payment);
    }

    @Override
    public String  deletePayments(Long id) {
        Payment m = repoo.findById(id).orElseThrow(()->new PaymentNotFoundException("Sorry payment not found yaar"+id));
        repoo.delete(m);
        return "successfully Deleted";
    }
}
