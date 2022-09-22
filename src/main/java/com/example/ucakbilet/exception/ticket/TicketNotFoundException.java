package com.example.ucakbilet.exception.ticket;

public class TicketNotFoundException extends RuntimeException{
    public TicketNotFoundException() {
        super();
    }

    public TicketNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TicketNotFoundException(String message) {
        super(message);
    }



    public TicketNotFoundException(Throwable cause) {
        super(cause);
    }

    protected TicketNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
