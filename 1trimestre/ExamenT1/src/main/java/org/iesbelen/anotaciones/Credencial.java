package org.iesbelen.anotaciones;
import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Credenciales.class)
public @interface Credencial {
    String usuario();
    String hashPasswd();

}
