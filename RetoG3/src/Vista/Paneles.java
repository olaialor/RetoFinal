package Vista;

import javax.swing.*;

import Controlador.Controlador;

import java.awt.*;
import java.awt.event.*;

public class Paneles extends JFrame {
	private Controlador l;
	public static JTabbedPane tabbedPane;

	public Paneles(Controlador c) {
		this.l = c;
		setTitle("Aplicación con Pestañas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Busqueda_Producto.class.getResource("/Imagenes/LazoHelloKitty.png")));
		setSize(1280, 768);
		setLocationRelativeTo(null);
		setPreferredSize(new Dimension(1280, 768));

		tabbedPane = new JTabbedPane();

		// Crear un panel y agregar la ventana 1
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		Wiki_Personaje ventana1 = new Wiki_Personaje(); // Suponiendo que Ventana1 es un JFrame existente
		panel1.add(ventana1.getContentPane(), BorderLayout.CENTER);
		tabbedPane.addTab("Pestaña 1", panel1);

		// Crear un panel y agregar la ventana 2
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		Busqueda_Producto ventana2 = new Busqueda_Producto(); // Suponiendo que Ventana2 es un JFrame existente
		panel2.add(ventana2.getContentPane(), BorderLayout.CENTER);
		tabbedPane.addTab("Pestaña 2", panel2);

		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		Añadir_Personaje ventana3 = new Añadir_Personaje(l);
		panel3.add(ventana3.getContentPane(), BorderLayout.CENTER);
		tabbedPane.addTab("Pestaña 3", panel3);

		getContentPane().add(tabbedPane);
	}

	
}