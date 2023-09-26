package com.lucasengcomp.challengepayment.domain.exceptions.controller.messages;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldError> fieldErrors = new ArrayList<>();

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public void addError(String fieldName, String message) {
        FieldError fieldError = new FieldError(fieldName, message);
        getFieldErrors().add(fieldError);
    }
}
