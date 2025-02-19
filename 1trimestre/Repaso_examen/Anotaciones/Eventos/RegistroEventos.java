import java.util.ArrayList;
import java.util.List;

@Evento(
        nombre = "a",
        fecha = "a",
        ubicacion = "a",
        descripcion = "a"
)
@Evento(
        nombre = "c",
        fecha = "c",
        ubicacion = "c",
        descripcion = "c"
)
@Evento(
        nombre = "b",
        fecha = "b",
        ubicacion = "b",
        descripcion = "b"
)
public class RegistroEventos {
    List<EventoDato> listaeventos;

    // Constructor que carga los eventos
    public RegistroEventos() {
        listaeventos = new ArrayList<>();
        cargadorEvento();
    }

    // Método que carga los eventos anotados
    public void cargadorEvento() {
        Evento[] eventos = RegistroEventos.class.getAnnotationsByType(Evento.class);

        for (Evento evento : eventos) {
            EventoDato eventoDato = new EventoDato(
                    evento.nombre(),
                    evento.fecha(),
                    evento.ubicacion(),
                    evento.descripcion()
            );
            listaeventos.add(eventoDato);
        }
    }

    // Método toString separado
    @Override
    public String toString() {
        return "RegistroEventos{" + "eventos=" + listaeventos + '}';
    }
}
