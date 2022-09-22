package com.example.ucakbilet.exception.passenger;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PassengerRestExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<PassengerErrorResponse> handleException(PassengerNotFoundException exc){

        PassengerErrorResponse error = new PassengerErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);


    }
    @ExceptionHandler
    private ResponseEntity<PassengerErrorResponse> handleException(Exception exc){
        PassengerErrorResponse error = new PassengerErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

}
