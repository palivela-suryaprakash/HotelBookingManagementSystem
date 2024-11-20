package com.HotelBookingSystem.BookingManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.HotelBookingSystem.BookingManagement.dto.BookingDto;
import com.HotelBookingSystem.BookingManagement.entity.Booking;
import com.HotelBookingSystem.BookingManagement.entity.Payment;
import com.HotelBookingSystem.BookingManagement.exception.BookingNotFoundExcepion;
import com.HotelBookingSystem.BookingManagement.mappers.BookingMappers;
import com.HotelBookingSystem.BookingManagement.repository.BookingRepository;
import com.HotelBookingSystem.BookingManagement.service.inerface.BookingService;

@Service
public class BookingServiceimpl implements BookingService{
@Autowired
    private BookingRepository repo;

    @Override
    public BookingDto addBooking(BookingDto bookingDto) {
        Booking booking =  BookingMappers.BookingDtoToBooking(bookingDto);
        booking.setPayment(bookingDto.getPayment());
        if(bookingDto.getPayment()!=null)
        {   Payment payment = booking.getPayment();
            payment.setBooking(booking);
            // booking.setPayment(payment);
            
        }
        return BookingMappers.BookingToBookingDto(repo.save(booking));
    }

    @Override
    public BookingDto getBookingById(Long id) {
        Booking BB = repo.findById(id).orElseThrow(()->new BookingNotFoundExcepion("sorry message not found by Id"+id));
        return BookingMappers.BookingToBookingDto(BB);
    }

    @Override
    public BookingDto getBookingByName(String name) {
        return BookingMappers.BookingToBookingDto(repo.findByCustomerName(name));
        
    }
    public BookingDto updateBooking(Long id, BookingDto bookingDto) {
        // Retrieve the existing booking entity
        Booking existingBooking = repo.findById(id).orElseThrow(
            () -> new BookingNotFoundExcepion( "Sorry Booking not found here"+id));
    
        // Update the existing booking's fields with the new values from the DTO
        existingBooking.setCustomerName(bookingDto.getCustomerName());
        existingBooking.setRoomName(bookingDto.getRoomName());
        existingBooking.setCheckInDate(bookingDto.getCheckInDate());
        existingBooking.setCheckOutDate(bookingDto.getCheckOutDate());
        existingBooking.setBookingStatus(bookingDto.getBookingStatus());
        existingBooking.setAmountPaid(bookingDto.getAmountPaid());
    
        // Save the updated booking entity to the repository
        Booking updatedBooking = repo.save(existingBooking);
    
        // Convert the updated entity back to a DTO and return
        return BookingMappers.BookingToBookingDto(updatedBooking);
    }
    @Override
    public String deleteBooking(Long id) {
        Booking b= repo.findById(id).orElseThrow(()->  new BookingNotFoundExcepion("sorry Bookng not for delete "+id));
        repo.delete(b);
        return "succefully deleted";
    }
}
