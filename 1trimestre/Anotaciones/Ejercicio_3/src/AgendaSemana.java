import java.util.ArrayList;
import java.util.List;

@DatoTarea(
        titulo = "JavaScript",
        descripcion = "Hacer deberes de array",
        diaS = "Viernes",
        hora = "19:15"
)
@DatoTarea(
        titulo = "Java",
        descripcion = "Hacer deberes de anotaciones",
        diaS = "Jueves",
        hora = "13:35"
)
@DatoTarea(
        titulo = "HTML",
        descripcion = "Hacer deberes de formulario",
        diaS = "Sabado",
        hora = "15:12"
)


public class AgendaSemana {
    private List<Tarea> listaTarea;
    public void cargadorTareas(){
        DatoTarea[] listadatos = AgendaSemana.class.getAnnotationsByType(DatoTarea.class);

        for (DatoTarea dato : listadatos ){
            Tarea tarea;
            tarea = new Tarea(dato.titulo(),dato.descripcion(),dato.diaS(),dato.hora());
            listaTarea.add(tarea);
        }
    }
    public AgendaSemana(){
        listaTarea =new ArrayList<>();
        cargadorTareas();
    }

    @Override
    public String toString() {
        return "AgendaSemana{" +
                "tareas=" + listaTarea +
                '}';
    }
}
