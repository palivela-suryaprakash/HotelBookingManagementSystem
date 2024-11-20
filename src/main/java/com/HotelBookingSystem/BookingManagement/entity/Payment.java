package com.HotelBookingSystem.BookingManagement.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
        @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String paymentDate;
    private String paymentType;
    private String paymentStatus;
    private String paymentAmount;


    @OneToOne
    @JoinColumn(name = "fkBooking_id", referencedColumnName = "id")
    @JsonBackReference
    private Booking booking;

}
