package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modelo.Personaje;

class PersonajeTest {
	private Personaje personaje;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testParameterizedConstructor() {
		assertEquals("nombre", personaje.getNombre());
		assertEquals("descripcion", personaje.getDescripcion());
		Date cumpleaños = new Date();
		assertEquals(cumpleaños, personaje.getCumpleaños());
		assertEquals("curiosidad", personaje.getCuriosidad());
		assertEquals("ruta_foto", personaje.getRuta_foto());
		assertEquals(123, personaje.getCodigo());
	}

	@Test
	public void testDefaultConstructor() {
		assertNull(personaje.getNombre());
		assertNull(personaje.getDescripcion());
		assertNull(personaje.getCumpleaños());
		assertNull(personaje.getCuriosidad());
		assertNull(personaje.getRuta_foto());
		assertEquals(0, personaje.getCodigo());
	}

	 @Test
	    public void getNombreTest() {
	        assertEquals("nombre", personaje.getNombre());
	    }

	    @Test
	    public void setNombreTest() {
	    	personaje.setNombre("nuevo_nombre");
	        assertEquals("nuevo_nombre", personaje.getNombre());
	    }

	    @Test
	    public void getDescripcionTest() {
	        assertEquals("descripcion", personaje.getDescripcion());
	    }

	    @Test
	    public void setDescripcionTest() {
	    	personaje.setDescripcion("nueva_descripcion");
	        assertEquals("nueva_descripcion", personaje.getDescripcion());
	    }

	    @Test
	    public void getCumpleañosTest() {
	        Date cumpleaños = new Date();
	        assertEquals(cumpleaños, personaje.getCumpleaños());
	    }

	    @Test
	    public void setCumpleañosTest() {
	        Date cumpleaños = new Date();
	        personaje.setCumpleaños(cumpleaños);
	        assertEquals(cumpleaños, personaje.getCumpleaños());
	    }

	    @Test
	    public void getCuriosidadTest() {
	        assertEquals("curiosidad", personaje.getCuriosidad());
	    }

	    @Test
	    public void setCuriosidadTest() {
	    	personaje.setCuriosidad("nueva_curiosidad");
	        assertEquals("nueva_curiosidad", personaje.getCuriosidad());
	    }

	    @Test
	    public void getRuta_fotoTest() {
	        assertEquals("ruta_foto", personaje.getRuta_foto());
	    }

	    @Test
	    public void setRuta_fotoTest() {
	    	personaje.setRuta_foto("nueva_ruta_foto");
	        assertEquals("nueva_ruta_foto", personaje.getRuta_foto());
	    }

	    @Test
	    public void getCodigoTest() {
	        assertEquals(123, personaje.getCodigo());
	    }

	    @Test
	    public void setCodigoTest() {
	    	personaje.setCodigo(456);
	        assertEquals(456, personaje.getCodigo());
	    }

	    @Test
	    public void toStringTest() {
	        assertEquals("Personaje [nombre=nombre, descripcion=descripcion, cumpleaños=" + personaje.getCumpleaños() + ", curiosidad=curiosidad, ruta_foto=ruta_foto, codigo=123]", personaje.toString());
	    }
	}
