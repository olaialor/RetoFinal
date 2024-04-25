package Vista;

import javax.swing.*;

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

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Wiki_Personaje.class.getResource("/Imagenes/mocha2.png")));
		lblNewLabel_1.setBounds(-84, 506, 527, 359);
		mainPanel.add(lblNewLabel_1);

		JLabel lblPersonaje = new JLabel("");
		lblPersonaje.setIcon(new ImageIcon(Wiki_Personaje.class.getResource("/Imagenes/Ciao_Salut.gif")));
		lblPersonaje.setBounds(970, 577, 376, 176);
		mainPanel.add(lblPersonaje);

		JPanel scrollPaneContainer = new JPanel();
		scrollPaneContainer.setBounds(194, 113, 862, 583);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

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
		scrollPane.setPreferredSize(new Dimension(860, 580));

		scrollPaneContainer.add(scrollPane, BorderLayout.CENTER);

		mainPanel.add(scrollPaneContainer);

		getContentPane().add(mainPanel);
		pack();
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logo_wiki3.png")));
		lblNewLabel.setBounds(236, 21, 756, 82);
		mainPanel.add(lblNewLabel);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondo_wiki2.jpg")));
		lblFondo.setBounds(-36, 0, 1382, 770);
		mainPanel.add(lblFondo);
		
		

	}

	private JPanel createPanel2(Personaje personaje) {
		JPanel panel2 = new JPanel();
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
		panel.setLayout(new GridLayout(1, 2));

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		 textPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		JLabel nombre = new JLabel(personaje.getNombre());
		nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		nombre.setFont(new Font("Goudy Stout",Font.PLAIN, 14));
		textPanel.add(nombre);

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
		detallesButton.setFont(new Font("Goudy Old Style", Font.BOLD, 14));
		detallesButton.setMargin(new Insets(5, 5, 5, 5)); // Ajustar los márgenes
        textPanel.add(Box.createVerticalStrut(20));
		textPanel.add(detallesButton);

		// imagenLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		// imagePanel.add(imagenLabel, BorderLayout.CENTER);

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
