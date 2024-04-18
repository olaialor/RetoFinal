package Aplicacion;

import Vista.LogIn;
import Controlador.Controlador;

public class principal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controlador c=new Controlador();
		LogIn frame=new LogIn(c);
		frame.setVisible(true);
	}
}
