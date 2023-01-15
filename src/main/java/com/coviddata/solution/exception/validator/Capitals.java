package com.coviddata.solution.exception.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = CapitalsValidator.class)
public @interface Capitals {
    String message() default "Between 2 and 3 CAPITAL LETTERS are allowed only!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}