package com.ksu.gameprofile.service.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException() {
    }
    public EntityNotFoundException(String message) {
        super(message);
    }
}
