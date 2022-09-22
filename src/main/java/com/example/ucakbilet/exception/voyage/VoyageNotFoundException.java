package com.example.ucakbilet.exception.voyage;

public class VoyageNotFoundException extends RuntimeException{
    public VoyageNotFoundException() {
        super();
    }

    public VoyageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VoyageNotFoundException(String message) {
        super(message);
    }



    public VoyageNotFoundException(Throwable cause) {
        super(cause);
    }

    protected VoyageNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
