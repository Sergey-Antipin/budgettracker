package com.example.budgettracker.util.exception;

public class EntityAccessException extends RuntimeException {

    public EntityAccessException(String message) {
        super(message);
    }

    public EntityAccessException(int entityId, int ownerId) {
        super("Entity with id " + entityId + " doesn't belong to entity with id " + ownerId);
    }
}
