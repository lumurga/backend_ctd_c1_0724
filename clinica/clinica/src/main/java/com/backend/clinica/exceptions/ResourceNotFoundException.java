package com.backend.clinica.exceptions;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
