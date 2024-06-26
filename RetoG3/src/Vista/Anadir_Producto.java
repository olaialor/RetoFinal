package Vista;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import Modelo.Producto;
import Modelo.Usuario;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Anadir_Producto extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPaneStock;
	private JTextField textFieldPrecio;
	private JTextField textFieldRutaFoto;
	private JLabel lblRutaFoto;
	private JLabel lblDescripcionProd;
	private JLabel lblPrecio;
	private JTextArea textPaneDescripcionProd;
	private JComboBox<String> comboBoxNombrePer;
	private JLabel lblNombrePer;
	private JSpinner spinnerStock;
	private JLabel lblStock;
	private JButton btnAnadir;
	private JButton btnCancelar;
	private Controlador controlador;
	private JLabel lblNewLabel;
	private Usuario usuario;
	private Paneles paneles;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Anadir_Producto(Controlador controlador, Paneles paneles, Usuario usuario) {
		this.controlador = controlador;
		this.usuario=usuario;
		this.paneles=paneles;
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Anadir_Producto.class.getResource("/Imagenes/LazoHelloKitty.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		contentPaneStock = new JPanel();
		contentPaneStock.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneStock);
		contentPaneStock.setLayout(null);

		textFieldPrecio = new JTextField();
		textFieldPrecio.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		textFieldPrecio.setBounds(51, 186, 255, 41);
		contentPaneStock.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);

		lblPrecio = new JLabel("Precio Producto");
		lblPrecio.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
		lblPrecio.setBounds(51, 142, 193, 23);
		contentPaneStock.add(lblPrecio);

		textFieldRutaFoto = new JTextField();
		textFieldRutaFoto.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		textFieldRutaFoto.setColumns(10);
		textFieldRutaFoto.setBounds(510, 186, 507, 41);
		contentPaneStock.add(textFieldRutaFoto);

		lblRutaFoto = new JLabel("Ruta Foto");
		lblRutaFoto.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
		lblRutaFoto.setBounds(510, 142, 193, 23);
		contentPaneStock.add(lblRutaFoto);

		lblDescripcionProd = new JLabel("Descripción Producto");
		lblDescripcionProd.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
		lblDescripcionProd.setBounds(51, 272, 227, 23);
		contentPaneStock.add(lblDescripcionProd);

		textPaneDescripcionProd = new JTextArea();
		textPaneDescripcionProd.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		textPaneDescripcionProd.setBounds(51, 318, 652, 184);
		contentPaneStock.add(textPaneDescripcionProd);

		comboBoxNombrePer = new JComboBox<String>();
		comboBoxNombrePer.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		comboBoxNombrePer.setBounds(50, 68, 255, 41);
		contentPaneStock.add(comboBoxNombrePer);
		ArrayList<String> miUserLista=controlador.completarNombrePer();
		for(String str : miUserLista) {
			comboBoxNombrePer.addItem(str);
		}
		

		lblNombrePer = new JLabel("Nombre Personaje");
		lblNombrePer.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
		lblNombrePer.setBounds(50, 30, 193, 23);
		contentPaneStock.add(lblNombrePer);

		spinnerStock = new JSpinner();
		spinnerStock.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		spinnerStock.setBounds(50, 584, 255, 41);
		contentPaneStock.add(spinnerStock);

		lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
		lblStock.setBounds(50, 541, 193, 23);
		contentPaneStock.add(lblStock);

		btnAnadir = new JButton("Añadir");
		btnAnadir.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		btnAnadir.setBounds(1060, 630, 152, 41);
		btnAnadir.setBackground(new Color(255, 220, 230));
		contentPaneStock.add(btnAnadir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		btnCancelar.setBounds(856, 630, 152, 41);
		btnCancelar.setBackground(new Color(255, 220, 230));
		contentPaneStock.add(btnCancelar);
		
		lblRutaFoto = new JLabel("/Imagen/ruta_foto.jpg");
		lblRutaFoto.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
		lblRutaFoto.setBounds(620, 143, 255, 23);
		lblRutaFoto.setForeground(new Color(100, 100, 100));
		contentPaneStock.add(lblRutaFoto);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Anadir_Producto.class.getResource("/Imagenes/fondo_Añadir2.jpg")));
		lblNewLabel.setBounds(-42, -21, 1352, 792);
		contentPaneStock.add(lblNewLabel);
		
		
		
		btnAnadir.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UIManager.put("OptionPane.background", new Color(160, 202, 238));
		UIManager.put("Panel.background", new Color(160, 202, 238));
		UIManager.put("OptionPane.messageForeground", Color.BLACK);
		UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style", Font.PLAIN, 16));
		boolean correcto=true;
		double precio=0.0;
		if (e.getSource().equals(btnAnadir)) {
			String personaje= (String) comboBoxNombrePer.getSelectedItem();
			try {
			    precio = Double.parseDouble(textFieldPrecio.getText());
			} catch (NumberFormatException e1) {
			   
			    JOptionPane.showMessageDialog(null, "Por favor ingresa un precio válido.", "Error", JOptionPane.ERROR_MESSAGE);
			    correcto=false;
			}
			if (correcto) {
				String ruta=textFieldRutaFoto.getText();
				String descripcion=textPaneDescripcionProd.getText();
				int stock= (int) spinnerStock.getValue();
				int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas añadir este producto?",
						"Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

				if (opcion == JOptionPane.OK_OPTION) {
					Producto producto= new Producto(personaje, controlador.nuevoCodigoProd(), precio, descripcion, stock, ruta);
					controlador.añadirProducto(producto);
					paneles.refrescarTienda(controlador,usuario);
					JOptionPane.showMessageDialog(this, "Producto añadido correctamente.", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado", JOptionPane.ERROR_MESSAGE);
				}
			} else if (e.getSource().equals(btnCancelar)) {
				JOptionPane.showMessageDialog(this, "Precio no válido.", "Cancelado", JOptionPane.ERROR_MESSAGE);
			}
			}
			
	}
}