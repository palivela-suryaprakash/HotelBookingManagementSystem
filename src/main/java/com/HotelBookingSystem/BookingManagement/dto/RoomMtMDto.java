package com.HotelBookingSystem.BookingManagement.dto;


import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class RoomMtMDto {
        private String roomNo;
    private String roomType;
    private CustMtMDto customer;
    // private List<RoomsDto> roomList;

}
