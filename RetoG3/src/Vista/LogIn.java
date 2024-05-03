package Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Controlador.Controlador;
import Modelo.Cliente;

public class LogIn extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField passwordFieldPassword;
	private JPanel panel;
	private JButton btnLogIn;
	private JButton btnSignUp;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JLabel lblError;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private Controlador l;
	private JButton btnRevelar;
	private JButton btnOcultar;
	private Cliente c;

	/**
	 * Create the frame.
	 */
	public LogIn(Controlador c, Cliente cliente) {
		this.l = c;
		this.c=cliente;
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogIn.class.getResource("/Imagenes/LazoHelloKitty.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 713);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(254, 190, 253));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(-348, 0, 1277, 676);
		contentPane.add(panel);
		panel.setLayout(null);

		btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(780, 441, 111, 36);
		panel.add(btnLogIn);
		btnLogIn.setBackground(new Color(255, 255, 255));
		btnLogIn.setForeground(new Color(222, 111, 111));
		btnLogIn.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		btnLogIn.addActionListener(this);

		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		textFieldUsername.setBounds(833, 297, 186, 26);
		panel.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		passwordFieldPassword.setBounds(833, 361, 186, 26);
		panel.add(passwordFieldPassword);

		lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(649, 361, 174, 21);
		panel.add(lblPassword);
		lblPassword.setForeground(new Color(222, 111, 111));
		lblPassword.setFont(new Font("Goudy Stout", Font.PLAIN, 15));

		lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(649, 298, 174, 21);
		panel.add(lblUsername);
		lblUsername.setForeground(new Color(222, 111, 111));
		lblUsername.setFont(new Font("Goudy Stout", Font.PLAIN, 15));

		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(1048, 572, 111, 36);
		panel.add(btnSignUp);
		btnSignUp.setBackground(new Color(255, 255, 255));
		btnSignUp.setForeground(new Color(222, 111, 111));
		btnSignUp.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
		btnSignUp.addActionListener(this);

		lblError = new JLabel("");
		lblError.setForeground(new Color(247, 34, 167));
		lblError.setFont(new Font("Goudy Old Style", Font.PLAIN, 16));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(737, 410, 174, 21);
		panel.add(lblError);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/logo.png")));
		lblNewLabel_1.setBounds(617, 110, 428, 140);
		panel.add(lblNewLabel_1);

		btnRevelar = new JButton("");
		btnRevelar.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/ojo1.png")));
		btnRevelar.addActionListener(this);
		btnRevelar.setBounds(1029, 361, 34, 26);
		btnRevelar.setBackground(new Color(255, 255, 255));
		panel.add(btnRevelar);
		

		btnOcultar = new JButton("");
		btnOcultar.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/esconder.png")));
		btnOcultar.addActionListener(this);
		btnOcultar.setBounds(1029, 361, 34, 26);
		panel.add(btnOcultar);
		btnOcultar.setBackground(new Color(255, 255, 255));
		btnOcultar.setVisible(false);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/Fondo_Inicio.jpeg")));
		lblNewLabel_2.setBounds(315, 0, 993, 908);
		panel.add(lblNewLabel_2);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean passwordVisible = true;
		Object source = e.getSource();

		if (source == btnRevelar) {

			passwordFieldPassword.setEchoChar((char) 0);
			btnOcultar.setVisible(true);
			btnRevelar.setVisible(false);

		}else if (source == btnOcultar) {
			
			passwordFieldPassword.setEchoChar('\u2022');
			btnOcultar.setVisible(false);
			btnRevelar.setVisible(true);
		}
		if (source == btnSignUp) {
			// Ocultar el marco actual y abrir el marco de registro
			LogIn.this.setVisible(false);
			LogIn.this.dispose();
			try {
				SignUp frame = new SignUp(l,c);
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		Object os = e.getSource();
		if (os == btnLogIn) {
			Cliente u = l.logIn(textFieldUsername.getText(), new String(passwordFieldPassword.getPassword()));
			if (u != null) {
				lblError.setText("ok");
				boolean administrador = false;
				administrador = l.buscarusuario(u.getUsername());

				Paneles paneles = new Paneles(l, administrador, u);
				paneles.setVisible(true);
				dispose();
			} else {
				lblError.setText("ERROR, Inserta de nuevo");
			}
		}

	}
}