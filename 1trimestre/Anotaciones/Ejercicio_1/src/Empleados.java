import java.lang.annotation.*;

//Crear la anotacion
@Documented //Indica que lo que se introduce aparece en JavaDoc
@Inherited //Indica que la anotaciones son heredas por sus subclases
@Target(ElementType.TYPE) //Indica dodnde se puede utilizar esta anotacion
@Retention(RetentionPolicy.RUNTIME) //Indica que la notacion que se utilice se debe retener en tiempo de ejecucion
public @interface Empleados {
    DatosEmpleados[] value(); // Define un arreglo de DatosEmpleados para permitir el uso de varias anotaciones @DatosEmpleados en la misma clase.
}
