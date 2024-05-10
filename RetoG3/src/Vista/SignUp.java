package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Controlador.Controlador;
import Modelo.Cliente;
import Modelo.Usuario;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class SignUp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTelefono;
	private JTextField textFieldUsername;
	private JTextField textFieldEmail;
	private JTextField textFieldDireccion;
	private JPasswordField passwordFieldContraseña2;
	private JPasswordField passwordFieldContraseña1;
	private JTextField textFieldNCuenta;
	private JButton btnSignUp;
	private JLabel lblError;
	private JButton btnLogIn;
	private JLabel lblUsername;
	private JLabel lblTelf;
	private JLabel lblEmail;
	private JLabel lblDireccion;
	private JLabel lblNewLabel_6;
	private JLabel lblContraseña2;
	private JLabel lblContraseña1;
	private JLabel lblFondo_Inicio;
	private Controlador l;
	private Usuario user;
	private JLabel lblNewLabel;
	private Pattern formatoEmail = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

	public SignUp(Controlador c) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/Imagenes/LazoHelloKitty.png")));
		// setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/Imagenes/giphy.gif")));
		this.l = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 713);
		contentPane = new JPanel();
		contentPane.setBounds(-348, 0, 1277, 676);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(222, 111, 111));
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblUsername.setBounds(370, 249, 158, 19);
		contentPane.add(lblUsername);

		lblTelf = new JLabel("Teléfono:");
		lblTelf.setForeground(new Color(222, 111, 111));
		lblTelf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelf.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblTelf.setBounds(370, 294, 158, 13);
		contentPane.add(lblTelf);

		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(222, 111, 111));
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblEmail.setBounds(417, 335, 111, 13);
		contentPane.add(lblEmail);

		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setForeground(new Color(222, 111, 111));
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblDireccion.setBounds(370, 376, 158, 13);
		contentPane.add(lblDireccion);

		lblNewLabel_6 = new JLabel("Nº de cuenta:");
		lblNewLabel_6.setForeground(new Color(222, 111, 111));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(298, 420, 221, 13);
		contentPane.add(lblNewLabel_6);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		textFieldTelefono.setBounds(538, 290, 158, 24);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);

		lblContraseña2 = new JLabel("Contraseña:");
		lblContraseña2.setForeground(new Color(222, 111, 111));
		lblContraseña2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseña2.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblContraseña2.setBounds(337, 503, 191, 13);
		contentPane.add(lblContraseña2);

		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(538, 248, 158, 24);
		contentPane.add(textFieldUsername);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(538, 330, 158, 26);
		contentPane.add(textFieldEmail);

		textFieldDireccion = new JTextField();
		textFieldDireccion.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(538, 372, 158, 24);
		contentPane.add(textFieldDireccion);

		lblContraseña1 = new JLabel("Contraseña:");
		lblContraseña1.setForeground(new Color(222, 111, 111));
		lblContraseña1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseña1.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblContraseña1.setBounds(337, 462, 191, 13);
		contentPane.add(lblContraseña1);

		passwordFieldContraseña2 = new JPasswordField();
		passwordFieldContraseña2.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		passwordFieldContraseña2.setBounds(538, 498, 158, 25);
		contentPane.add(passwordFieldContraseña2);
		passwordFieldContraseña1 = new JPasswordField();
		passwordFieldContraseña1.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		passwordFieldContraseña1.setBounds(538, 458, 158, 23);
		contentPane.add(passwordFieldContraseña1);

		textFieldNCuenta = new JTextField();
		textFieldNCuenta.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		textFieldNCuenta.setColumns(10);
		textFieldNCuenta.setBounds(538, 414, 158, 24);
		contentPane.add(textFieldNCuenta);

		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(443, 552, 131, 31);
		contentPane.add(btnSignUp);
		btnSignUp.setBackground(new Color(255, 255, 255));
		btnSignUp.setForeground(new Color(222, 111, 111));
		btnSignUp.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
		btnSignUp.addActionListener(this);

		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(new Color(247, 34, 167));
		lblError.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblError.setBounds(337, 521, 349, 33);
		contentPane.add(lblError);

		btnLogIn = new JButton("Log In");
		btnLogIn.setBackground(new Color(255, 255, 255));
		btnLogIn.setForeground(new Color(222, 111, 111));
		btnLogIn.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
		btnLogIn.addActionListener(this);
		btnLogIn.setBounds(716, 566, 111, 36);
		contentPane.add(btnLogIn);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/logo.png")));
		lblNewLabel.setBounds(298, 104, 428, 140);
		contentPane.add(lblNewLabel);

		lblFondo_Inicio = new JLabel("");
		lblFondo_Inicio.setIcon(new ImageIcon(SignUp.class.getResource("/Imagenes/Fondo_Inicio.jpeg")));
		lblFondo_Inicio.setBounds(0, 0, 993, 908);
		contentPane.add(lblFondo_Inicio);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == btnLogIn) {
			SignUp.this.setVisible(false);
			SignUp.this.dispose();
			try {
				LogIn frame = new LogIn(l);
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (o == btnSignUp) {
			String username = textFieldUsername.getText();
			try {
				if (l.existeUsuario(username)) {
					String password2 = new String(passwordFieldContraseña2.getPassword());
					String password1 = new String(passwordFieldContraseña1.getPassword());
					if (password1.equals(password2)) {
						String email = textFieldEmail.getText();
						if (formatoEmail.matcher(email).matches()) {
							int n_telefono = Integer.valueOf(textFieldTelefono.getText());
							String direccion = textFieldDireccion.getText();
							String n_cuenta = textFieldNCuenta.getText();
							Usuario user = new Cliente(username, password1, n_telefono, direccion, email, n_cuenta);
							if (l.SignUp(user)) {
								SignUp.this.setVisible(false);
								SignUp.this.dispose();
								try {
									Paneles frame = new Paneles(l);
									frame.setVisible(true);
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							}
						} else {
							lblError.setText("Formato del email no valido.");
						}
					} else {
						lblError.setText("Error. La contraseña no coincide");
					}
				} else {
					lblError.setText("Error. Ese ussername esta ya registrado.");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}