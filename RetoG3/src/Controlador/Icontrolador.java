package Controlador;

import java.util.Date;

import javax.sound.sampled.DataLine;

import Modelo.Personaje;
import Modelo.Usuario;

public interface Icontrolador {
	public Usuario logIn(String us, String pass);

	public Personaje getPersonaje(int Codigo, String nombre, String descripcion, Date cumple, String curiosidad);

	public boolean SignUp(Usuario user);
}
