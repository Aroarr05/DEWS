import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pila<T> implements ColeccionSimpleGenerica<T>{
    private LinkedList<T> lista;

    public Pila() {
        lista = new LinkedList<>();
    }
    @Override
    public boolean estaVacia() {
        return lista.isEmpty();
    }

    @Override
    public T extraer() {
        return lista.pollFirst();
    }

    @Override
    public T primero() {
        return lista.peekFirst();
    }

    @Override
    public void agregar(T elem) {
        lista.addFirst(elem);
    }
    @Override
    public String toString() {
        return lista.toString();
    }
}
