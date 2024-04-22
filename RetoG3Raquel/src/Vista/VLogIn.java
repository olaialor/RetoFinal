package Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VLogIn extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField passwordFieldPassword;
	private JPanel panel;
	private JButton btnLogIn;
	private JButton btnSignUp;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VLogIn frame = new VLogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VLogIn() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VLogIn.class.getResource("/Imagenes/LazoHelloKitty.png")));
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
		btnLogIn.setBounds(795, 407, 111, 36);
		panel.add(btnLogIn);
		btnLogIn.setBackground(new Color(255, 255, 255));
		btnLogIn.setForeground(new Color(222, 111, 111));
		btnLogIn.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		btnLogIn.addActionListener(this);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Goudy Old Style", Font.PLAIN, 10));
		textFieldUsername.setBounds(859, 263, 186, 26);
		panel.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setFont(new Font("Goudy Old Style", Font.PLAIN, 10));
		passwordFieldPassword.setBounds(859, 327, 186, 26);
		panel.add(passwordFieldPassword);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(675, 327, 174, 21);
		panel.add(lblPassword);
		lblPassword.setForeground(new Color(222, 111, 111));
		lblPassword.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		
		lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(675, 264, 174, 21);
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
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(247, 34, 167));
		lblNewLabel.setFont(new Font("Goudy Old Style", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(763, 376, 174, 21);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(VLogIn.class.getResource("/Imagenes/logo.png")));
		lblNewLabel_1.setBounds(617, 60, 428, 140);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(VLogIn.class.getResource("/Imagenes/_4247bce1-b5e4-468a-95a6-801ab99ed523.jpeg")));
		lblNewLabel_2.setBounds(315, 0, 1250, 781);
		panel.add(lblNewLabel_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnSignUp) {
			VLogIn.this.setVisible(false);
			VLogIn.this.dispose();
			try {
				SignUp frame = new SignUp();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		// TODO Auto-generated method stub
		
	}
	
}
