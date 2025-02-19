public class Empleado {
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected String dni;
    protected String telefono;

    public Empleado(String nombre, String apellido, String direccion, String dni, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: " + nombre + "\n");
        sb.append("Apellido: " + apellido + "\n");
        sb.append("Direccion: " + direccion + "\n");
        sb.append("DNI: " + dni + "\n");
        sb.append("Telefono: " + telefono + "\n");
        return sb.toString();
    }
}
