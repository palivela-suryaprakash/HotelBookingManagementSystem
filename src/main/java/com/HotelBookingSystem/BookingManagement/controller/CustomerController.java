package com.HotelBookingSystem.BookingManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.HotelBookingSystem.BookingManagement.dto.CustMtMDto;
import com.HotelBookingSystem.BookingManagement.dto.CustomerDto;
import com.HotelBookingSystem.BookingManagement.dto.CustroomDto;
import com.HotelBookingSystem.BookingManagement.service.inerface.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/Many")
@Tag(name = "CustomerController",description = "It handle incoming HTTP requests," +
                                " manage interactions with services or databases, " +
                                "and return appropriate responses to the client ")
//@Tag
public class CustomerController {
    @Autowired
    private CustomerService serviceImpl;
    //-----------------------------CRUD----------------//
    @Operation(summary = "Creating a Customer",description = "This operation is used to create Customer")
    @ApiResponse(responseCode = "200",description = "Successfully created a Customer")
    @ApiResponse(responseCode = "500",description = "Internal server error")

    @PostMapping
    public ResponseEntity<CustomerDto> AddCustomer(@RequestBody CustomerDto customerDto){
        log.debug("Created Customer:{}", customerDto);
        CustomerDto cust = serviceImpl.AddCustomer(customerDto);
        log.info(" Customer Created Successfully:{}", cust);
        return ResponseEntity.ok(cust);
    }
    //-------------------------------------get(Read)----------------//
    @Operation(summary = "Retrieving a Customer ",description = "This operation is used to Get the customer")
    @ApiResponse(responseCode = "200",description = "Successfully Retrived Student")
    @ApiResponse(responseCode = "500",description = "Internal server error")
    @GetMapping("/getting/{id}")
    public ResponseEntity<CustomerDto> GettingCustomerId(@Valid @PathVariable( "id")Long id){
        log.debug("Retreving Customer Data :{}", id);
        CustomerDto get = serviceImpl.GettingCustomerId(id);
        log.info(" Customer  Retreved Successfully:{}", get);
        return ResponseEntity.ok(get);
    }
//--------------------------Update(Put)------------------------------------//
    @Operation(summary = "Updating a Customer ",description = "This operation is used to Update Customer")
    @ApiResponse(responseCode = "200",description = "Successfully Updated Customer")
    @ApiResponse(responseCode = "500",description = "Internal server error")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@Valid @PathVariable Long id, @RequestBody CustomerDto customerDto) {
        log.debug("Updated  Customer:{}", customerDto);
        CustomerDto s = serviceImpl.updateCustomer(id, customerDto);
        log.info(" Customer Updated  Successfully:{}", s);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }
    //-------------------Delete -----------------//
    @Operation(summary = "Deleting a Customer ",description = "This operation is used to Delete a data through id")
    @ApiResponse(responseCode = "200",description = "Successfully Deleted a Customer")
    @ApiResponse(responseCode = "500",description = "Internal server error")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@Valid @PathVariable("id") Long id){
        log.debug("Deleted Customer:{}",id);
        String delete = serviceImpl.deleteCustomerById(id);
        log.info(" Deleted  Successfully:{}", delete);
        return ResponseEntity.status(HttpStatus.OK).body(delete);
    }
        // --------------------OneToMany--------------------//
        @Operation(summary = "Creating a OneToMany  ",description = "This operation is used to create Customer along with Rooms")
        @ApiResponse(responseCode = "200",description = "Successfully created a ManyToMany Operation")
        @ApiResponse(responseCode = "500",description = "Internal server error")
        @PostMapping("/CustRoom")
        public ResponseEntity<CustroomDto> createCustRoom(@Valid @RequestBody CustroomDto custroomDto){
            log.debug("Created oneToMany Customer:{}", custroomDto);
            if(custroomDto!= null){
                CustroomDto rr = serviceImpl.createCustRoom(custroomDto);
                log.info(" Customer oneToMany Created Successfully:{}", rr);
                return ResponseEntity.status(HttpStatus.OK).body(rr);
            }
            else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }

     // ------------------------ManyToMany-------------------------//
    @Operation(summary = "Creating a MAnyToMany Customer ",description = "This operation is used to create ManyToManyOperation along with Customer and Rooms")
    @ApiResponse(responseCode = "200",description = "Successfully created a ManyToMany Operation")
    @ApiResponse(responseCode = "500",description = "Internal server error")
    @PostMapping("/custRoom")
    public ResponseEntity <CustMtMDto> assignedCustMapp(@Valid @RequestBody CustMtMDto custMtMDto ){
        log.debug("Created ManyToMany  Customer:{}",custMtMDto);
    CustMtMDto cc = serviceImpl.assignedCustMapp(custMtMDto);
    log.info("Created manyTomany Successfully:{} ", cc);
    return ResponseEntity.ok().body(cc);
    }



}


