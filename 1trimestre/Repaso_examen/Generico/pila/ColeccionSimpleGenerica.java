public interface ColeccionSimpleGenerica<T> {
    boolean estaVacia();
    T extraer();
    T primero();
    void agregar(T elem);
}
