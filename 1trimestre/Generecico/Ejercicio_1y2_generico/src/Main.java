// Main.java
public class Main {
    public static void main(String[] args) {
        // Crear una pila de números enteros
        PilaGenerica<Integer> pilaNumero = new PilaGenerica<>();

        // Añadir elementos a la pilaGenerica
        pilaNumero.aniadir(10);
        pilaNumero.aniadir(20);
        pilaNumero.aniadir(30);
        pilaNumero.aniadir(40);

        //Dice si la pila esta vacia
        if(pilaNumero.estaVacia()){
            System.out.println("La pila esta vacia");
        }else {
            System.out.println("La pila esta llena");
        }

        // Mostrar el contenido de la pila
        System.out.println(pilaNumero);

        // Extraer un elemento y mostrar la pila de nuevo
        System.out.println("Elemento extraído: " + pilaNumero.extraer());
        System.out.println(pilaNumero.toString());

        // Ver el primer elemento sin eliminarlo
        System.out.println("Primer elemento: " + pilaNumero.primero());

        // Vaciar la pila y mostrar su estado
        System.out.println(pilaNumero.toString());

        PilaArray<Integer> pilaArray = new PilaArray<Integer>();

    // Añadir elementos a la pilaArray
        pilaArray.aniadir(2);
        pilaArray.aniadir(3);
        pilaArray.aniadir(4);

        //Dice si la pila esta vacia
        if(pilaArray.estaVacia()){
            System.out.println("La pila esta vacia");
        }else {
            System.out.println("La pila esta llena");
        }

        System.out.println("Elemento extraído: " + pilaArray.extraer());

        System.out.println(pilaArray.toString());


    }
}
