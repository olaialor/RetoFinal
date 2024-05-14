package Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Controlador.Controlador;
import Modelo.Usuario;

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
	private JLabel lblLogo;
	private JLabel lblFondo;
	private Controlador controlador;
	private JButton btnRevelar;
	private JButton btnOcultar;
	private Usuario usuario;

	/**
	 * Create the frame.
	 */
	public LogIn(Controlador controlador) {
		this.controlador = controlador;
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
		btnLogIn.setBounds(776, 443, 111, 36);
		panel.add(btnLogIn);
		btnLogIn.setBackground(new Color(255, 255, 255));
		btnLogIn.setForeground(new Color(222, 111, 111));
		btnLogIn.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		btnLogIn.addActionListener(this);

		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		textFieldUsername.setBounds(833, 272, 186, 26);
		panel.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		passwordFieldPassword.setBounds(833, 336, 186, 26);
		panel.add(passwordFieldPassword);

		lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(649, 336, 174, 21);
		panel.add(lblPassword);
		lblPassword.setForeground(new Color(222, 111, 111));
		lblPassword.setFont(new Font("Goudy Stout", Font.PLAIN, 15));

		lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(649, 273, 174, 21);
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
		lblError.setForeground(new Color(222, 111, 111));
		lblError.setFont(new Font("Goudy Old Style", Font.PLAIN, 16));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(745, 397, 174, 36);
		panel.add(lblError);

		btnRevelar = new JButton("");
		btnRevelar.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/ojo1.png")));
		btnRevelar.addActionListener(this);
		btnRevelar.setBounds(1029, 336, 34, 26);
		btnRevelar.setBackground(new Color(255, 255, 255));
		panel.add(btnRevelar);

		btnOcultar = new JButton("");
		btnOcultar.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/esconder.png")));
		btnOcultar.addActionListener(this);
		btnOcultar.setBounds(1029, 336, 34, 26);
		panel.add(btnOcultar);
		btnOcultar.setBackground(new Color(255, 255, 255));
		btnOcultar.setVisible(false);

		lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/logo.png")));
		lblLogo.setBounds(617, 60, 428, 140);
		panel.add(lblLogo);

		lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/Fondo_Inicio.jpeg")));
		lblFondo.setBounds(315, 0, 1250, 781);
		panel.add(lblFondo);

		InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = panel.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "clickSignUp");
		actionMap.put("clickSignUp", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				btnLogIn.doClick();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == btnRevelar) {

			passwordFieldPassword.setEchoChar((char) 0);
			btnOcultar.setVisible(true);
			btnRevelar.setVisible(false);

		} else if (source == btnOcultar) {

			passwordFieldPassword.setEchoChar('\u2022');
			btnOcultar.setVisible(false);
			btnRevelar.setVisible(true);
		}
		if (source == btnSignUp) {
			
			LogIn.this.setVisible(false);
			LogIn.this.dispose();
			try {
				SignUp frame = new SignUp(controlador, usuario);
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		Object os = e.getSource();
		if (os == btnLogIn) {
			Usuario usuario = controlador.logIn(textFieldUsername.getText(), new String(passwordFieldPassword.getPassword()));

			if (usuario != null) {
				lblError.setText("ok");
				Paneles paneles = new Paneles(controlador, usuario);
				paneles.setVisible(true);
				dispose();
			} else {
				lblError.setText("ERROR, Inserta de nuevo");
			}
		}
	}

}