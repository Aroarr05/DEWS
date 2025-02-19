import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaOrdenada<E extends Comparable<E>> {
    private ArrayList<E> lista;
    // Constructor
    public ListaOrdenada() {
        lista = new ArrayList<>();
    }
    // Añadir elemento en el orden adecuado
    public void add(E o) {
        lista.add(o);
        lista.sort(Comparable::compareTo);
    }
    // Obtener elemento por índice
    public E get(int index) {
        return lista.get(index);
    }
    // Obtener tamaño de la lista
    public int size() {
        return lista.size();
    }
    // Verificar si la lista está vacía
    public boolean isEmpty() {
        return lista.isEmpty();
    }
    // Eliminar elemento
    public boolean remove(E o) {
        return lista.remove(o);
    }
    // Obtener índice de un elemento
    public int indexOf(E o) {
        return lista.indexOf(o);
    }
    // Representación en cadena de la lista
    @Override
    public String toString() {
        return lista.toString();
    }
}
