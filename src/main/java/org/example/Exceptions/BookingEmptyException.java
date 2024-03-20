package org.example.Exceptions;

public class BookingEmptyException extends RuntimeException {
    public BookingEmptyException() {
        super();
    }

    public BookingEmptyException(String message) {
        super(message);
    }
}
