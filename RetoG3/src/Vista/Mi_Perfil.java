package Vista;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import Modelo.Cliente;
import Modelo.Usuario;

import java.awt.Color;
import java.awt.Font;

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
	private Controlador controlador;
	private JTextField textFieldUsuario;
	private JTextField textFieldTelf;
	private JTextField textFieldEmail;
	private JTextField textFieldCuenta;
	private JPasswordField passwordField;
	private JLabel lblDireccin;
	private JTextField textFieldDirec;
	private Cliente usuario;
	private JButton btnDarseDeBaja;
	private Paneles paneles;

	public Mi_Perfil(Controlador c, Usuario usuario, Paneles paneles) {
		this.controlador = controlador;
		this.paneles = paneles;
		this.usuario = (Cliente) usuario;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mi_Perfil.class.getResource("/Imagenes/LazoHelloKitty.png")));
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

		lblUsuario = new JLabel(usuario.getUsername());
		lblUsuario.setFont(new Font("Goudy Stout", Font.PLAIN, 19));
		lblUsuario.setBounds(291, 200, 262, 52);
		contentPane.add(lblUsuario);

		lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		lblContraseña.setBounds(59, 364, 172, 52);
		contentPane.add(lblContraseña);

		lblTelf = new JLabel("Num. telefono");
		lblTelf.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		lblTelf.setBounds(482, 342, 204, 46);
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
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		btnModificar.setBackground(new Color(255, 220, 230));
		btnModificar.setBounds(857, 641, 152, 41);
		btnModificar.addActionListener(this);
		contentPane.add(btnModificar);

		textFieldEmail = new JTextField(usuario.getEmail());
		textFieldEmail.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(59, 562, 277, 35);
		contentPane.add(textFieldEmail);

		textFieldCuenta = new JTextField(((Cliente) usuario).getN_cuenta());
		textFieldCuenta.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		textFieldCuenta.setColumns(10);
		textFieldCuenta.setBounds(482, 565, 277, 35);
		contentPane.add(textFieldCuenta);

		passwordField = new JPasswordField(usuario.getPassword());
		passwordField.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		passwordField.setBounds(59, 401, 277, 35);
		contentPane.add(passwordField);

		lblDireccin = new JLabel("Dirección");
		lblDireccin.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		lblDireccin.setBounds(883, 367, 204, 46);
		contentPane.add(lblDireccin);

		textFieldDirec = new JTextField(usuario.getDireccion());
		textFieldDirec.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		textFieldDirec.setColumns(10);
		textFieldDirec.setBounds(885, 401, 277, 35);
		contentPane.add(textFieldDirec);

		textFieldTelf = new JTextField(usuario.getN_telefono());
		textFieldTelf.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		textFieldTelf.setColumns(10);
		textFieldTelf.setBounds(482, 401, 277, 35);
		textFieldTelf.setText(Integer.toString(usuario.getN_telefono()));
		textFieldTelf.setText(Integer.toString(usuario.getN_telefono()));
		contentPane.add(textFieldTelf);

		btnDarseDeBaja = new JButton("Darse de baja");
		btnDarseDeBaja.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		btnDarseDeBaja.setBackground(new Color(255, 220, 230));
		btnDarseDeBaja.setBounds(1073, 244, 152, 41);
		contentPane.add(btnDarseDeBaja);
		btnDarseDeBaja.addActionListener(this);
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
				String nuevoEmail = textFieldEmail.getText();
				String nuevaCuenta = textFieldCuenta.getText();
				String nuevaContraseña = new String(passwordField.getPassword());
				int nuevoTelefono = Integer.parseInt(textFieldTelf.getText());
				String nuevaDireccion = textFieldDirec.getText();
				boolean cambiosGuardados = controlador.modificarUsuario(usuario.getUsername(), nuevaContraseña, nuevoTelefono,
						nuevoEmail, nuevaDireccion, nuevaCuenta);
				textFieldEmail.setEditable(false);
				textFieldCuenta.setEditable(false);
				passwordField.setEditable(false);
				textFieldTelf.setEditable(false);
				textFieldDirec.setEditable(false);
				JOptionPane.showMessageDialog(null, "Cambios guardados correctamente.", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

			}
		} else if (e.getSource() == btnDarseDeBaja) {
			int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que desea eliminar su cuenta?", "",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			if (confirmacion == JOptionPane.OK_OPTION) {
				controlador.eliminarUsuario(usuario.getUsername());

				try {

					if (confirmacion == JOptionPane.OK_OPTION) {
						controlador.eliminarUsuario(usuario.getUsername());

						try {
							SignUp frame = new SignUp(controlador, usuario);
							frame.setVisible(true);
							
							paneles.CerrarPaneles();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
