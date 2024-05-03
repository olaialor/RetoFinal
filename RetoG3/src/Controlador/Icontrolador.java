package Controlador;

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
	
	public List<Producto> getProducto();
	
	public String getNombre(int i);
}
