package com.lucasengcomp.challengepayment.domain.exceptions.controller;

import com.lucasengcomp.challengepayment.domain.exceptions.controller.messages.StandardError;
import com.lucasengcomp.challengepayment.domain.exceptions.controller.messages.ValidationError;
import com.lucasengcomp.challengepayment.domain.exceptions.service.DataBaseException;
import com.lucasengcomp.challengepayment.domain.exceptions.service.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

import static com.lucasengcomp.challengepayment.domain.exceptions.controller.messages.MessagesExceptions.*;


@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e,
                                                        HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError();
        messageError(error, status, RESOURCE_NOT_FOUND, e.getMessage(), request);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> database(DataBaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError();
        messageError(error, status, ERROR_INTEGRITY_DATA_EXCEPTION, e.getMessage(), request);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e,
                                                      HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError error = new ValidationError();
        messageError(error, status, ERROR_ARGUMENT_EXCEPTION, e.getMessage(), request);

        fieldsMethodArgumentNotValid(e, error);

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationError> constraintValidation(ConstraintViolationException e,
                                                                HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError error = new ValidationError();
        messageError(error, status, ERROR_UNPROCESABLE_ENTITY, UNPROCESABLE_ENTITY, request);

        fieldsConstraintValidations(e, error);

        return ResponseEntity.status(status).body(error);
    }

//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseEntity<StandardError> dataIntegrityViolation(DataIntegrityViolationException e, HttpServletRequest request) {
//        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
//        StandardError error = new StandardError();
//        messageError(error, status, ERROR_INTEGRITY_DATA_EXCEPTION, e.getMessage(), request);
//        return ResponseEntity.status(status).body(error);
//    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolation(DataIntegrityViolationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        StandardError error = new StandardError();

        String fieldName = extractFieldNameFromExceptionMessage(e.getMessage());

        messageError(error, status, ERROR_INTEGRITY_DATA_EXCEPTION, e.getMessage(), request, fieldName);
        return ResponseEntity.status(status).body(error);
    }

    private String extractFieldNameFromExceptionMessage(String exceptionMessage) {
        String[] parts = exceptionMessage.split("\"");
        if (parts.length > 1) {
            return parts[1];
        }
        return UNKNOWN_FIELD;
    }

    private static void fieldsConstraintValidations(ConstraintViolationException e, ValidationError error) {
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            error.addError(violation.getPropertyPath().toString(), violation.getMessage());
        }
    }

    private static void fieldsMethodArgumentNotValid(MethodArgumentNotValidException e, ValidationError error) {
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            error.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

    private void messageError(StandardError error, HttpStatus status, String databaseException,
                              String e, HttpServletRequest request) {
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError(databaseException);
        error.setPath(request.getRequestURI());
        error.setMessage(e);
    }

    private void messageError(StandardError error, HttpStatus status, String databaseException, String e,
                              HttpServletRequest request, String fieldName) {
        messageError(error, status, databaseException, e, request);
        error.setMessage(ERROR_INTEGRITY_DATA_EXCEPTION + fieldName);
    }
}
