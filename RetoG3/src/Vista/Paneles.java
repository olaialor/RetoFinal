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
	 private Usuario usuario;
    public Paneles(Controlador c, Usuario usuario) {
    	this.l=c;
    	this.usuario=usuario;
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
        
        Color customColor = new Color(0xFFC0D3);

        if(usuario instanceof Trabajador) {
        	 JPanel panel3 = new JPanel();
     		panel3.setLayout(new BorderLayout());
     		Añadir_Personaje ventana3 = new Añadir_Personaje(l);
     		panel3.add(ventana3.getContentPane(), BorderLayout.CENTER);
     		tabbedPane.addTab("Añadir Personaje", panel3);

     		JPanel panel4 = new JPanel();
     		panel4.setLayout(new BorderLayout());
     		Añadir_Producto ventana4 = new Añadir_Producto(l);
     		panel4.add(ventana4.getContentPane(), BorderLayout.CENTER);
     		tabbedPane.addTab("Añadir Producto", panel4);
     		

    		tabbedPane.setBackgroundAt(2, customColor);
    		tabbedPane.setBackgroundAt(3, customColor);
    		tabbedPane.setForegroundAt(2, Color.WHITE);
    		tabbedPane.setForegroundAt(3, Color.WHITE);
    		
     		
        }else {
        	JPanel panel5 = new JPanel();
    		panel5.setLayout(new BorderLayout());
    		Mi_Perfil perfil = new Mi_Perfil(l, usuario);
    		panel5.add(perfil.getContentPane(), BorderLayout.CENTER);
    		tabbedPane.addTab("Mi perfil", panel5);

            tabbedPane.setBackgroundAt(2, customColor); 
            tabbedPane.setForegroundAt(2, Color.WHITE); 

        }
        
        tabbedPane.setBackgroundAt(0, customColor); 
        tabbedPane.setBackgroundAt(1, customColor); 

        
        tabbedPane.setForegroundAt(0, Color.WHITE);
        tabbedPane.setForegroundAt(1, Color.WHITE);
        
        Font font = new Font("Goudy Old Style", Font.BOLD, 17); 
        tabbedPane.setFont(font); 

        panel1.setVisible(false);
        getContentPane().add(tabbedPane);
        
    }
    public static void setSelectedIndex(int index) {
        tabbedPane.setSelectedIndex(index);
    }
    
    public void cerrar_Paneles () {
    	Paneles.this.setVisible(false);
		Paneles.this.dispose();
	}

   
<<<<<<< HEAD
}
=======
}

>>>>>>> 163920fdecd89d119a535956cf511468d78d3def
