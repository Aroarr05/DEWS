import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(EmpleadosNota.class)
public @interface EmpleadoNota {
    String nombre();
    String apellidos();
    String direccion();
    String dni();
    String telefono();
    String clase(); // "Directivo", "Tecnico", "Oficial"
    int codigoDespacho() default -1; // Para Directivo
    int codigoTaller() default -1;   // Para Operario y sus subclases
    String perfil() default "";      // Para Técnico
    String categoria() default "";   // Para Oficial
}

