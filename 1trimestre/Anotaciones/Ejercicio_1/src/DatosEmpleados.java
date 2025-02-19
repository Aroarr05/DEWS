import  java.lang.annotation.*;

//Crear la anotacion
@Documented //Indica que lo que se introduce aparece en JavaDoc
@Inherited //Indica que la anotaciones son heredas por sus subclases
@Target(ElementType.TYPE) //Indica dodnde se puede utilizar esta anotacion
@Retention(RetentionPolicy.RUNTIME) //Indica que la notacion que se utilice se debe retener en tiempo de ejecucion
@Repeatable(Empleados.class)
public @interface DatosEmpleados{
    // Definición de los elementos (campos) que esta anotación contendrá
    String nombre();
    String apellido();
    String dni();
    String direccion();
    int telefono();
    String clase();
    int codigoDespacho();
    int codigoTaller();
    String categoria();
    String perfil();


}