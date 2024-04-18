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
		JPanel mainPanel = new JPanel(new BorderLayout());

		JPanel scrollPaneContainer = new JPanel(new BorderLayout());
		scrollPaneContainer.setPreferredSize(new Dimension(100, 100)); // Tamaño deseado del JScrollPane

		// Crear el panel que contendrá las partes
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		// Agregar las partes al panel central
		for (int i = 0; i < 20; i++) { // Agregamos más partes para demostrar el funcionamiento del scrollbar
			JPanel panel = createPanel();
			centerPanel.add(panel);
			centerPanel.add(Box.createVerticalStrut(50)); // Separación entre las partes
		}

		// Crear JScrollPane para el panel central
		JScrollPane scrollPane = new JScrollPane(centerPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	    // Ajustar el tamaño del JScrollPane
	    scrollPane.setPreferredSize(new Dimension(200, 400));
	    
		// Agregar el JScrollPane al panel interno
		scrollPaneContainer.add(scrollPane, BorderLayout.CENTER);

		// Agregar el panel interno al panel principal
		mainPanel.add(scrollPaneContainer, BorderLayout.CENTER);

		getContentPane().add(mainPanel);
		pack();
		setLocationRelativeTo(null);
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
