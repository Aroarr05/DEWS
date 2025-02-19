import java.lang.annotation.*;


@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(DatosTarea.class)
public @interface DatoTarea {
    String nombre();
    String descripcion();
    String diaSemana();
    String horaInicio();

}
