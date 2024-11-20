package com.HotelBookingSystem.BookingManagement.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Booking {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String customerName;
    private String roomName;
    private String checkInDate;
    private String checkOutDate;
    private String  bookingStatus;
    private  String amountPaid;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "booking")
    private Payment payment;

    // @ManyToOne
    // @JoinColumn(name = "fk_key customer", referencedColumnName = "id")
    // private Customer customer;

}
