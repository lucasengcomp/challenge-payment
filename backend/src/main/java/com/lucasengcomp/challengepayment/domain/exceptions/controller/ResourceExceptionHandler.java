package com.lucasengcomp.challengepayment.domain.exceptions.controller;


import com.lucasengcomp.challengepayment.domain.exceptions.controller.messages.StandardError;
import com.lucasengcomp.challengepayment.domain.exceptions.service.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

import static com.lucasengcomp.challengepayment.application.util.Messages.ENTITY_DOES_NOT_EXISTS;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        StandardError error = new StandardError();
        HttpStatus status = messageError(request, error, HttpStatus.NOT_FOUND, ENTITY_DOES_NOT_EXISTS, e.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    private HttpStatus messageError(HttpServletRequest request, StandardError error,
                                    HttpStatus httpStatus, String internalMessage, String message) {
        error.setTimestamp(Instant.now());
        error.setStatus(httpStatus.value());
        error.setError(internalMessage);
        error.setMesssage(message);
        error.setPath(request.getRequestURI());
        return httpStatus;
    }
}
