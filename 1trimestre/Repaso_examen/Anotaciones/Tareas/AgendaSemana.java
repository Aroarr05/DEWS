import java.util.ArrayList;
import java.util.List;
@DatoTarea(
        nombre = "a",
        descripcion = "a",
        diaSemana = "a",
        horaInicio = "a"
)@DatoTarea(
        nombre = "b",
        descripcion = "b",
        diaSemana = "b",
        horaInicio = "b"
)@DatoTarea(
        nombre = "c",
        descripcion = "c",
        diaSemana = "c",
        horaInicio = "c"
)@DatoTarea(
        nombre = "d",
        descripcion = "d",
        diaSemana = "d",
        horaInicio = "d"
)
public class AgendaSemana {
    List<Tarea> listaTareas;
    public AgendaSemana(){
        listaTareas = new ArrayList<>();
        cargadorTareas();
    }
    public void cargadorTareas(){
        DatoTarea[] listadatos = AgendaSemana.class.getAnnotationsByType(DatoTarea.class);

        for (DatoTarea lista : listadatos){
            Tarea tarea = new Tarea(lista.nombre(), lista.descripcion(), lista.diaSemana(), lista.horaInicio());
            listaTareas.add(tarea);
        }
    }
    @Override
    public String toString() {
        return "AgendaSemana{" + "tareas=" + listaTareas + '}';
    }

}
