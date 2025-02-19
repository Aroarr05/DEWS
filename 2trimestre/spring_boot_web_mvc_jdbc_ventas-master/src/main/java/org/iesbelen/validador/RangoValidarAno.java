package org.iesbelen.validador;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class RangoValidarAno implements ConstraintValidator<ValidarAno, LocalDate> {
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) return false; // O puedes permitir null
        int year = value.getYear();
        int currentYear = LocalDate.now().getYear();
        return year >= 2000 && year <= currentYear;
    }

}
