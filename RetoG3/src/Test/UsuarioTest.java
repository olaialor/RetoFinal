package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modelo.Usuario;

class UsuarioTest {
	private Usuario usuario;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void ParameterizedConstructorTest() {
		assertEquals("username", usuario.getUsername());
		assertEquals("password", usuario.getPassword());
		assertEquals(123456789, usuario.getN_telefono());
		assertEquals("direccion", usuario.getDireccion());
		assertEquals("email@example.com", usuario.getEmail());
	}

	@Test
	public void DefaultConstructorTest() {
		Usuario defaultUsuario = new Usuario();
		assertNull(defaultUsuario.getUsername());
		assertNull(defaultUsuario.getPassword());
		assertEquals(0, defaultUsuario.getN_telefono());
		assertNull(defaultUsuario.getDireccion());
		assertNull(defaultUsuario.getEmail());
	}

	@Test
	public void getUsernameTest() {
		assertEquals("username", usuario.getUsername());
	}

	@Test
	public void setUsernameTest() {
		usuario.setUsername("new_username");
		assertEquals("new_username", usuario.getUsername());
	}

	@Test
	public void getPasswordTest() {
		assertEquals("password", usuario.getPassword());
	}

	@Test
	public void setPasswordTest() {
		usuario.setPassword("new_password");
		assertEquals("new_password", usuario.getPassword());
	}

	@Test
	public void getN_telefonoTest() {
		assertEquals(123456789, usuario.getN_telefono());
	}

	@Test
	public void setN_telefonoTest() {
		usuario.setN_telefono(987654321);
		assertEquals(987654321, usuario.getN_telefono());
	}

	@Test
	public void getDireccionTest() {
		assertEquals("direccion", usuario.getDireccion());
	}

	@Test
	public void setDireccionTest() {
		usuario.setDireccion("new_direccion");
		assertEquals("new_direccion", usuario.getDireccion());
	}

	@Test
	public void getEmailTest() {
		assertEquals("email@example.com", usuario.getEmail());
	}

	@Test
	public void setEmailTest() {
		usuario.setEmail("new_email@example.com");
		assertEquals("new_email@example.com", usuario.getEmail());
	}

	@Test
	public void toStringTest() {
		assertEquals(
				"Usuario [username=username, password=password, n_telefono=123456789, direccion=direccion, email=email@example.com]",
				usuario.toString());
	}
}
