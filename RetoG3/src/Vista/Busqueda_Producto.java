package Vista;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import Controlador.Controlador;
import Modelo.Personaje;
import Modelo.Producto;

import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Busqueda_Producto extends JFrame implements ActionListener {

	private Controlador controlador;
	private JLabel lblNewLabel;

	public Busqueda_Producto(Controlador controlador) {
		this.controlador = controlador;

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Wiki_Personaje.class.getResource("/Imagenes/LazoHelloKitty.png")));
		setTitle("Ejemplo de GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1280, 800));

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension(1280, 800));
		mainPanel.setOpaque(false);

		JLabel lblPersonaje2 = new JLabel("");
		lblPersonaje2.setIcon(new ImageIcon(Wiki_Personaje.class.getResource("/Imagenes/personaje.png")));
		lblPersonaje2.setBounds(1038, 542, 404, 228);
		mainPanel.add(lblPersonaje2);

		JLabel lblPersonaje = new JLabel("New label");
		lblPersonaje.setIcon(new ImageIcon(Wiki_Personaje.class.getResource("/Imagenes/personaje2.png")));
		lblPersonaje.setBounds(-65, 526, 264, 237);
		mainPanel.add(lblPersonaje);

		JPanel scrollPaneContainer = new JPanel();
		scrollPaneContainer.setBounds(194, 113, 862, 583);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.setBackground(new Color(255, 245, 248));
		
		

		List<Producto> productos = controlador.getProducto();
		for (Producto producto : productos) {
			JPanel panel = createPanel(producto);
			// JPanel panel2 = createPanel22(producto);
			// centerPanel.add(panel2);
			centerPanel.add(panel);
			centerPanel.add(Box.createVerticalStrut(50));
		}

		JScrollPane scrollPane = new JScrollPane(centerPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// Ajustar el tamaño del JScrollPane
		scrollPane.setPreferredSize(new Dimension(860, 580));

		// Agregar el JScrollPane al panel interno
		scrollPaneContainer.setBackground(Color.white); // Establece el color de fondo del JScrollPane
		scrollPane.setPreferredSize(new Dimension(860, 580));

		scrollPaneContainer.add(scrollPane, BorderLayout.CENTER);

		mainPanel.add(scrollPaneContainer);

		getContentPane().add(mainPanel);
		pack();
		setLocationRelativeTo(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Busqueda_Producto.class.getResource("/Imagenes/logo_tienda4.png")));
		lblLogo.setBounds(346, 21, 571, 82);
		mainPanel.add(lblLogo);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondo_wiki2.jpg")));
		lblFondo.setBounds(-36, 0, 1382, 770);
		mainPanel.add(lblFondo);
		
		
		
		
		

	}

	/*
	 * private JPanel createPanel22(Producto producto) { JPanel panel2 = new
	 * JPanel(); panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
	 * 
	 * String rutaImagen = producto.getRuta_foto(); //ImageIcon imagen = new
	 * ImageIcon(getClass().getResource(rutaImagen)); JLabel imagenLabel = new
	 * JLabel();
	 * 
	 * ImageIcon icon = new ImageIcon(rutaImagen); // Replace "image.jpg" with the
	 * path to your image Image image = icon.getImage(); Image scaledImage =
	 * image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); ImageIcon scaledIcon =
	 * new ImageIcon(scaledImage); imagenLabel.setIcon(scaledIcon);
	 * 
	 * imagenLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	 * imagenLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
	 * panel2.add(Box.createHorizontalGlue()); panel2.add(imagenLabel);
	 * panel2.add(Box.createHorizontalGlue()); return panel2;
	 * 
	 * }
	 */

//	private JPanel createPanel(Producto producto) {
//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(255, 245, 248));
//		panel.setLayout(new GridLayout(1, 2));
//
//		String rutaImagen = producto.getRuta_foto();
//		JLabel imagenLabel = new JLabel();
//
//		ImageIcon icon = new ImageIcon(rutaImagen);
//		Image image = icon.getImage();
//		Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon scaledIcon = new ImageIcon(scaledImage);
//		imagenLabel.setIcon(scaledIcon);
//		imagenLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//		imagenLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
//		panel.add(Box.createHorizontalGlue());
//		panel.add(imagenLabel);
//		panel.add(Box.createHorizontalGlue());
//
//		JPanel textPanel = new JPanel();
//		textPanel.setBackground(new Color(255, 245, 248));
//		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
//		textPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
//
//		JLabel precio = new JLabel(producto.getPrecio());
//		precio.setAlignmentX(Component.CENTER_ALIGNMENT);
//		precio.setFont(new Font("Goudy Stout", Font.PLAIN, 16));
//		textPanel.add(precio);
//		Dimension size = precio.getPreferredSize();
//		size.width = 50;
//		precio.setPreferredSize(size);
//		textPanel.add(precio);
//
//		textPanel.add(Box.createVerticalStrut(10));
//
//		JLabel descrip = new JLabel("Descripción: " + producto.getDescripcion());
//		descrip.setAlignmentX(Component.CENTER_ALIGNMENT);
//		descrip.setFont(new Font("Goudy Old Style", Font.PLAIN, 16));
//		textPanel.add(descrip);
//
//		JButton detallesButton = new JButton("Comprar");
//		detallesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//		detallesButton.setFont(new Font("Goudy Old Style", Font.BOLD, 19));
//		detallesButton.setMargin(new Insets(5, 13, 5, 13)); // Ajustar los márgenes
//		detallesButton.setForeground(Color.white);
//		detallesButton.setBackground(new Color(252, 193, 211));
//		textPanel.add(Box.createVerticalStrut(20));
//		textPanel.add(detallesButton);
//
//		panel.add(textPanel);
//
//		return panel;
//	}
	
	private JPanel createPanel(Producto producto) {
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(255, 245, 248));
	    panel.setLayout(new GridLayout(1, 3)); // Three columns

	    // Image column
	    
	    lblNewLabel = new JLabel("New label");
	    String rutaImagen = producto.getRuta_foto();
	    lblNewLabel.setIcon(new ImageIcon(Busqueda_Producto.class.getResource(rutaImagen)));
	    System.out.println(rutaImagen);
	    panel.add(lblNewLabel);
	  

	    // Text column
	    JPanel textPanel = new JPanel();
	    textPanel.setBackground(new Color(255, 245, 248));
	    textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
	    
	    JLabel precio = new JLabel(producto.getPrecio());
	    precio.setFont(new Font("Goudy Stout", Font.PLAIN, 16));
	    textPanel.add(precio);

	    JLabel descrip = new JLabel("Descripción: " + producto.getDescripcion());
	    descrip.setFont(new Font("Goudy Old Style", Font.PLAIN, 16));
	    textPanel.add(descrip);

	    panel.add(textPanel);

	    // Button column
	    JButton detallesButton = new JButton("Comprar");
	    detallesButton.setFont(new Font("Goudy Old Style", Font.BOLD, 19));
	    detallesButton.setMargin(new Insets(5, 13, 5, 13)); // Adjust margins
	    detallesButton.setForeground(Color.white);
	    detallesButton.setBackground(new Color(252, 193, 211));
	    panel.add(detallesButton);

	    return panel;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// Método no utilizado
	}
}
