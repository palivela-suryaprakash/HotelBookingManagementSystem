package com.HotelBookingSystem.BookingManagement.entity;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String customerName;
    private String email;
    private String address;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Rooms> roomsList;

    @ManyToMany( fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable( name ="course_Rooms", 
    joinColumns = {
        @JoinColumn(name = "Customer_Id", referencedColumnName = "id")
    },
    inverseJoinColumns = {
        @JoinColumn(name = "Room_Id",referencedColumnName = "id")
    }
    )
    private List<Rooms> assignedRooms;





}
