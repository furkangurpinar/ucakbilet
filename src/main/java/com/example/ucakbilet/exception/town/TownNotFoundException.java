package com.example.ucakbilet.exception.town;

public class TownNotFoundException extends RuntimeException{
    public TownNotFoundException() {
        super();
    }

    public TownNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TownNotFoundException(String message) {
        super(message);
    }



    public TownNotFoundException(Throwable cause) {
        super(cause);
    }

    protected TownNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
