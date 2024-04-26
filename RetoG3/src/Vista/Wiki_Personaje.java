package Vista;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import Controlador.Controlador;
import Modelo.Personaje;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wiki_Personaje extends JFrame implements ActionListener {

	private Controlador controlador;

	public Wiki_Personaje(Controlador controlador) {
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

		List<Personaje> personajes = controlador.getPersonajes();

		for (Personaje personaje : personajes) {
			JPanel panel = createPanel(personaje);
			JPanel panel2 = createPanel2(personaje);
			centerPanel.add(panel2);
			centerPanel.add(panel);
			centerPanel.add(Box.createVerticalStrut(50));
		}

		JScrollPane scrollPane = new JScrollPane(centerPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logo_wiki3.png")));
		lblLogo.setBounds(236, 21, 756, 82);
		mainPanel.add(lblLogo);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondo_wiki2.jpg")));
		lblFondo.setBounds(-36, 0, 1382, 770);
		mainPanel.add(lblFondo);

	}

	private JPanel createPanel2(Personaje personaje) {
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 245, 248));
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS)); // Cambiado a BoxLayout horizontal

		String rutaImagen = personaje.getRuta_foto();
		ImageIcon imagen = new ImageIcon(getClass().getResource(rutaImagen));
		JLabel imagenLabel = new JLabel(imagen);
		imagenLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Alineación horizontal centrada
		imagenLabel.setAlignmentY(Component.CENTER_ALIGNMENT); // Alineación vertical centrada
		panel2.add(Box.createHorizontalGlue()); // Espacio para centrar horizontalmente
		panel2.add(imagenLabel);
		panel2.add(Box.createHorizontalGlue()); // Espacio para centrar horizontalmente

		return panel2;

	}

	private JPanel createPanel(Personaje personaje) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 245, 248));
		panel.setLayout(new GridLayout(1, 2));

		JPanel textPanel = new JPanel();
		textPanel.setBackground(new Color(255, 245, 248));
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		textPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		JLabel nombre = new JLabel(personaje.getNombre());
		nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		nombre.setFont(new Font("Goudy Stout", Font.PLAIN, 16));
		textPanel.add(nombre);

		textPanel.add(Box.createVerticalStrut(10));

		JLabel descrip = new JLabel("Descripción: " + personaje.getDescripcion());
		descrip.setAlignmentX(Component.CENTER_ALIGNMENT);
		descrip.setFont(new Font("Goudy Old Style", Font.PLAIN, 16));
		textPanel.add(descrip);

		JLabel cumple = new JLabel("Cumpleaños: " + personaje.getCumpleaños());
		cumple.setAlignmentX(Component.CENTER_ALIGNMENT);
		cumple.setFont(new Font("Goudy Old Style", Font.PLAIN, 16));
		textPanel.add(cumple);

		JLabel curi = new JLabel("Curiosidad: " + personaje.getCuriosidad());
		curi.setAlignmentX(Component.CENTER_ALIGNMENT);
		curi.setFont(new Font("Goudy Old Style", Font.PLAIN, 16));
		textPanel.add(curi);

		JButton detallesButton = new JButton("Ver productos");
		detallesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		detallesButton.setFont(new Font("Goudy Old Style", Font.BOLD, 19));
		detallesButton.setMargin(new Insets(5, 10, 5, 10)); // Ajustar los márgenes
		detallesButton.setForeground(Color.white);
		detallesButton.setBackground(new Color(252, 193, 211));
		textPanel.add(Box.createVerticalStrut(20));
		textPanel.add(detallesButton);

		panel.add(textPanel);

		return panel;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Controlador controlador = new Controlador();
				new Wiki_Personaje(controlador).setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Método no utilizado
	}
}
