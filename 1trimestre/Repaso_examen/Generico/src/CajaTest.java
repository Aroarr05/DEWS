import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CajaTest {
    private Caja<String> cajaString;
    private Caja<Integer> cajaInteger;

    @BeforeEach
    public void setUp() {
        cajaString = new Caja<>("Hola, Mundo");
        cajaInteger = new Caja<>(123);
    }

    @Test
    public void testGetValor() {
        assertEquals("Hola, Mundo", cajaString.getE(), "El elemento debería ser 'Hola, Mundo!'");
        assertEquals(123, cajaInteger.getE(), "El elemento debería ser 123");
    }
    @Test
    public void testSetElemento() {
        // Cambiar el elemento de la caja
        cajaString.setE("Adiós, Mundo!");
        cajaInteger.setE(456);

        assertEquals("Adiós, Mundo!", cajaString.getE(), "El nuevo elemento debería ser 'Adiós, Mundo!'");
        assertEquals(456, cajaInteger.getE(), "El nuevo elemento debería ser 456");
    }

    @Test
    public void testToString() {
        // Verificar la representación en cadena
        assertEquals("Caja{elemento=Hola, Mundo}", cajaString.toString(), "La representación en cadena es incorrecta");
        assertEquals("Caja{elemento=123}", cajaInteger.toString(), "La representación en cadena es incorrecta");
    }
}
