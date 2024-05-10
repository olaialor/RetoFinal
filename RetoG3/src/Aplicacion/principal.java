package Aplicacion;

import Controlador.Controlador;
import Modelo.Cliente;
import Vista.LogIn;

public class principal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controlador c = new Controlador();
		LogIn frame = new LogIn(c);
		frame.setVisible(true);
	}
}
