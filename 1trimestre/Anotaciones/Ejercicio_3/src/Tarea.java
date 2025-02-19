public class Tarea {
    private String titulo;
    private String descripcion;
    private String diaS;
    private String hora;

    public Tarea(String titulo, String descripcion, String diaS, String hora) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.diaS = diaS;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "tituloTarea='" + titulo + '\n' +
                ", descripcionTarea='" + descripcion + '\n' +
                ", diaSemana='" + diaS + '\n' +
                ", hora='" + hora + '\n' +
                '}';
    }
}
