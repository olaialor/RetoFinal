package Vista;

import java.awt.Toolkit;
import Modelo.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controlador.Controlador;
import Modelo.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class Mi_Perfil extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPerfil;
	private JLabel lblHeader;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JLabel lblTelf;
	private JLabel lblEmail;
	private JLabel lblCuenta;
	private JButton btnAceptar;
	private JButton btnModificar;
	private Controlador l;
	private JTextField textFieldEmail;
	private JTextField textFieldCuenta;
	private JPasswordField passwordField;
	private JLabel lblDireccin;
	private JTextField textFieldDirec;
	private Usuario c;
	private JTextField textFieldTelf;
	private JButton btnDarseDeBaja;


	
	Mi_Perfil(Controlador controlador ) {
		this.l = controlador;

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Añadir_Personaje.class.getResource("/Imagenes/LazoHelloKitty.png")));
		setTitle("Mi perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 245, 248));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPerfil = new JLabel("");
		lblPerfil.setIcon(new ImageIcon(Mi_Perfil.class.getResource("/Imagenes/ImagenPerfil.png")));
		lblPerfil.setBounds(31, 62, 250, 260);
		contentPane.add(lblPerfil);

		lblHeader = new JLabel("");
		lblHeader.setIcon(new ImageIcon(Mi_Perfil.class.getResource("/Imagenes/HeaderUsuario.jpg")));
		lblHeader.setBounds(0, 0, 1331, 190);
		contentPane.add(lblHeader);


		lblUsuario = new JLabel();

		lblUsuario = new JLabel();
		lblUsuario.setFont(new Font("Goudy Stout", Font.PLAIN, 19));
		lblUsuario.setBounds(291, 200, 262, 52);
		contentPane.add(lblUsuario);

		lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		lblContraseña.setBounds(59, 342, 172, 52);
		contentPane.add(lblContraseña);

		lblTelf = new JLabel("Num. telefono");
		lblTelf.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		lblTelf.setBounds(482, 345, 204, 46);
		contentPane.add(lblTelf);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		lblEmail.setBounds(59, 503, 172, 52);
		contentPane.add(lblEmail);

		lblCuenta = new JLabel("Num. cuenta");
		lblCuenta.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		lblCuenta.setBounds(482, 503, 172, 52);
		contentPane.add(lblCuenta);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		btnAceptar.setBackground(new Color(255, 220, 230));
		btnAceptar.setBounds(1073, 641, 152, 41);
		contentPane.add(btnAceptar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		btnModificar.setBackground(new Color(255, 220, 230));
		btnModificar.setBounds(857, 641, 152, 41);
		contentPane.add(btnModificar);


		textFieldEmail = new JTextField();
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(59, 562, 277, 35);
		contentPane.add(textFieldEmail);

		//
		//textFieldCuenta = new JTextField(((Cliente) c).getN_cuenta());
		textFieldCuenta = new JTextField();
		textFieldCuenta.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		textFieldCuenta.setColumns(10);
		textFieldCuenta.setBounds(482, 565, 277, 35);
		contentPane.add(textFieldCuenta);

		passwordField = new JPasswordField();
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		passwordField.setBounds(59, 401, 277, 35);
		contentPane.add(passwordField);

		lblDireccin = new JLabel("Dirección");
		lblDireccin.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		lblDireccin.setBounds(883, 345, 204, 46);
		contentPane.add(lblDireccin);

		textFieldDirec = new JTextField();

		textFieldDirec = new JTextField();

		textFieldDirec.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		textFieldDirec.setColumns(10);
		textFieldDirec.setBounds(885, 401, 277, 35);
		contentPane.add(textFieldDirec);

		textFieldTelf = new JTextField();
		textFieldTelf.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		textFieldTelf.setColumns(10);
		textFieldTelf.setBounds(482, 401, 277, 35);
		//textFieldTelf.setText(Integer.toString(c.getN_telefono()));
		// textFieldTelf.setText(Integer.toString(c.getN_telefono()));
		contentPane.add(textFieldTelf);

		btnDarseDeBaja = new JButton("Darse de baja");
		btnDarseDeBaja.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		btnDarseDeBaja.setBackground(new Color(255, 220, 230));
		btnDarseDeBaja.setBounds(1073, 219, 152, 41);
		contentPane.add(btnDarseDeBaja);

		btnModificar.addActionListener(this);
		btnAceptar.addActionListener(this);
		btnDarseDeBaja.addActionListener(this);

		textFieldEmail.setEditable(false);
		textFieldCuenta.setEditable(false);
		passwordField.setEditable(false);
		textFieldTelf.setEditable(false);
		textFieldDirec.setEditable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			textFieldEmail.setEditable(true);
			textFieldCuenta.setEditable(true);
			passwordField.setEditable(true);
			textFieldTelf.setEditable(true);
			textFieldDirec.setEditable(true);
		} else if (e.getSource() == btnAceptar) {
			int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas guardar los cambios?",
					"Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			if (confirmacion == JOptionPane.OK_OPTION) {
				String nombre= "";
				String nuevoEmail = textFieldEmail.getText();
				String nuevaCuenta = textFieldCuenta.getText();
				String nuevaContraseña = new String(passwordField.getPassword());
				int nuevoTelefono = Integer.parseInt(textFieldTelf.getText());
				String nuevaDireccion = textFieldDirec.getText();
				l.modificarUsuario(nombre, nuevaContraseña, nuevoTelefono, nuevoEmail, nuevaDireccion, nuevaCuenta);
				textFieldEmail.setEditable(false);
				textFieldCuenta.setEditable(false);
				passwordField.setEditable(false);
				textFieldTelf.setEditable(false);
				textFieldDirec.setEditable(false);
			}
		}
	}
}