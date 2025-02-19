import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TecnicoNota {
    String nombre();
    String apellidos();
    String direccion();
    String dni();
    String telefono();
    String clase(); // "Directivo", "Tecnico", "Oficial"
    int codigoTaller() default -1;   // Para Operario y sus subclases
    String perfil() default "";      // Para Técnico
}

