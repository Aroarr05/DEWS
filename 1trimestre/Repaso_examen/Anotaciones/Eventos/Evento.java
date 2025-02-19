import  java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Eventos.class)
public @interface Evento {
    String nombre();
    String fecha();
    String ubicacion();
    String descripcion();
}
