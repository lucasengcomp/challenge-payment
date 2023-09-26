package com.lucasengcomp.challengepayment.domain.exceptions.service;

public class ConstraintViolationException extends RuntimeException {

    public ConstraintViolationException(String message) {
        super(message);
    }
}
