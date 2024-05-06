package Controlador;

import java.util.Date;
import Modelo.Cliente;
import Modelo.Personaje;
import Modelo.Usuario;

public interface Icontrolador {
	public Usuario logIn(String us, String pass);

	public Personaje getPersonaje(int Codigo, String nombre, String descripcion, Date cumple, String curiosidad);

	public boolean SignUp(Usuario user);
	
	public boolean modificarUsuario(String username, String contraseña,  int telf, String email, String direc, String cuenta);
}
