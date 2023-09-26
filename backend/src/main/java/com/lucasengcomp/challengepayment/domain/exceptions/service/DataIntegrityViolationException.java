package com.lucasengcomp.challengepayment.domain.exceptions.service;

public class DataIntegrityViolationException extends RuntimeException {

    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
