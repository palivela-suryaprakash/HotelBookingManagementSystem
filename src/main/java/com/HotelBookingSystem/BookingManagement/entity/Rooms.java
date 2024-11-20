package com.HotelBookingSystem.BookingManagement.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String roomNo;
    private String roomType;
    @ManyToOne
    @JoinColumn(name = "fk-key", referencedColumnName = "id")
    private Customer customer;
    

        @ManyToMany(mappedBy = "assignedRooms", fetch = FetchType.LAZY)
    private List<Customer> customerlist = new ArrayList<>();

}
