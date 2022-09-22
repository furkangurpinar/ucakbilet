package com.example.ucakbilet.exception.ticket;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TicketRestExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<TicketErrorResponse> handleException(TicketNotFoundException exc){

        TicketErrorResponse error = new TicketErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);


    }

    @ExceptionHandler
    public ResponseEntity<TicketErrorResponse> handleException(Exception exc){

        TicketErrorResponse error = new TicketErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);


    }
}
