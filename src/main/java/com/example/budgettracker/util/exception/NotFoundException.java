package com.example.budgettracker.util.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(int id) {
        super("Not found entity with id " + id);
    }
}
