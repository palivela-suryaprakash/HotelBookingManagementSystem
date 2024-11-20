package com.HotelBookingSystem.BookingManagement.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.HotelBookingSystem.BookingManagement.dto.CustMtMDto;
import com.HotelBookingSystem.BookingManagement.dto.CustomerDto;
import com.HotelBookingSystem.BookingManagement.dto.CustroomDto;
import com.HotelBookingSystem.BookingManagement.dto.RoomsDto;
import com.HotelBookingSystem.BookingManagement.entity.Customer;
import com.HotelBookingSystem.BookingManagement.entity.Rooms;

public class CustomerMapper {
    public static Customer CustomerDtoToCustomer(CustomerDto  customerDto){
        if(customerDto==null){
            return null;
        }
        Customer customer = new Customer();
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setEmail(customerDto.getEmail());
        customer.setAddress(customerDto.getAddress());
        return customer;

    }
    public static CustomerDto CustomerToCustmerDto(Customer customer){
        if(customer == null){
            return null;
        }
        CustomerDto cc = new CustomerDto();
        cc.setCustomerName(customer.getCustomerName());
        cc.setEmail(customer.getEmail());
        cc.setAddress(customer.getAddress());
        return cc;
    }
    // public static CustroomDto CustomerToCustroomDto(Customer customer){

    //     if(customer == null){
    //         return null;
    //     }
    //     CustroomDto custroomDto = new CustroomDto();
    //     custroomDto.setCustomerName(customer.getCustomerName());
    //     custroomDto.setEmail(customer.getEmail());
    //     custroomDto.setAddress(customer.getAddress());
    //     return custroomDto;
    // }
    public static Customer CustroomDtoToCustomer(CustroomDto custroomDto){
        if(custroomDto ==null){
            return null;

        }
        Customer ss = new Customer();
        ss.setCustomerName(custroomDto.getCustomerName());
        ss.setEmail(custroomDto.getEmail());
        ss.setAddress(custroomDto.getAddress());
        List<Rooms> rooms = new ArrayList<>();
        for(RoomsDto roomDto:custroomDto.getRoomList()){
        Rooms rr = new Rooms();
        rr.setRoomNo(roomDto.getRoomNo());
    }
    ss.setRoomsList(rooms);
        return ss;
    }
//------------------ManyToMany-----------------//
    public static Customer CustMtMDtoToCustomer(CustMtMDto custMtMDto) {
        Customer customer = new Customer();
        customer.setCustomerName(custMtMDto.getCustomerName());
        customer.setEmail(custMtMDto.getEmail());
        customer.setAddress(custMtMDto.getAddress());
        customer.setAssignedRooms(
            custMtMDto.getAssignedRooms().stream()
                .map(RoomsMapper::RoomMtMDtoToRooms)
                .collect(Collectors.toList())
        );
        return customer;
    }

    public static CustMtMDto CustomerToCustMtMDto(Customer customer) {
        CustMtMDto dto = new CustMtMDto();
        dto.setCustomerName(customer.getCustomerName());
        dto.setEmail(customer.getEmail());
        dto.setAddress(customer.getAddress());
        dto.setAssignedRooms(
            customer.getAssignedRooms().stream()
                .map(RoomsMapper::RoomsToRoomMtMDto)
                .collect(Collectors.toList())
        );
        return dto;
    }

    // public static Customer CustMtMDtoToCustomer(CustMtMDto custMtMDto) {
    //     Customer  customer = new Customer();
    //     customer.setCustomerName(custMtMDto.getCustomerName());
    //     customer.setEmail(custMtMDto.getEmail());
    //     customer.setAddress(custMtMDto.getAddress());
    //     //----------//
    //     List<Rooms> rooms = new ArrayList<>();
    //     for(RoomMtMDto roomDto:custMtMDto.getAssignedRooms()){
    //     Rooms rr = new Rooms();
    //     rr.setRoomNo(roomDto.getRoomNo());
    // }


    //     List<Rooms> roomList = new ArrayList<>();
    //     for (RoomMtMDto roomMtMDto : custMtMDto.getAssignedRooms()) {
    //         Rooms r = new Rooms();
    //         RoomsMapper.RoomsToRoomMtMDto(r);
    //     }
    //     custMtMDto.setAs(teachersList.toString());
    // customer.setRoomsList(rooms);
    //     return customer;
    // }

}
