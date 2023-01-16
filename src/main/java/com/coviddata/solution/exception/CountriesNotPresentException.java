package com.coviddata.solution.exception;

public class CountriesNotPresentException extends CustomRuntimeException{
    public CountriesNotPresentException() {
        super("Service not available!");
    }
}
