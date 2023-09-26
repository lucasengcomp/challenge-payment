package com.lucasengcomp.challengepayment.domain.exceptions.controller.messages;

public class FieldError {

    private String fieldName;
    private String message;

    public FieldError() {
    }

    public FieldError(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
