package com.example.ucakbilet.exception.airplane;

public class AirplaneNotFoundException extends RuntimeException{
    public AirplaneNotFoundException() {
        super();
    }

    public AirplaneNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AirplaneNotFoundException(String message) {
        super(message);
    }



    public AirplaneNotFoundException(Throwable cause) {
        super(cause);
    }

    protected AirplaneNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
