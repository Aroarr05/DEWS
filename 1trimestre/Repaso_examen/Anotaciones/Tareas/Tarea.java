public class Tarea {
    String nombre;
    String descripcion;
    String diaSemana;
    String horaInicio;

    public Tarea(String nombre, String descripcion, String diaSemana, String horaInicio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
    }
    @Override
    public String toString() {
        return "Nombre de la tarea: " + nombre
                + "\nDescripcion de la tarea: " + descripcion
                + "\nDia de la tarea: " + diaSemana
                + "\nHora de la tarea: " + horaInicio;
    }


}
