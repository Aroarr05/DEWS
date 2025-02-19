import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DirectivoNota {
    String nombre();
    String apellidos();
    String direccion();
    String dni();
    String telefono();
    String clase(); // "Directivo", "Tecnico", "Oficial"
    int codigoDespacho() default -1; // Para Directivo
}

