package com.example.ucakbilet.exception.occupant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OccupantRestExceptionHandler {
    // Add an exception handler for OccupantErrorResponse

    @ExceptionHandler
    public ResponseEntity<OccupantErrorResponse> handleException(OccupantNotFoundException exc) {

        // create OccupantErrorResponse

        OccupantErrorResponse error = new OccupantErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    // Add another exception handler ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<OccupantErrorResponse> handleException(Exception exc) {

        // create OccupantErrorResponse

        OccupantErrorResponse error = new OccupantErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
