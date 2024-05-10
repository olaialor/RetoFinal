package Vista;

import javax.swing.*;

import Controlador.Controlador;
import java.awt.*;

import Modelo.Trabajador;
import Modelo.Usuario;


import Controlador.Controlador;

import java.awt.*;

public class Paneles extends JFrame {

	private static final long serialVersionUID = 1L;
	private Controlador l;
	 static JTabbedPane tabbedPane ;
    public Paneles(Controlador c) {
    	this.l=c;
    	
        setTitle("SANRIO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda_Producto.class.getResource("/Imagenes/LazoHelloKitty.png")));
        setSize(1280, 830);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(1280, 830));

        tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.setLayout(new BorderLayout());
        Wiki_Personaje ventana1 = new Wiki_Personaje(l);
        panel1.add(ventana1.getContentPane(), BorderLayout.CENTER);
        tabbedPane.addTab("Personajes", panel1);
       

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        Busqueda_Producto ventana2 = new Busqueda_Producto(l);
        panel2.add(ventana2.getContentPane(), BorderLayout.CENTER);
        tabbedPane.addTab("Tienda", panel2);

        JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		Añadir_Personaje ventana3 = new Añadir_Personaje(l);
		panel3.add(ventana3.getContentPane(), BorderLayout.CENTER);
		tabbedPane.addTab("Añadir Presonaje", panel3);

		JPanel panel4 = new JPanel();
		panel4.setLayout(new BorderLayout());
		Añadir_Producto ventana4 = new Añadir_Producto(l);
		panel4.add(ventana4.getContentPane(), BorderLayout.CENTER);
		tabbedPane.addTab("Añadir Producto", panel4);
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new BorderLayout());
		Mi_Perfil perfil = new Mi_Perfil(l);
		panel5.add(perfil.getContentPane(), BorderLayout.CENTER);
		tabbedPane.addTab("Mi perfil", panel5);

		Color customColor = new Color(0xFFC0D3);
		tabbedPane.setBackgroundAt(2, customColor);
		tabbedPane.setBackgroundAt(3, customColor);
		tabbedPane.setForegroundAt(2, Color.WHITE);
		tabbedPane.setForegroundAt(3, Color.WHITE);
		

        tabbedPane.setBackgroundAt(0, customColor); 
        tabbedPane.setBackgroundAt(1, customColor); 
        tabbedPane.setBackgroundAt(4, customColor); 

        
        tabbedPane.setForegroundAt(0, Color.WHITE);
        tabbedPane.setForegroundAt(1, Color.WHITE);
        tabbedPane.setForegroundAt(4, Color.WHITE); 
        
        Font font = new Font("Goudy Old Style", Font.BOLD, 17); 
        tabbedPane.setFont(font); 

        panel1.setVisible(false);
        getContentPane().add(tabbedPane);
        
    }
    public static void setSelectedIndex(int index) {
        tabbedPane.setSelectedIndex(index);
    }

   
}

