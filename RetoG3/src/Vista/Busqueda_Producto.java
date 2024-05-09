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
	private JPanel mainPanel;
	private JLabel lblPersonaje;
	private JPanel scrollPaneContainer;
	private JPanel centerPanel;
	private JScrollPane scrollPane;
	private JLabel lblLogo;
	private JLabel lblFondo;
	private JPanel panel;
	private String rutaImagen;
	private ImageIcon imagen;
	private JLabel imagenLabel;
	private JPanel textPanel;
	private JLabel descrip;
	private JLabel precio;
	private JButton btnCompra;

	/**
	 * @wbp.parser.constructor
	 */
	public Busqueda_Producto(Controlador controlador) {
		this.controlador = controlador;

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Wiki_Personaje.class.getResource("/Imagenes/LazoHelloKitty.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1280, 800));

		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension(1280, 800));
		mainPanel.setOpaque(false);

		lblPersonaje = new JLabel("");
		lblPersonaje.setIcon(new ImageIcon(Busqueda_Producto.class.getResource("/Imagenes/personaje4.png")));
		lblPersonaje.setBounds(-21, 530, 226, 223);
		mainPanel.add(lblPersonaje);

		scrollPaneContainer = new JPanel();
		scrollPaneContainer.setBounds(194, 113, 862, 583);

		centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.setBackground(new Color(255, 245, 248));

		List<Personaje> personajes = controlador.getPersonajes();
		for (Personaje pers : personajes) {
			buclePaneles(pers.getNombre());
		}

		scrollPane = new JScrollPane(centerPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scrollPane.setPreferredSize(new Dimension(860, 580));

		scrollPaneContainer.setBackground(Color.white); // Establece el color de fondo del JScrollPane
		scrollPane.setPreferredSize(new Dimension(860, 580));

		// Cambiar el color de la barra de desplazamiento
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {

			@Override
			protected JButton createDecreaseButton(int orientation) {
				JButton button = super.createDecreaseButton(orientation);
				button.setBackground(new Color(255, 213, 227)); // Cambiar el color de la flecha de desplazamiento
				return button;
			}

			@Override
			protected JButton createIncreaseButton(int orientation) {
				JButton button = super.createIncreaseButton(orientation);
				button.setBackground(new Color(255, 213, 227)); // Cambiar el color de la flecha de desplazamiento
				return button;
			}

			@Override
			protected void configureScrollBarColors() {
				this.thumbColor = new Color(255, 213, 227);
			}
		});

		scrollPaneContainer.add(scrollPane, BorderLayout.CENTER);

		mainPanel.add(scrollPaneContainer);

		getContentPane().add(mainPanel);
		pack();
		setLocationRelativeTo(null);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Busqueda_Producto.class.getResource("/Imagenes/logo_tienda4.png")));
		lblLogo.setBounds(346, 21, 571, 82);
		mainPanel.add(lblLogo);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondo_wiki2.jpg")));
		lblFondo.setBounds(-36, 0, 1382, 770);
		mainPanel.add(lblFondo);

	}

	public Busqueda_Producto(Controlador controlador, String nombre) {
		this.controlador = controlador;

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Wiki_Personaje.class.getResource("/Imagenes/LazoHelloKitty.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1280, 800));

		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension(1280, 800));
		mainPanel.setOpaque(false);

		lblPersonaje = new JLabel("New label");
		lblPersonaje.setIcon(new ImageIcon(Busqueda_Producto.class.getResource("/Imagenes/personaje3.png")));
		lblPersonaje.setBounds(-65, 526, 264, 237);
		mainPanel.add(lblPersonaje);

		scrollPaneContainer = new JPanel();
		scrollPaneContainer.setBounds(194, 113, 862, 583);

		centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.setBackground(new Color(255, 245, 248));

		centerPanel.removeAll();

		buclePaneles(nombre);

		scrollPane = new JScrollPane(centerPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scrollPane.setPreferredSize(new Dimension(860, 580));

		scrollPaneContainer.setBackground(Color.white); // Establece el color de fondo del JScrollPane
		scrollPane.setPreferredSize(new Dimension(860, 580));

		scrollPaneContainer.add(scrollPane, BorderLayout.CENTER);

		mainPanel.add(scrollPaneContainer);

		getContentPane().add(mainPanel);
		pack();
		setLocationRelativeTo(null);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Busqueda_Producto.class.getResource("/Imagenes/logo_tienda4.png")));
		lblLogo.setBounds(346, 21, 571, 82);
		mainPanel.add(lblLogo);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondo_wiki2.jpg")));
		lblFondo.setBounds(-36, 0, 1382, 770);
		mainPanel.add(lblFondo);

	}

	public void buclePaneles(String personaje) {
		List<Producto> productos = controlador.getProducto();
		for (Producto producto : productos) {
			if (producto.getPersonaje().equalsIgnoreCase(personaje)) {
				JPanel panel = createPanel(producto);
				centerPanel.add(panel);
				centerPanel.add(Box.createVerticalStrut(50));

			}

		}

	}

	private JPanel createPanel(Producto producto) {
		panel = new JPanel();
		panel.setBackground(new Color(255, 245, 248));
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		rutaImagen = producto.getRuta_img();
		imagen = new ImageIcon(getClass().getResource(rutaImagen));
		imagenLabel = new JLabel(imagen);
		JPanel imagePanel = new JPanel(new BorderLayout());
		imagePanel.setBackground(new Color(255, 245, 248));
		imagePanel.add(imagenLabel, BorderLayout.WEST);
		panel.add(imagenLabel);

		panel.add(Box.createHorizontalStrut(20));
		
		textPanel = new JPanel();
		textPanel.setBackground(new Color(255, 245, 248));
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

		descrip = new JLabel(producto.getDescripcion());
		descrip.setFont(new Font("Goudy Stout", Font.PLAIN, 12));
		textPanel.add(descrip);

		precio = new JLabel(producto.getPrecio() + "€");
		precio.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		textPanel.add(precio);

		panel.add(textPanel);

		btnCompra = new JButton("Comprar");
		btnCompra.setFont(new Font("Goudy Old Style", Font.BOLD, 19));
		btnCompra.setMargin(new Insets(5, 13, 5, 13));
		btnCompra.setForeground(Color.white);
		btnCompra.setBackground(new Color(252, 193, 211));
		btnCompra.setPreferredSize(new Dimension(50, 10));
		btnCompra.addActionListener(this);

		textPanel.add(Box.createVerticalStrut(20));
		textPanel.add(btnCompra);
		btnCompra.setActionCommand(String.valueOf(producto.getCod_producto()));
		btnCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		UIManager.put("OptionPane.background", new Color(160, 202, 238));
		UIManager.put("Panel.background", new Color(160, 202, 238));
		UIManager.put("OptionPane.messageForeground", Color.BLACK);
		UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style", Font.PLAIN, 16));

		if (command != null) {
			// Mostrar un mensaje de confirmación
			int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas comprar este producto?", "",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

			// Verificar la opción seleccionada por el usuario
			if (opcion == JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(this, "Producto añadido correctamente.", "",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Operación cancelada.", "", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
