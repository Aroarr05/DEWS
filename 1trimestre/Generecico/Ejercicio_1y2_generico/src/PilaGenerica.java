import java.util.LinkedList;

public class PilaGenerica<T> implements ColeccionSimpleGenerica<T> {
    private LinkedList<T> elementos;

    public PilaGenerica() {
        elementos = new LinkedList<>();
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public T extraer() {
        if (!estaVacia()) {
            return elementos.removeFirst();
        }
        return null;
    }

    public T primero() {
        if (!estaVacia()) {
            return elementos.getFirst();
        }
        return null;
    }

    public void aniadir(T e) {
        elementos.addFirst(e);
    }

    public String toString() {
        if (estaVacia()) {
            return "La pila está vacía.";
        } else {
            return "Elementos en la pila: " + elementos.toString();
        }
    }
}
