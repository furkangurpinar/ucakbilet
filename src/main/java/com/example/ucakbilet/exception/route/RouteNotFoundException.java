package com.example.ucakbilet.exception.route;

public class RouteNotFoundException extends RuntimeException{
    public RouteNotFoundException() {
        super();
    }

    public RouteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RouteNotFoundException(String message) {
        super(message);
    }



    public RouteNotFoundException(Throwable cause) {
        super(cause);
    }

    protected RouteNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
