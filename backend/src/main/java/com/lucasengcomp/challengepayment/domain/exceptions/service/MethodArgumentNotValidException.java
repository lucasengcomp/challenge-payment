package com.lucasengcomp.challengepayment.domain.exceptions.service;

public class MethodArgumentNotValidException extends RuntimeException {

    public MethodArgumentNotValidException(String message) {
        super(message);
    }
}
