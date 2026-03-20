package com.andresleon.spring_web_de_cero_a_experto.common.exception;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ErrorMessage {
    private String error;
    private String exception;
    private String path;
    private Map<String, String> errors;

    public ErrorMessage(String error, String exception, String path) {
        this.error = error;
        this.exception = exception;
        this.path = path;
        this.errors = new HashMap<>();
    }

    public ErrorMessage(String error, String exception, String path, Map<String, String> errors) {
        this.error = error;
        this.exception = exception;
        this.path = path;
        this.errors = errors;
    }
}
