package com.coviddata.solution.exception;

public class CountryCodeNotFoundException extends CustomRuntimeException{
    public CountryCodeNotFoundException() {
        super("Country code not found!");
    }
}
