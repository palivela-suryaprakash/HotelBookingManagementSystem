package com.HotelBookingSystem.BookingManagement.exception;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler  {
    //-------------------For Validations----------------------------//
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> validationerrormessage = new HashMap<String, String>();
        List<ObjectError> validationerrolist = ex.getBindingResult().getAllErrors();

        validationerrolist.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String validationMsg = error.getDefaultMessage();
            validationerrormessage.put(fieldName, validationMsg);
        });

        return new ResponseEntity<>(validationerrormessage, HttpStatus.BAD_REQUEST);

    }
    //--------------Custom Exception-------------//
    @ExceptionHandler(BookingNotFoundExcepion.class)
    public ResponseEntity<String> BookingException(BookingNotFoundExcepion exception){
        return  new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> CustomerException(CustomerNotFoundException exception){
        return  new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<String> PaymentException(PaymentNotFoundException exception){
        return  new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }

        @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex) {
        log.error("Error occurred: {}", ex.getMessage(), ex);
        return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
    }


}
