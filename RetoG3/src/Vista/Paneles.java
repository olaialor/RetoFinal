package Vista;

import javax.swing.*;

import Controlador.Controlador;
import Modelo.Cliente;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Paneles extends JFrame {
	
	private Controlador l;
	public static JTabbedPane tabbedPane;
	private Cliente cliente;

	public Paneles(Controlador c, boolean administrador, Cliente u)  {
		this.l = c;
		this.cliente=u;
		setTitle("Aplicación con Pestañas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Busqueda_Producto.class.getResource("/Imagenes/LazoHelloKitty.png")));
		setSize(1280, 768);
		setLocationRelativeTo(null);
		setPreferredSize(new Dimension(1280, 768));

		tabbedPane = new JTabbedPane();

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		Wiki_Personaje ventana1 = new Wiki_Personaje(); 
		panel1.add(ventana1.getContentPane(), BorderLayout.CENTER);
		tabbedPane.addTab("Pestaña 1", panel1);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		Busqueda_Producto ventana2 = new Busqueda_Producto(); 
		panel2.add(ventana2.getContentPane(), BorderLayout.CENTER);
		tabbedPane.addTab("Pestaña 2", panel2);
		
		
		
		Color customColor = new Color(0xFFC0D3);
		
		
		if (administrador==true){
			JPanel panel3 = new JPanel();
			panel3.setLayout(new BorderLayout());
			Añadir_Personaje ventana3 = new Añadir_Personaje(l);
			panel3.add(ventana3.getContentPane(), BorderLayout.CENTER);
			tabbedPane.addTab("Pestaña 3", panel3);
			
			JPanel panel4 = new JPanel();
			panel4.setLayout(new BorderLayout());
			Añadir_Producto ventana4 = new Añadir_Producto(l);
			panel4.add(ventana4.getContentPane(), BorderLayout.CENTER);
			tabbedPane.addTab("Pestaña 4", panel4);
			
			tabbedPane.setBackgroundAt(2, customColor); 
	        tabbedPane.setBackgroundAt(3, customColor); 
	        tabbedPane.setForegroundAt(2, Color.WHITE); 
	        tabbedPane.setForegroundAt(3, Color.WHITE); 

		}else {
			JPanel panel5 = new JPanel();
			panel5.setLayout(new BorderLayout());
			Usuario perfil = new Usuario(l,cliente);
			panel5.add(perfil.getContentPane(), BorderLayout.CENTER);
			tabbedPane.addTab("Mi perfil", panel5);
		}
		
		
		 // Cambiar el color de fondo de las pestañas
        

        tabbedPane.setBackgroundAt(0, customColor); 
        tabbedPane.setBackgroundAt(1, customColor); 
        tabbedPane.setBackgroundAt(2, customColor); 
        
        
        // Cambiar el color del texto de las pestañas
        tabbedPane.setForegroundAt(0, Color.WHITE);
        tabbedPane.setForegroundAt(1, Color.WHITE);
        tabbedPane.setForegroundAt(2, Color.WHITE); 
        
        
        
        Font font = new Font("Goudy Old Style", Font.BOLD, 17); 
        tabbedPane.setFont(font); 


		getContentPane().add(tabbedPane);
	}
	
}