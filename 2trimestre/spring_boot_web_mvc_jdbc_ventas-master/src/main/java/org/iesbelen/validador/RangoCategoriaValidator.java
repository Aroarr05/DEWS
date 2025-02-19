package org.iesbelen.validador;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class RangoCategoriaValidator implements ConstraintValidator<RangoCategoria, Integer> {
    private Set<Integer> categoriasPermitidas;

    @Override
    public void initialize(final RangoCategoria constraintAnnotation) {
        categoriasPermitidas = Set.of(100,200,300,400,500,600,700,800,900,1000);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null && categoriasPermitidas.contains(value);
    }
}
