public class EventoDato {
    String nombre;
    String fecha;
    String ubicacion;
    String descripcion;
    public EventoDato(String nombre, String fecha, String ubicacion, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        return nombre + " " + fecha + " " + ubicacion + " " + descripcion;
    }

}
