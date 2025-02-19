import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Productos.class)
public @interface Producto {
    String nombre();
    double precio();
    String categoria();
    int cantidad();
}
