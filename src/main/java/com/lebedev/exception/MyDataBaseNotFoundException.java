package com.lebedev.exception;

public class MyDataBaseNotFoundException extends RuntimeException{

    public MyDataBaseNotFoundException(long index) {
        super(String.format("Object with index %d not found.", index));
    }
}
