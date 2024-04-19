package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import Controlador.Controlador;

public class SignUp extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTelefono;
	private JTextField textFieldUsername;
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_3;
	private JButton btnSignUp;
	private JLabel lblNewLabel;
	private JButton btnLogIn;
	private Controlador l;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public SignUp(Controlador c) {
		this.l=c;
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/Imagenes/LazoHelloKitty.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 713);
		contentPane = new JPanel();
		contentPane.setBounds(-348, 0, 1277, 676);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground (new Color(222, 111, 111));
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblUsername.setBounds(359, 189, 158, 19);
		contentPane.add(lblUsername);
		
		JLabel lblTelf = new JLabel("Teléfono:");
		lblTelf.setForeground (new Color(222, 111, 111));
		lblTelf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelf.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblTelf.setBounds(359, 234, 158, 13);
		contentPane.add(lblTelf);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground (new Color(222, 111, 111));
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblEmail.setBounds(406, 275, 111, 13);
		contentPane.add(lblEmail);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setForeground (new Color(222, 111, 111));
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblDireccion.setBounds(359, 316, 158, 13);
		contentPane.add(lblDireccion);
		
		JLabel lblNewLabel_6 = new JLabel("Nº de cuenta:");
		lblNewLabel_6.setForeground (new Color(222, 111, 111));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(296, 359, 221, 13);
		contentPane.add(lblNewLabel_6);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(527, 230, 158, 24);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		JLabel lblContraseña2 = new JLabel("Contraseña:");
		lblContraseña2.setForeground (new Color(222, 111, 111));
		lblContraseña2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseña2.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblContraseña2.setBounds(326, 443, 191, 13);
		contentPane.add(lblContraseña2);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(527, 188, 158, 24);
		contentPane.add(textFieldUsername);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(527, 270, 158, 26);
		contentPane.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(527, 312, 158, 24);
		contentPane.add(textField_2);
		
		JLabel lblContraseña1 = new JLabel("Contraseña:");
		lblContraseña1.setForeground(new Color(222, 111, 111));
		lblContraseña1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseña1.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblContraseña1.setBounds(326, 402, 191, 13);
		contentPane.add(lblContraseña1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(527, 438, 158, 25);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(527, 398, 158, 23);
		contentPane.add(passwordField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(527, 354, 158, 24);
		contentPane.add(textField_3);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(440, 497, 131, 31);
		contentPane.add(btnSignUp);
		btnSignUp.setBackground(new Color(255, 255, 255));
		btnSignUp.setForeground(new Color(222, 111, 111));
		btnSignUp.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
		btnSignUp.addActionListener(this);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(247, 34, 167));
		lblNewLabel.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblNewLabel.setBounds(410, 497, 191, 13);
		contentPane.add(lblNewLabel);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setBackground(new Color(255, 255, 255));
		btnLogIn.setForeground(new Color(222, 111, 111));
		btnLogIn.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
		btnLogIn.addActionListener(this);
		btnLogIn.setBounds(716, 566, 111, 36);
		contentPane.add(btnLogIn);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon(SignUp.class.getResource("/Imagenes/logo.png")));
		lblNewLabel_1_1.setBounds(303, 39, 428, 140);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(SignUp.class.getResource("/Imagenes/Fondo_Inicio.jpeg")));
		lblNewLabel_1.setBounds(0, 0, 1250, 781);
		contentPane.add(lblNewLabel_1);
		
		
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
			
		}
	}
}
