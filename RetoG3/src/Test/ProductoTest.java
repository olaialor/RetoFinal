package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modelo.Producto;

class ProductoTest {
	private Producto producto;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void parameterizedConstructorTest() {
		assertEquals("personaje", producto.getPersonaje());
		assertEquals(123, producto.getCod_producto());
		assertEquals(10.5, producto.getPrecio(), 0);
		assertEquals("descripcion", producto.getDescripcion());
		assertEquals(100, producto.getStock());
		assertEquals("ruta_img", producto.getRuta_img());
	}

	@Test
	public void defaultConstructorTest() {
		assertEquals(0, producto.getCod_producto());
		assertEquals(null, producto.getPrecio());
		assertEquals(null, producto.getDescripcion());
		assertEquals(0, producto.getStock());
		assertEquals(null, producto.getRuta_img());
	}

	@Test
	public void getCod_productoTest() {
		assertEquals(123, producto.getCod_producto());
	}

	@Test
	public void setCod_productoTest() {
		producto.setCod_producto(456);
		assertEquals(456, producto.getCod_producto());
	}

	@Test
	public void getPrecioTest() {
		assertEquals(10.5, producto.getPrecio(), 0);
	}

	@Test
	public void setPrecioTest() {
		producto.setPrecio(20.75);
		assertEquals(20.75, producto.getPrecio(), 0);
	}

	@Test
	public void getDescripcionTest() {
		assertEquals("descripcion", producto.getDescripcion());
	}

	@Test
	public void setDescripcionTest() {
		producto.setDescripcion("nueva descripcion");
		assertEquals("nueva descripcion", producto.getDescripcion());
	}

	@Test
	public void getStockTest() {
		assertEquals(100, producto.getStock());
	}

	@Test
	public void setStockTest() {
		producto.setStock(200);
		assertEquals(200, producto.getStock());
	}

	@Test
	public void getPersonajeTest() {
		assertEquals("personaje", producto.getPersonaje());
	}

	@Test
	public void setPersonajeTest() {
		producto.setPersonaje("nuevo personaje");
		assertEquals("nuevo personaje", producto.getPersonaje());
	}

	@Test
	public void getRuta_imgTest() {
		assertEquals("ruta_img", producto.getRuta_img());
	}

	@Test
	public void setRuta_imgTest() {
		producto.setRuta_img("nueva_ruta_img");
		assertEquals("nueva_ruta_img", producto.getRuta_img());
	}

	@Test
	public void toStringTest() {
		assertEquals("Producto [cod_producto=123, precio=10.5, descripcion=descripcion, stock=100]",
				producto.toString());
	}
}
