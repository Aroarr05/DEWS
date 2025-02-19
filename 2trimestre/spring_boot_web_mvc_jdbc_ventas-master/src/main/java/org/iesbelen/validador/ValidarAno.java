package org.iesbelen.validador;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RangoValidarAno.class)

public @interface ValidarAno {
    String message() default "ValidarAno message";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
