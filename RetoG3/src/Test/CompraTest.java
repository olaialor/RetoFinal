package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modelo.Compra;

class CompraTest {
	private Compra compra;
	private LocalDateTime hora = LocalDateTime.now();

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void ParameterizedConstructorTest() {
		assertEquals("usuario1", compra.getUsername());
		assertEquals("producto1", compra.getCod_producto());
		assertEquals(hora, compra.getHora());
	}

	@Test
	public void DefaultConstructorTest() {
		assertEquals(null, compra.getUsername());
		assertEquals(null, compra.getCod_producto());
		assertNull(compra.getHora());
	}

	@Test
	public void getUsernameTest() {
		assertEquals("usuario1", compra.getUsername());
	}

	@Test
	public void setUsernameTest() {
		compra.setUsername("usuario2");
		assertEquals("usuario2", compra.getUsername());
	}

	@Test
	public void getCod_productoTest() {
		assertEquals("producto1", compra.getCod_producto());
	}

	@Test
	public void setCod_productoTest() {
		compra.setCod_producto("producto2");
		assertEquals("producto2", compra.getCod_producto());
	}

	@Test
	public void getHoraTest() {
		assertEquals(hora, compra.getHora());
	}

	@Test
	public void setHoraTest() {
		compra.setHora(hora);
		assertEquals(hora, compra.getHora());
	}

	@Test
	public void toStringTest() {
		Compra compra = new Compra("usuario3", "producto3", hora);
		assertEquals("Compra [username=usuario3, cod_producto=producto3, hora=" + hora.toString() + "]",
				compra.toString());
	}
}
