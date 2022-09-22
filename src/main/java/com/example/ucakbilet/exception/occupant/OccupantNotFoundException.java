package com.example.ucakbilet.exception.occupant;

public class OccupantNotFoundException extends RuntimeException{

    public OccupantNotFoundException() {
    }

    public OccupantNotFoundException(String message) {
        super(message);
    }
    public OccupantNotFoundException(Throwable cause){
        super(cause);
    }


    public OccupantNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OccupantNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
