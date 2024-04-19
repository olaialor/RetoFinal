package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paneles extends JFrame {

    public Paneles() {
        setTitle("Aplicación con Pestañas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda_Producto.class.getResource("/Imagenes/LazoHelloKitty.png")));
        setSize(1280, 768);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(1280, 768));

        JTabbedPane tabbedPane = new JTabbedPane();

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


        getContentPane().add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Paneles().setVisible(true);
            }
        });
    }
}
