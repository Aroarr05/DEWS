import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnit_PilaArray {

    private PilaArray<Integer> pila; //Crea la pila

    @BeforeEach
    public void setUp() {
        pila = new PilaArray<>();
    } //Constructor de la pila para crearla

    @Test //LLama a la funcion de estavacia y te comprue que sie es verdadero si esta vacia
    public void testEstaVacia() {
        assertTrue(pila.estaVacia());
    }

    @Test //LLama a la funcion de añadir y añade un elemento
    public void testAniadir() {
        pila.aniadir(10);
        assertFalse(pila.estaVacia());
    }

    @Test //LLame a la funcion de extraer y elimina el primer numero que se ha añadido
    public void testExtraer() {
        pila.aniadir(1);
        pila.aniadir(2);
        pila.aniadir(3);

        Integer elementoExtraido = pila.extraer();
        assertEquals(3, elementoExtraido);
    }

    @Test //LLama a la funcion de primero y comprueba que sie el primer numero que se ha añadido es el mismo
    public void testPrimeroConElementos() {
        pila.aniadir(1);
        pila.aniadir(2);
        assertEquals(1, pila.primero());
    }

    @Test //Te manda una excepcion si si intentas leer el primer numero sin elementos
    public void testPrimeroSinElementos() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            pila.primero();
        });
    }

    @Test  //Te manda una excepcion si si intentas extraer algo sin que haya elementos
    public void testExtraerSinElementos() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            pila.extraer();
        });
    }

    @Test
    public void testToStringConElementos() {
        pila.aniadir(1);
        pila.aniadir(2);
        pila.aniadir(3);
        assertEquals(" 1 2", pila.toString());
    }
}
