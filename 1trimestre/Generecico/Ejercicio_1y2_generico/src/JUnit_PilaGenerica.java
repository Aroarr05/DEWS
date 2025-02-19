import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnit_PilaGenerica {

    private PilaGenerica<Integer> pila;

    @BeforeEach
    public void setUp() {
        pila = new PilaGenerica<>();
    }

    @Test
    public void testEstaVacia() {
        assertTrue(pila.estaVacia());
    }

    @Test
    public void testAniadir() {
        pila.aniadir(1);
        assertFalse(pila.estaVacia());
    }

    @Test
    public void testExtraer() {
        pila.aniadir(1);
        pila.aniadir(2);
        Integer elemento = pila.extraer();
        assertEquals(2, elemento);
        assertEquals(1, pila.primero());
    }

    @Test
    public void testPrimeroConElementos() {
        pila.aniadir(1);
        pila.aniadir(2);
        assertEquals(2, pila.primero());
    }

    @Test
    public void testPrimeroSinElementos() {
        assertNull(pila.primero());
    }

    @Test
    public void testExtraerSinElementos() {
        assertNull(pila.extraer());
    }

    @Test
    public void testToStringConElementos() {
        pila.aniadir(1);
        pila.aniadir(2);
        assertEquals("Elementos en la pila: [2, 1]", pila.toString());
    }
}
