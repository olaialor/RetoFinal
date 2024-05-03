package Vista;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controlador.Controlador;
import Modelo.Cliente;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Usuario extends JFrame implements ActionListener {

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
	private JTextField textFieldUsuario;
	private JTextField textFieldTelf;
	private JTextField textFieldEmail;
	private JTextField textFieldCuenta;
	private JPasswordField passwordField;
	private JLabel lblDireccin;
	private JTextField textFieldDirec;
	private Cliente c;

	public Usuario(Controlador c, Cliente cliente) {
		this.l = c;
		this.c=cliente;
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
		lblPerfil.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/ImagenPerfil.png")));
		lblPerfil.setBounds(31, 62, 250, 260);
		contentPane.add(lblPerfil);

		lblHeader = new JLabel("");
		lblHeader.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/HeaderUsuario.jpg")));
		lblHeader.setBounds(0, 0, 1331, 190);
		contentPane.add(lblHeader);

		lblUsuario = new JLabel("Nombre de usuario");
		lblUsuario.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		lblUsuario.setBounds(291, 200, 210, 35);
		contentPane.add(lblUsuario);

		lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		lblContraseña.setBounds(59, 364, 172, 52);
		contentPane.add(lblContraseña);

		lblTelf = new JLabel("Num. telefono");
		lblTelf.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		lblTelf.setBounds(482, 367, 204, 46);
		contentPane.add(lblTelf);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		lblEmail.setBounds(59, 525, 172, 52);
		contentPane.add(lblEmail);

		lblCuenta = new JLabel("Num. cuenta");
		lblCuenta.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		lblCuenta.setBounds(482, 525, 172, 52);
		contentPane.add(lblCuenta);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		btnAceptar.setBackground(new Color(255, 220, 230));
		btnAceptar.setBounds(1071, 637, 152, 41);
		contentPane.add(btnAceptar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		btnModificar.setBackground(new Color(255, 220, 230));
		btnModificar.setBounds(855, 637, 152, 41);
		contentPane.add(btnModificar);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		textFieldUsuario.setBounds(291, 245, 277, 35);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		textFieldTelf = new JTextField();
		textFieldTelf.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		textFieldTelf.setColumns(10);
		textFieldTelf.setBounds(482, 423, 277, 35);
		contentPane.add(textFieldTelf);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(59, 584, 277, 35);
		contentPane.add(textFieldEmail);

		textFieldCuenta = new JTextField();
		textFieldCuenta.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		textFieldCuenta.setColumns(10);
		textFieldCuenta.setBounds(482, 587, 277, 35);
		contentPane.add(textFieldCuenta);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		passwordField.setBounds(59, 423, 277, 35);
		contentPane.add(passwordField);
		
		lblDireccin = new JLabel("Dirección");
		lblDireccin.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		lblDireccin.setBounds(883, 367, 204, 46);
		contentPane.add(lblDireccin);
		
		textFieldDirec = new JTextField();
		textFieldDirec.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		textFieldDirec.setColumns(10);
		textFieldDirec.setBounds(885, 423, 277, 35);
		contentPane.add(textFieldDirec);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}