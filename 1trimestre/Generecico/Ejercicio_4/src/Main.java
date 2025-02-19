package Ejercicio_4.src;

public class Main {
    public static void main(String[] args) {
        int contador = 0;

        MatrizGenerica<Integer> matriz = new MatrizGenerica<>(4,2);
        for (int i = 0; i < matriz.filas(); i++) {
            for (int j = 0; j < matriz.columnas(); j++) {
                matriz.set(i,j, contador++);
            }
        }
        System.out.println(matriz.toString());
        System.out.println(matriz.get(1,2));
    }
}