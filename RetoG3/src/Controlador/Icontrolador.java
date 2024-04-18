package Controlador;

import java.util.Date;

import javax.sound.sampled.DataLine;

import Modelo.Personaje;
import Modelo.Usuario;

public interface Icontrolador {
	public Usuario logIn(String us, String pass);

	public Usuario SignUp(String username, int telefono, String direccion, String email, String nº_Cuenta);

	public Personaje getPersonaje(int Codigo, String nombre, String descripcion, Date cumple, String curiosidad);
}
