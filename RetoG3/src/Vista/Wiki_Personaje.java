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
		setPreferredSize(new Dimension(1280, 768));

		/* JTabbedPane tabbedPane = new JTabbedPane(); */
		JPanel mainPanel = new JPanel();

		JPanel scrollPaneContainer = new JPanel();
		scrollPaneContainer.setBounds(194, 113, 862, 583);
		// scrollPaneContainer.setPreferredSize(new Dimension(800, 600)); // Tamaño
		// deseado del JScrollPane

		// Crear el panel que contendrá las partes
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		// Obtener la lista de personajes desde el controlador
		List<Personaje> personajes = controlador.getPersonajes();

		// Agregar las partes al panel central
		for (Personaje personaje : personajes) { // Agregamos más partes para demostrar el funcionamiento del scrollbar
			JPanel panel = createPanel(personaje);
			centerPanel.add(panel);
			centerPanel.add(Box.createVerticalStrut(50)); // Separación entre las partes
		}
		mainPanel.setLayout(null);

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
		lblNewLabel.setIcon(new ImageIcon(Wiki_Personaje.class.getResource("/Imagenes/logo_wiki3.png")));
		lblNewLabel.setBounds(236, 21, 756, 82);
		mainPanel.add(lblNewLabel);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Wiki_Personaje.class.getResource("/Imagenes/fondo_wiki2.jpg")));
		lblFondo.setBounds(-36, 0, 1382, 770);
		mainPanel.add(lblFondo);

	}

	private JPanel createPanel(Personaje personaje) {
		 JPanel panel = new JPanel();
		    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Establecer layout vertical

		    ImageIcon imagen = new ImageIcon(personaje.getRuta_foto()); // Obtener la ruta de la imagen del personaje
		    JLabel imagenLabel = new JLabel(imagen);
		    panel.add(imagenLabel);
		    
		    JLabel nombre = new JLabel("Nombre: " + personaje.getNombre());
		    nombre.setHorizontalAlignment(SwingConstants.LEFT);
		    panel.add(nombre);
		    JLabel descrip = new JLabel("Descripción: " + personaje.getDescripcion());
		    descrip.setHorizontalAlignment(SwingConstants.LEFT);
		    panel.add(descrip);
		    JLabel cumple = new JLabel("Cumpleaños: " + personaje.getCumpleaños());
		    cumple.setHorizontalAlignment(SwingConstants.LEFT);
		    panel.add(cumple);
		    JLabel curi = new JLabel("Curiosidad: " + personaje.getCuriosidad());
		    curi.setHorizontalAlignment(SwingConstants.LEFT);
		    panel.add(curi);

		    JButton detallesButton = new JButton("Ver detalles");
		    detallesButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el botón horizontalmente
		    panel.add(detallesButton);
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
