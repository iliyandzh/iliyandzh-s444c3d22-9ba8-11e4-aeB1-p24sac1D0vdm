package com.coviddata.solution.exception.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CapitalsValidator implements ConstraintValidator<Capitals, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("^[A-Z]{2,3}$");
    }
}
