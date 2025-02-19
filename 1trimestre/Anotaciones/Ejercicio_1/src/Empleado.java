public class Empleado {
    // Declaración de atributos privados de la clase Empleado
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private int telefono;
    private String clase;
    private int codigoDespacho;
    private int codigoTaller;
    private String categoria;
    private String perfil;

    public Empleado(String nombre, String apellido, String dni, String direccion, int telefono,String clase,  int codigoDespacho, int codigoTaller,String categoria, String perfil) {
        // Constructor de la clase Empleado que inicializa todos los atributos
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.clase = clase;
        this.codigoDespacho = codigoDespacho;
        this.codigoTaller = codigoTaller;
        this.categoria = categoria;
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        // Método sobrescrito toString que devuelve una representación en forma de cadena del objeto Empleado
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", clase='" + clase + '\'' +
                ", codigoDespacho='" + codigoDespacho + '\'' +
                ", codigoTaller='" + codigoTaller + '\'' +
                ", categoria='" + categoria + '\'' +
                ", perfil='" + perfil + '\'' +
                '}';
    }

}
