import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(DatosTarea.class)
public @interface DatoTarea{
    String titulo() default "";
    String descripcion() default "";
    String diaS() default "";
    String hora() default "";

}