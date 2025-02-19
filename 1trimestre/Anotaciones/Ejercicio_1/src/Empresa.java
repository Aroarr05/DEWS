import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.List;

@DatosEmpleados(
        nombre="Amancio",
        apellido="Ortega",
        dni="66554433F",
        direccion = "AV.DIPUTACION S/N, P.I. SABON 15142, ARTEIXO, LA CORUÑA",
        telefono = 981185596,
        clase="Directivo",
        codigoDespacho = 1,
        codigoTaller = -1,
        categoria = "",
        perfil = ""
)@DatosEmpleados(
        nombre="Aroa",
        apellido="Rivas",
        dni="25615732B",
        telefono = 639302281,
        direccion = "AV. JOSE ORTEGA Y GASSET, N 133",
        clase="Tecnico",
        codigoDespacho = -1,
        codigoTaller = 1,
        categoria = "",
        perfil = "Formal"

)@DatosEmpleados(
        nombre="Zahira",
        apellido="Rivas",
        dni="25615733N",
        telefono = 626501399,
        direccion = "AV. JOSE ORTEGA Y GASSET, N 133",
        clase="Oficial",
        codigoDespacho = -1,
        codigoTaller = 2,
        categoria = "Aplicaciones",
        perfil = ""

)

public class Empresa {
    private String nombre;
    private List<Empleado> empleadosEmpresa; // Lista en lugar de array para mayor flexibilidad

    // Constructor que inicializa el nombre y la lista de empleados
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleadosEmpresa = new ArrayList<>();
    }

    // Método para agregar empleados a la empresa
    public void agregarEmpleado(Empleado empleado) {
        empleadosEmpresa.add(empleado);
    }

    // Método toString para imprimir todos los empleados de la empresa
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Empresa: " + nombre + "\nEmpleados:\n");
        for (Empleado empleado : empleadosEmpresa) {
            sb.append(empleado.toString()).append("\n");
        }
        return sb.toString();
    }

    // Método estático que carga los empleados de las anotaciones
    public static Empresa cargadorDeContexto() {
        // Crear la instancia de Empresa
        Empresa empresa = new Empresa("Mi Empresa");

        // Usar reflexión para leer anotaciones de la clase EmpresaConfig
        if (Empresa.class.isAnnotationPresent(Empleados.class)) {
            Empleados empleadosAnotaciones = Empresa.class.getAnnotation(Empleados.class);

            // Procesar cada anotación @Empleado y crear objetos Empleado
            for (DatosEmpleados empleadoAnotacion : empleadosAnotaciones.value()) {
                Empleado empleado = new Empleado(
                        empleadoAnotacion.nombre(),
                        empleadoAnotacion.apellido(),
                        empleadoAnotacion.dni(),
                        empleadoAnotacion.direccion(),
                        empleadoAnotacion.telefono(),
                        empleadoAnotacion.clase(),
                        empleadoAnotacion.codigoDespacho(),
                        empleadoAnotacion.codigoTaller(),
                        empleadoAnotacion.categoria(),
                        empleadoAnotacion.perfil()
                );
                empresa.agregarEmpleado(empleado); // Agregar empleado a la empresa
            }
        }

        return empresa; // Retornar la empresa con los empleados cargados
    }
}