package com.lucasengcomp.challengepayment.domain.exceptions.service;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
