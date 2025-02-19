import java.util.Arrays;

public class PilaArray<T> implements ColeccionSimpleGenerica<T> {
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public PilaArray(int capacidad) {
        array = (T[]) new Object[capacidad];
        size = 0;
    }

    @Override
    public boolean estaVacia() {
        return size == 0;
    }

    @Override
    public T extraer() {
        if (estaVacia()) {
            return null; // o puedes lanzar una excepción si prefieres
        }
        T elemento = array[size - 1];
        array[size - 1] = null; // limpiar referencia
        size--;
        return elemento;
    }

    @Override
    public T primero() {
        if (estaVacia()) {
            return null; // o lanzar excepción
        }
        return array[size - 1];
    }

    @Override
    public void agregar(T e) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2); // redimensionar si es necesario
        }
        array[size] = e;
        size++;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array, 0, size));
    }
}
