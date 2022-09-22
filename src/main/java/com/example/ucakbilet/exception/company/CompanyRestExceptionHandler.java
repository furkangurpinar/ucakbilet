package com.example.ucakbilet.exception.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CompanyRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CompanyErrorResponse> handleException(CompanyNotFoundException exc){

        CompanyErrorResponse error = new CompanyErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);


    }

    @ExceptionHandler
    public ResponseEntity<CompanyErrorResponse> handleException(Exception exc){

        CompanyErrorResponse error = new CompanyErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);


    }


}
