package org.example.Exceptions;

public class BookingFullException extends RuntimeException {
    public BookingFullException() {
        super();
    }

    public BookingFullException(String message) {
        super(message);
    }
}

