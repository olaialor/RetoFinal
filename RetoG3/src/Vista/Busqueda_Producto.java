package Vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

public class Busqueda_Producto extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Busqueda_Producto().setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda_Producto() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Busqueda_Producto.class.getResource("/Imagenes/LazoHelloKitty.png")));
		setTitle("Aplicación con Pestañas"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 768);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setPreferredSize(new Dimension(400,400));

		scrollPane = new JScrollPane();
		scrollPane.setBounds(156, 81, 892, 546);
		getContentPane().add(scrollPane);

	}
	private JScrollPane createPanel() {

		// Agregar imagen a la izquierda
		ImageIcon icon = new ImageIcon("ruta/a/imagen.png"); // Cambiar la ruta por la ruta de tu imagen
		JLabel imageLabel = new JLabel(icon);
		scrollPane.add(imageLabel, BorderLayout.WEST);

		// Agregar JLabel en el centro
		JLabel label = new JLabel("Texto del label");
		label.setHorizontalAlignment(JLabel.CENTER);
		scrollPane.add(label, BorderLayout.CENTER);

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
		scrollPane.add(button, BorderLayout.SOUTH);

		return scrollPane;
	}
}