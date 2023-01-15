package com.coviddata.solution.exception;

public class InvalidCountryCodeException extends CustomRuntimeException{
    public InvalidCountryCodeException() {
        super("There is no such country code!");
    }
}
