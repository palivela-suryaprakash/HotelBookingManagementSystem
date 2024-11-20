package com.HotelBookingSystem.BookingManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HotelBookingSystem.BookingManagement.dto.PaymentDto;
import com.HotelBookingSystem.BookingManagement.service.PaymentServiceimpl;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class PaymentController {
    @Autowired
    private PaymentServiceimpl paymentserv;

    @PostMapping("/addpayment")
    public ResponseEntity<PaymentDto> addPayment(@Valid @RequestBody PaymentDto paymentDto){
        log.info("created Payment Details:{}",paymentDto);
        PaymentDto savedpayment = paymentserv.addPayment(paymentDto);
        log.info(" successfully created Payment Details:{}",savedpayment);
        return ResponseEntity.ok(savedpayment);
    }
    

    @GetMapping("/addpayment/{id}")
    public ResponseEntity<PaymentDto> GetPaymentById(@Valid @PathVariable Long id){
        log.debug("Retreved The payment details:{}",id);
        PaymentDto getpayment = paymentserv.GetPaymentById(id);
        log.info("Succesfully Retreved Payment:{}",getpayment);
        return ResponseEntity.ok(getpayment);
    }
    @PutMapping("/payment/{id}")
    public ResponseEntity<PaymentDto>updatePayment(@Valid @PathVariable Long id,@RequestBody PaymentDto paymentDto){
        log.debug("Updated The payment details:{}",id);
        PaymentDto updated = paymentserv.updatePayment(id, paymentDto);
        log.info("Mapping done successfully:{}",updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String > deletePayments(@Valid @PathVariable("id") Long id){
        log.debug("Deleting  The payment details:{}",id);
        String s =   paymentserv.deletePayments(id);
        log.info("Updated The payment details:{}",s);
        return ResponseEntity.ok().body(s);
    }

}
