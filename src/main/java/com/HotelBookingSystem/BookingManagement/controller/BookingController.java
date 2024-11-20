package com.HotelBookingSystem.BookingManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelBookingSystem.BookingManagement.dto.BookingDto;
import com.HotelBookingSystem.BookingManagement.service.BookingServiceimpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/Surya")
@Tag(name = "BookingController",description = "It handle incoming HTTP requests," +
                                " manage interactions with services or databases, " +
                                "and return appropriate responses to the client ")

public class BookingController {
    @Autowired
    private BookingServiceimpl bookservice;

//-----------------------OneToOne--------------------//
@Operation(summary = "Creating a Booking ",description = "This operation is used to create Booking ")
@ApiResponse(responseCode = "200",description = "Successfully created a Booking ")
@ApiResponse(responseCode = "500",description = "Internal server error")

    @PostMapping("/adding")
    public ResponseEntity<BookingDto > addBooking(@Valid @RequestBody BookingDto bookingDto){
        log.info("Created Booking:{}", bookingDto);
        BookingDto savedbooking = bookservice.addBooking(bookingDto);
        log.info("Student Created Successfully",savedbooking);
        return ResponseEntity.ok(savedbooking);
    }
    //----------------------------get mapping-------------//
@Operation(summary = "Retriving a booking ",description = "This operation is used to get Booking details")
@ApiResponse(responseCode = "200",description = "Successfully created a Booking")
@ApiResponse(responseCode = "500",description = "Internal server error")

    @GetMapping("/getting/{id}")
    public ResponseEntity<BookingDto> getBookingById(@Valid @PathVariable Long id){
        log.info("Retriving booking details fromm id:{}", id);
        BookingDto bookById = bookservice.getBookingById(id);
        return ResponseEntity.ok(bookById);
    }
    
@Operation(summary = "Creating a Student ",description = "This operation is used to create Student")
@ApiResponse(responseCode = "200",description = "Successfully created a student")
@ApiResponse(responseCode = "500",description = "Internal server error")

    // getting by using customer name;
    @GetMapping("/adding/{customerName}")
    public ResponseEntity<BookingDto>getBookingByName(@Valid @PathVariable("customerName")String name){
        log.debug("Retriving booking details from Name:{}", name);
        BookingDto bookByname = bookservice.getBookingByName(name);
        return ResponseEntity.ok(bookByname);
    }
    //------------------------Update (put)--------------------//
    @Operation(summary = "updating a Booking Name",description = "This operation is used to Upate Booking ")
    @ApiResponse(responseCode = "200",description = "Successfully Updated a Booking")
    @ApiResponse(responseCode = "500",description = "Internal server error")

    @PutMapping("updateBooking/{id}")
    public ResponseEntity<BookingDto> updateBooking(@Valid @PathVariable Long id, @RequestBody BookingDto booking){
        log.debug("Updating Booking details from id:{}"+id);
        BookingDto updateBooking = bookservice.updateBooking(id,booking);
        log.info("Booking updated Successfully:{}", updateBooking);
        return ResponseEntity.ok(updateBooking);
        // return  ResponseEntity<>(updateBooking,HttpStatus.OK);
    }
    //------------------------Delete------------------------------//
@Operation(summary = "Delete a Booking ",description = "This operation is used to delete all details of Booking")
@ApiResponse(responseCode = "200",description = "Successfully Deleted Booking")
@ApiResponse(responseCode = "500",description = "Internal server error")

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@Valid @PathVariable("id") Long  id){
        log.debug("Deleting Booking with ID: {}", id);
    String delete =  bookservice.deleteBooking(id);
    log.info("Student deleted successfully: {}", delete);
        return ResponseEntity.ok().body(delete);
    }


}
