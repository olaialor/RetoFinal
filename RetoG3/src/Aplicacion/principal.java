package Aplicacion;

import Vista.LogIn;
import Controlador.Controlador;
import Modelo.Cliente;

public class principal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controlador c=new Controlador();
		Cliente cl= new Cliente();
		LogIn frame=new LogIn(c,cl);
		frame.setVisible(true);
	}
}
