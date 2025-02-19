import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PilaTest {

    private Pila<Integer> pilaLinkedList;
    private PilaArray<Integer> pilaArrayList;

    @BeforeEach
    public void setUp() {
        pilaLinkedList = new Pila<>();
        pilaArrayList = new PilaArray<>(5);
    }

    @Test
    public void testPila() {
        assertTrue(pilaLinkedList.estaVacia(), "La pila deberia estar vacia");

        pilaLinkedList.agregar(10);
        pilaLinkedList.agregar(20);
        pilaLinkedList.agregar(30);

        assertEquals(30, pilaLinkedList.primero(), "El primer elemento que se debe de mostrar es el 30");
        assertEquals(30, pilaLinkedList.extraer(), "El primer elemento que se debe de extraer es el 30");
        assertEquals(20, pilaLinkedList.primero(), "El primer elemento que se debe de mostrar es el 20");
        assertEquals(20, pilaLinkedList.extraer(), "El primer elemento que se debe de extraer es el 20");

        assertFalse(pilaLinkedList.estaVacia(), "La pila no deberia de estar vacia");
        assertEquals(10, pilaLinkedList.extraer(), "El ultimo elemento que de debe de extraer es el 10");
        assertTrue(pilaLinkedList.estaVacia(), "La pila deberia de estar vacia");
    }
    @Test
    public void testPilaArray() {
        assertTrue(pilaArrayList.estaVacia(), "La pila deberia estar vacia");

        pilaArrayList.agregar(10);
        pilaArrayList.agregar(20);
        pilaArrayList.agregar(30);

        assertEquals(30, pilaArrayList.primero(), "El primer elemento que se debe de mostrar es el 30");
        assertEquals(30, pilaArrayList.extraer(), "El primer elemento que se debe de extraer es el 30");
        assertEquals(20, pilaArrayList.primero(), "El primer elemento que se debe de mostrar es el 20");
        assertEquals(20, pilaArrayList.extraer(), "El primer elemento que se debe de extraer es el 20");

        assertFalse(pilaArrayList.estaVacia(), "La pila no deberia de estar vacia");
        assertEquals(10, pilaArrayList.extraer(), "El ultimo elemento que de debe de extraer es el 10");
        assertTrue(pilaArrayList.estaVacia(), "La pila deberia de estar vacia");
    }



}
