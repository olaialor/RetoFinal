package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.sound.sampled.DataLine;

import Modelo.Personaje;
import Modelo.Producto;
import Modelo.Usuario;

public interface Icontrolador {
	public Usuario logIn(String us, String pass);

	public List<Personaje> getPersonajes();

	public boolean SignUp(Usuario user);

	//public Usuario esCliente(String us);

	//Usuario datosUsuario(String us, boolean b);

	public List<Producto> getProducto();

	public String getNombre(int i);

	public boolean existeUsuario(String username);

	public boolean existePersonaje(String nombre);

	public boolean añadirPersonaje(Personaje character);

	public int nuevoCodigoPer();

	public ArrayList<String> completarNombrePer();

	public int nuevoCodigoProd();

	public void añadirProducto(Producto producto);

	public boolean modificarUsuario(String username, String contraseña, int telf, String email, String direc,
			String cuenta);

	public void eliminarUsuario(String nombreUsuario);
}

