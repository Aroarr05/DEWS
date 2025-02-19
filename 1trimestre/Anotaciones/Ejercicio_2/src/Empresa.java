import java.util.ArrayList;
import java.util.List;

@DirectivoNota(
        nombre = "Mengano",
        apellidos = "García",
        direccion = "Calle Falsa 1, Malaga",
        dni = "12345678A",
        telefono = "123456789",
        clase = "Directivo",
        codigoDespacho = 101
)
@TecnicoNota(
        nombre = "Mengana",
        apellidos = "Martínez",
        direccion = "Calle Falsa 2, Malaga",
        dni = "12345678B",
        telefono = "123456780",
        clase = "Tecnico",
        codigoTaller = 202,
        perfil = "Informática"
)
@OficialNota(
        nombre = "Perico",
        apellidos = "Palotes",
        direccion = "Calle Falsa 3, Malaga",
        dni = "12345678C",
        telefono = "234567890",
        clase = "Oficial",
        codigoTaller = 303,
        categoria = "B"
)
public class Empresa {

    private String nombre;
    private List<Empleado> empleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public static Empresa cargadoDirectivo(String nombre) {
        Empresa empresa = new Empresa(nombre);
        Class<Empresa> claseEmpresa = Empresa.class;

        DirectivoNota[] directivosAnotados = claseEmpresa.getDeclaredAnnotationsByType(DirectivoNota.class);

        for (DirectivoNota directivobucle : directivosAnotados) {
            Directivo directivo = new Directivo(directivobucle.nombre(),directivobucle.apellidos(), directivobucle.direccion(), directivobucle.dni(), directivobucle.telefono(), directivobucle.codigoDespacho());

            if (directivo != null) {
                empresa.empleados.add(directivo);
            }
        }
        return empresa;
    }
    public static Empresa cargadoTecnico(String nombre) {
        Empresa empresa = new Empresa(nombre);
        Class<Empresa> claseEmpresa = Empresa.class;

        TecnicoNota[] tecnicoAnotados = claseEmpresa.getDeclaredAnnotationsByType(TecnicoNota.class);

        for (TecnicoNota tecnicoNota : tecnicoAnotados) {
            Tecnico tecnico = new Tecnico(tecnicoNota.nombre(),tecnicoNota.apellidos(), tecnicoNota.direccion(), tecnicoNota.dni(), tecnicoNota.telefono(), tecnicoNota.codigoTaller(), tecnicoNota.perfil());

            if (tecnico != null) {
                empresa.empleados.add(tecnico);
            }
        }
        return empresa;
    }

    public static Empresa cargadorOficial(String nombre) {
        Empresa empresa = new Empresa(nombre);
        Class<Empresa> claseEmpresa = Empresa.class;

        OficialNota[] oficialAnotados = claseEmpresa.getDeclaredAnnotationsByType(OficialNota.class);

        for (OficialNota oficialNota : oficialAnotados) {
            Oficial oficial = new Oficial(oficialNota.nombre(),oficialNota.apellidos(), oficialNota.direccion(), oficialNota.dni(), oficialNota.telefono(), oficialNota.codigoTaller(), oficialNota.categoria());

            if (oficial != null) {
                empresa.empleados.add(oficial);
            }
        }
        return empresa;
    }

    //CARGADOR DE CONTEXTO
    public static Empresa cargadorDeContexto(String nombre) {
        Empresa empresa = new Empresa(nombre);

        // Sacamos la clase de la empresa para referirnos a ella despues
        Class<Empresa> claseEmpresa = Empresa.class;

        // Pillamos las notas en un array
        EmpleadoNota[] empleadosAnotados = claseEmpresa.getAnnotationsByType(EmpleadoNota.class);

        // Recorremos el array para procesas todas las notas que teniamos puestas
        for (EmpleadoNota e : empleadosAnotados) {
            String clase = e.clase();
            Empleado empleado = null; //lo declaramos null pa que no pete.

            // diferenciamos por clases ( clase atributo de la nota, no clase clase) para que cada
            // uno se guarde segun su clase
            switch (clase) {
                case "Directivo" -> empleado = new Directivo(e.nombre(), e.apellidos(), e.direccion(), e.dni(), e.telefono(), e.codigoDespacho());
                case "Tecnico" -> empleado = new Tecnico(e.nombre(), e.apellidos(), e.direccion(), e.dni(), e.telefono(), e.codigoTaller(), e.perfil());
                case "Oficial" -> empleado = new Oficial(e.nombre(), e.apellidos(), e.direccion(), e.dni(), e.telefono(), e.codigoTaller(), e.categoria());
                default -> System.out.println("Clase desconocida: " + clase);
            }

            if (empleado != null) { //para evitar que pese si metemos algo raro y guardamos en al lista
                empresa.empleados.add(empleado);
            }
        }
        return empresa;
    }

    @Override
    public String toString() {
        String cadena = "Empresa: "+nombre+"\n";
        for (Empleado e : empleados) {
            cadena += e.toString() + "\n";
        }
        return cadena;
    }


}
