package com.coviddata.solution.exception;

public abstract class CustomRuntimeException extends RuntimeException {
    protected CustomRuntimeException(String message) {
        super(message);
    }
}
