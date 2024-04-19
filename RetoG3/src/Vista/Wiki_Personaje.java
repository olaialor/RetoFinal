package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wiki_Personaje extends JFrame implements ActionListener {

	public Wiki_Personaje() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Wiki_Personaje.class.getResource("/Imagenes/LazoHelloKitty.png")));
		setTitle("Ejemplo de GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1280, 768));

		/* JTabbedPane tabbedPane = new JTabbedPane(); */
		JPanel mainPanel = new JPanel();

		JPanel scrollPaneContainer = new JPanel();
		scrollPaneContainer.setBounds(194, 113, 862, 583);
		//scrollPaneContainer.setPreferredSize(new Dimension(800, 600)); // Tamaño deseado del JScrollPane

		// Crear el panel que contendrá las partes
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		// Agregar las partes al panel central
		for (int i = 0; i < 20; i++) { // Agregamos más partes para demostrar el funcionamiento del scrollbar
			JPanel panel = createPanel();
			centerPanel.add(panel);
			centerPanel.add(Box.createVerticalStrut(50)); // Separación entre las partes
		}
		mainPanel.setLayout(null);

		// Crear JScrollPane para el panel central
		JScrollPane scrollPane = new JScrollPane(centerPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	    // Ajustar el tamaño del JScrollPane
	    scrollPane.setPreferredSize(new Dimension(860, 580));
	    
		// Agregar el JScrollPane al panel interno
		scrollPaneContainer.add(scrollPane, BorderLayout.CENTER);

		// Agregar el panel interno al panel principal
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

	private JPanel createPanel() {
		JPanel panel = new JPanel(new BorderLayout());

		// Agregar imagen a la izquierda
		ImageIcon icon = new ImageIcon("ruta/a/imagen.png"); // Cambiar la ruta por la ruta de tu imagen
		JLabel imageLabel = new JLabel(icon);
		panel.add(imageLabel, BorderLayout.WEST);

		// Agregar JLabel en el centro
		JLabel label = new JLabel("Texto del label");
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label, BorderLayout.CENTER);

		// Agregar JButton debajo del JLabel
		JButton button = new JButton("Botón");
		// button.setBounds(0, 0, 100, 100);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Acción del botón
				JOptionPane.showMessageDialog(null, "Botón presionado");
			}
		});
		panel.add(button, BorderLayout.SOUTH);

		return panel;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Wiki_Personaje().setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}