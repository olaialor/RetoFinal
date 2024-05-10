package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modelo.Cliente;

class ClienteTest {
	private Cliente cliente;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	 @Test
	    public void testParameterizedConstructor() {
	        assertEquals("username", cliente.getUsername());
	        assertEquals("password", cliente.getPassword());
	        assertEquals(123456789, cliente.getN_telefono());
	        assertEquals("direccion", cliente.getDireccion());
	        assertEquals("email@example.com", cliente.getEmail());
	        assertEquals("n_cuenta", cliente.getN_cuenta());
	    }

	    @Test
	    public void testDefaultConstructor() {
	        assertNull(cliente.getUsername());
	        assertNull(cliente.getPassword());
	        assertEquals(0, cliente.getN_telefono());
	        assertNull(cliente.getDireccion());
	        assertNull(cliente.getEmail());
	        assertEquals("", cliente.getN_cuenta());
	    }

	    @Test
	    public void getN_cuentaTest() {
	        assertEquals("n_cuenta", cliente.getN_cuenta());
	    }

	    @Test
	    public void setN_cuentaTest() {
	    	cliente.setN_cuenta("new_n_cuenta");
	        assertEquals("new_n_cuenta", cliente.getN_cuenta());
	    }
}
