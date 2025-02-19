package org.iesbelen.anotaciones;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Credenciales {
    Credencial[] value();
}
