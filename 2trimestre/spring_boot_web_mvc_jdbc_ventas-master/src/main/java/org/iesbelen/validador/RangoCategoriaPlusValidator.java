package org.iesbelen.validador;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class RangoCategoriaPlusValidator implements ConstraintValidator<RangoCategoriaPlus, Integer> {

    private int[] categoriasPermitidas;

    @Override
    public void initialize(final RangoCategoriaPlus constraintAnnotation) {
        categoriasPermitidas = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
       return value != null && Arrays.stream(categoriasPermitidas).anyMatch(c-> c == value);
    }
}
