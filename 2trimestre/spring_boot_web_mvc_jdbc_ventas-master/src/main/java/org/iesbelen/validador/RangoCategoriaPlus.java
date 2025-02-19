package org.iesbelen.validador;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RangoCategoriaPlusValidator.class)

public @interface RangoCategoriaPlus {
    String message() default "Categoría no válida.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int[] value() default {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

}
