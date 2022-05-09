package com.lebedev.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(long id) {
        super("Could not find employee " + id);
    }
    public UserNotFoundException(String message, long id) {
        super(message + ": Could not find employee " + id);
    }
}
