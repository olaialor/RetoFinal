package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modelo.Trabajador;

class TrabajadorTest {
	private Trabajador trabajador;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
    public void parameterizedConstructorTest() {
        assertEquals("username", trabajador.getUsername());
        assertEquals("password", trabajador.getPassword());
        assertEquals(123456789, trabajador.getN_telefono());
        assertEquals("direccion", trabajador.getDireccion());
        assertEquals("email@example.com", trabajador.getEmail());
        assertEquals(123456, trabajador.getNss());
    }

    @Test
    public void defaultConstructorTest() {
        assertNull(trabajador.getUsername());
        assertNull(trabajador.getPassword());
        assertEquals(0, trabajador.getN_telefono());
        assertNull(trabajador.getDireccion());
        assertNull(trabajador.getEmail());
        assertEquals(0, trabajador.getNss());
    }

    @Test
    public void getNssTest() {
        assertEquals(123456, trabajador.getNss());
    }

    @Test
    public void setNssTest() {
    	trabajador.setNss(789012);
        assertEquals(789012, trabajador.getNss());
    }
    @Test
    public void toStringTest() {
        assertEquals("Trabajador [nss=123456]", trabajador.toString());
    }
}
