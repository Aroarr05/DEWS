import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface OficialNota{
    String nombre();
    String apellidos();
    String direccion();
    String dni();
    String telefono();
    String clase(); // "Directivo", "Tecnico", "Oficial"
    int codigoTaller() default -1;   // Para Operario y sus subclases
    String categoria() default "";   // Para Oficial
}

