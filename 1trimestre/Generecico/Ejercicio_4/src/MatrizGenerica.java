package Ejercicio_4.src;

public class MatrizGenerica<T> {
    private int filas;
    private int columnas;
    private T[][] matriz;

    public MatrizGenerica(int filas, int columnas) { //Constructor de la clase paar grear una matriz que contenga las filas y las colunas de que yo quuiera
        this.filas = filas;
        this.columnas = columnas;
        matriz = (T[][]) new Object[filas][columnas];
    }

    //Crear metodo set en que te inserta el elemento que le pasemos en la posicion indicada
    public void set(int fila, int columna, T elemento) {
        matriz[fila][columna] = elemento;
    }

    //Crear metodo get en que te devuelve el elemento en la posicion indicada
    public T get(int fila, int columna) {
        return matriz[fila -1][columna -1];
    }
    //Te devuelve el nuemro de columnas
    public int columnas() {
        return columnas;
    }
    //Te devuleve el numero de dilas
    public int filas() {
        return filas;
    }

    //Cuando utilicemos el .toString te mostrara la matriz de la forma en la que lo hemos puesto en el metodo
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sb.append(matriz[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
