package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controlador.Controlador;
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
	private JLabel lblNewLabel;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/Imagenes/giphy.gif")));
		this.l = c;
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 713);
		contentPane = new JPanel();
		contentPane.setBounds(-348, 0, 1277, 676);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setForeground (new Color(222, 111, 111));
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblUsername.setBounds(359, 189, 158, 19);
		contentPane.add(lblUsername);
		
		lblTelf = new JLabel("Teléfono:");
		lblTelf.setForeground (new Color(222, 111, 111));
		lblTelf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelf.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblTelf.setBounds(359, 234, 158, 13);
		contentPane.add(lblTelf);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground (new Color(222, 111, 111));
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblEmail.setBounds(406, 275, 111, 13);
		contentPane.add(lblEmail);
		
		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setForeground (new Color(222, 111, 111));
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblDireccion.setBounds(359, 316, 158, 13);
		contentPane.add(lblDireccion);
		
		lblNewLabel_6 = new JLabel("Nº de cuenta:");
		lblNewLabel_6.setForeground (new Color(222, 111, 111));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(296, 359, 221, 13);
		contentPane.add(lblNewLabel_6);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(527, 230, 158, 24);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		lblContraseña2 = new JLabel("Contraseña:");
		lblContraseña2.setForeground (new Color(222, 111, 111));
		lblContraseña2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseña2.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblContraseña2.setBounds(326, 443, 191, 13);
		contentPane.add(lblContraseña2);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(527, 188, 158, 24);
		contentPane.add(textFieldUsername);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(527, 270, 158, 26);
		contentPane.add(textFieldEmail);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(527, 312, 158, 24);
		contentPane.add(textFieldDireccion);
		
		JLabel lblContraseña1 = new JLabel("Contraseña:");
		lblContraseña1.setForeground(new Color(222, 111, 111));
		lblContraseña1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseña1.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblContraseña1.setBounds(326, 402, 191, 13);
		contentPane.add(lblContraseña1);
		
		passwordFieldContraseña2 = new JPasswordField();
		passwordFieldContraseña2.setBounds(527, 438, 158, 25);
		contentPane.add(passwordFieldContraseña2);
		
		passwordFieldContraseña1 = new JPasswordField();
		passwordFieldContraseña1.setBounds(527, 398, 158, 23);
		contentPane.add(passwordFieldContraseña1);
		
		textFieldNCuenta = new JTextField();
		textFieldNCuenta.setColumns(10);
		textFieldNCuenta.setBounds(527, 354, 158, 24);
		contentPane.add(textFieldNCuenta);
		
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
		
		lblFondo_Inicio = new JLabel("");
		lblFondo_Inicio.setIcon(new ImageIcon(SignUp.class.getResource("/Imagenes/_4247bce1-b5e4-468a-95a6-801ab99ed523.jpeg")));
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
				VLogIn frame = new VLogIn();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}else if (o == btnSignUp) {
			String username= textFieldUsername.getText();
			String email= textFieldEmail.getText();
			int telefono= Integer.valueOf(textFieldTelefono.getText());
			if(!signUp(username, email, telefono )) {
				//
				
				
			}
			
			
			
			
		}
	}

	
	public boolean signUp(String username, String email, int telefono) {
		
	   
	    if (Controlador.existeUsuario(username)) {
	        
	        lblNewLabel.setText("Nombre no disponible, pruebe con otro");
	        return true;
	    }

	    if (Controlador.existeEmail(email)) {
	       
	        lblNewLabel.setText("El correo electrónico ya está registrado.");
	        return false;
	    }

	   
	    if (Controlador.existeTelefono(telefono)) {
	       
	        lblNewLabel.setText("El número de teléfono ya está registrado.");
	        return false;
	    }
	    return true;
	}

	


}
