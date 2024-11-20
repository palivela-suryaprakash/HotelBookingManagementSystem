package com.HotelBookingSystem.BookingManagement.service.inerface;

import com.HotelBookingSystem.BookingManagement.dto.CustMtMDto;
import com.HotelBookingSystem.BookingManagement.dto.CustomerDto;
import com.HotelBookingSystem.BookingManagement.dto.CustroomDto;

public interface CustomerService {

    CustomerDto AddCustomer(CustomerDto customerDto);

    CustroomDto createCustRoom(CustroomDto custroomDto);

    CustomerDto GettingCustomerId(Long id);

    CustomerDto updateCustomer(Long id, CustomerDto customerDto);

	String deleteCustomerById(Long id);

    CustMtMDto assignedCustMapp(CustMtMDto custMtMDto);



}
