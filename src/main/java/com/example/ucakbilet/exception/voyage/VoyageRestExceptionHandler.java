package com.example.ucakbilet.exception.voyage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VoyageRestExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<VoyageErrorResponse> handleException(VoyageNotFoundException exc){

        VoyageErrorResponse error = new VoyageErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);


    }

    @ExceptionHandler
    public ResponseEntity<VoyageErrorResponse> handleException(Exception exc){

        VoyageErrorResponse error = new VoyageErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);


    }
}
