package Vista;

import javax.swing.*;

import Controlador.Controlador;

import java.awt.*;
import java.awt.event.*;

public class Paneles extends JFrame {

	private Controlador l;
	
    public Paneles(Controlador c) {
    	this.l=c;
    	
        setTitle("SANRIO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda_Producto.class.getResource("/Imagenes/LazoHelloKitty.png")));
        setSize(1280, 830);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(1280, 830));

        JTabbedPane tabbedPane = new JTabbedPane();

        // Crear un panel y agregar la ventana 1
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.setLayout(new BorderLayout());
        Wiki_Personaje ventana1 = new Wiki_Personaje(l); // Suponiendo que Ventana1 es un JFrame existente
        panel1.add(ventana1.getContentPane(), BorderLayout.CENTER);
        tabbedPane.addTab("Personajes", panel1);
       

        // Crear un panel y agregar la ventana 2
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        Busqueda_Producto ventana2 = new Busqueda_Producto(); // Suponiendo que Ventana2 es un JFrame existente
        panel2.add(ventana2.getContentPane(), BorderLayout.CENTER);
        tabbedPane.addTab("Tienda", panel2);

     // Cambiar el color de fondo de las pestañas
        Color customColor = new Color(0xFFC0D3);

        tabbedPane.setBackgroundAt(0, customColor); 
        tabbedPane.setBackgroundAt(1, customColor); 

        
        // Cambiar el color del texto de las pestañas
        tabbedPane.setForegroundAt(0, Color.WHITE);
        tabbedPane.setForegroundAt(1, Color.WHITE); 
        
        Font font = new Font("Goudy Old Style", Font.BOLD, 17); 
        tabbedPane.setFont(font); 

        getContentPane().add(tabbedPane);
    }

   
}