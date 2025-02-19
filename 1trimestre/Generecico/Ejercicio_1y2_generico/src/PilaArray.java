import java.util.Arrays;

public class PilaArray <T> implements ColeccionSimpleGenerica <T> {
    private T[] pila;
    private int contador = 0;

    public PilaArray() {
        //capacidda = (capacidad <= 0) ? capacidad)
        pila = (T[]) new Object[0];
    }

    @Override
    public boolean estaVacia() {
        return pila.length == 0;
    }

    @Override
    public T extraer() {
        T elemento = pila[0];

        for (int i = 1; i < contador; i++) {
            pila[i - 1] = pila[i];
        }
        pila[--contador] = null;  // Eliminar la referencia y reducir el contador

        return elemento;
    }

    @Override
    public T primero() {
        return pila[0];
    }

    @Override
    public void aniadir(T nuevo) {
        pila = Arrays.copyOf(pila, ++contador);
        pila[pila.length - 1] = nuevo;
    }

    @Override
    public String toString() {
        String mensaje = "";

        for(int i = 0; i < pila.length - 1; i++) {
            mensaje += " " + pila[i];
        };
        return mensaje;
    }
}
