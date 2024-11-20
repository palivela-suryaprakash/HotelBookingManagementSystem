package com.HotelBookingSystem.BookingManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.HotelBookingSystem.BookingManagement.dto.CustMtMDto;
import com.HotelBookingSystem.BookingManagement.dto.CustomerDto;
import com.HotelBookingSystem.BookingManagement.dto.CustroomDto;
import com.HotelBookingSystem.BookingManagement.dto.RoomsDto;
import com.HotelBookingSystem.BookingManagement.entity.Customer;
import com.HotelBookingSystem.BookingManagement.entity.Rooms;
import com.HotelBookingSystem.BookingManagement.exception.CustomerNotFoundException;
import com.HotelBookingSystem.BookingManagement.mappers.CustomerMapper;
import com.HotelBookingSystem.BookingManagement.mappers.RoomsMapper;
import com.HotelBookingSystem.BookingManagement.repository.CustomerRepository;
import com.HotelBookingSystem.BookingManagement.repository.RoomsRepository;
import com.HotelBookingSystem.BookingManagement.service.inerface.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repos;
    @Autowired
    private RoomsRepository rospo;

    @Override
    public CustomerDto AddCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.CustomerDtoToCustomer(customerDto);
        return CustomerMapper.CustomerToCustmerDto(repos.save(customer));
    
    }
//  -----------------------OneToMany-----------------------------------------//
    @Override
    public CustroomDto createCustRoom(CustroomDto custroomDto) {
        Customer c1 = CustomerMapper.CustroomDtoToCustomer(custroomDto);
        Customer c2 = repos.save(c1);
        List<Rooms> rom = new ArrayList<>();
        for(RoomsDto roomsDto:custroomDto.getRoomList()){
            Rooms rl = new Rooms();
            rl.setRoomNo(roomsDto.getRoomNo());
            rl.setRoomType(roomsDto.getRoomType());
            rl.setCustomer(c2);
            rom.add(rospo.save(rl));
        }
        c1.setRoomsList(rom);
        repos.save(c1);
        return custroomDto;
    
    }
    @Override
    public CustomerDto GettingCustomerId(Long id) {
        
    Customer cc =  repos.findById(id).orElseThrow(()-> new CustomerNotFoundException("Sorry The refered id not found"+id));
        return CustomerMapper.CustomerToCustmerDto(cc);
    }
    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        
        Customer existingCustomer =  repos.findById(id).orElseThrow(
        () -> new CustomerNotFoundException("sorry id not fund by"+id));
            existingCustomer.setCustomerName(customerDto.getCustomerName());
            existingCustomer.setEmail(customerDto.getEmail());
            existingCustomer.setAddress(customerDto.getAddress());
            Customer updatedCustomer = repos.save(existingCustomer);
            return CustomerMapper.CustomerToCustmerDto(updatedCustomer);
        }
    @Override
    public String deleteCustomerById(Long id) {
        Customer cs = repos.findById(id).orElseThrow(()-> new CustomerNotFoundException("Sorry not found by id is"+id));
        repos.delete(cs);
        return "Successfully deleted";

    }

    //---------------------ManyToMany-----------------------//
    @Override
    public CustMtMDto assignedCustMapp(CustMtMDto custMtMDto) {

         // Map DTO to Customer entity
        Customer customer = CustomerMapper.CustMtMDtoToCustomer(custMtMDto);

        // Fetch or save rooms based on the DTO data
        List<Rooms> rooms = custMtMDto.getAssignedRooms().stream().map(roomDto -> {
            Rooms room = RoomsMapper.RoomMtMDtoToRooms(roomDto);
            room.getCustomerlist().add(customer);  // Maintain bidirectional relationship
            return rospo.save(room);     // Save room in the database
        }).collect(Collectors.toList());

        // Set the rooms list for the customer
        customer.setAssignedRooms(rooms);

        // Save customer to the database
        Customer savedCustomer = repos.save(customer);

        // Map saved entity back to DTO
        return CustomerMapper.CustomerToCustMtMDto(savedCustomer);
    }
}


