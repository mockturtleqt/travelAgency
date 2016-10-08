package com.epam.training.second.exception;

public class WrongTourException extends Exception {
    public WrongTourException(String message) {
        super(message);
    }

    public WrongTourException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongTourException(Throwable cause) {
        super(cause);
    }
}
