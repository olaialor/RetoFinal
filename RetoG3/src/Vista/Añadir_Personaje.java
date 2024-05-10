package Vista;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controlador.Controlador;
import Modelo.Personaje;
import com.toedter.calendar.JCalendar;

public class Añadir_Personaje extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre_Personaje;
	private JTextField textFieldRuta_Foto;
	private JLabel lblNombre;
	private JLabel lblDescripcionPer;
	private JTextPane textPaneDescrip;
	private JLabel lblCuriosidad;
	private JTextPane textPaneCuriosidad;
	private JLabel lblCumpleaos;
	private JLabel lblRutaFoto;
	private JLabel lblFondo;
	private JButton btnAnadir;
	private JButton btnCancelar;
	private Controlador l;
	private JCalendar calendar;
	private JLabel lblFoto;

	public Añadir_Personaje(Controlador c) {
		this.l = c;
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Añadir_Personaje.class.getResource("/Imagenes/LazoHelloKitty.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNombre_Personaje = new JTextField();
		textFieldNombre_Personaje.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		textFieldNombre_Personaje.setColumns(10);
		textFieldNombre_Personaje.setBounds(39, 90, 255, 41);
		textFieldNombre_Personaje.setBorder(new LineBorder(new Color(255, 192, 203)));
		contentPane.add(textFieldNombre_Personaje);

		lblNombre = new JLabel("Nombre Personaje");
		lblNombre.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
		lblNombre.setBounds(39, 43, 193, 23);
		contentPane.add(lblNombre);

		lblDescripcionPer = new JLabel("Descripción");
		lblDescripcionPer.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
		lblDescripcionPer.setBounds(39, 176, 193, 23);
		contentPane.add(lblDescripcionPer);

		textPaneDescrip = new JTextPane();
		textPaneDescrip.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		textPaneDescrip.setBounds(39, 221, 464, 172);
		textPaneDescrip.setBorder(new LineBorder(new Color(255, 192, 203)));
		contentPane.add(textPaneDescrip);

		lblCuriosidad = new JLabel("Curiosidad");
		lblCuriosidad.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
		lblCuriosidad.setBounds(614, 176, 193, 23);
		contentPane.add(lblCuriosidad);

		textPaneCuriosidad = new JTextPane();
		textPaneCuriosidad.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		textPaneCuriosidad.setBounds(614, 221, 464, 172);
		textPaneCuriosidad.setBorder(new LineBorder(new Color(255, 192, 203)));
		contentPane.add(textPaneCuriosidad);

		lblCumpleaos = new JLabel("Cumpleaños");
		lblCumpleaos.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
		lblCumpleaos.setBounds(39, 438, 126, 23);
		contentPane.add(lblCumpleaos);

		lblRutaFoto = new JLabel("Ruta Foto");
		lblRutaFoto.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
		lblRutaFoto.setBounds(470, 445, 193, 23);
		contentPane.add(lblRutaFoto);

		textFieldRuta_Foto = new JTextField();
		textFieldRuta_Foto.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		textFieldRuta_Foto.setColumns(10);
		textFieldRuta_Foto.setBounds(470, 478, 489, 41);
		textFieldRuta_Foto.setBorder(new LineBorder(new Color(255, 192, 203)));
		contentPane.add(textFieldRuta_Foto);
		
		calendar = new JCalendar();
		calendar.getDayChooser().getDayPanel().setForeground(new Color(255, 192, 203)); // Color de los números del día
		calendar.setDecorationBackgroundColor(new Color(255, 192, 203)); // Color de fondo decorativo
		calendar.setDecorationBordersVisible(false); // Ocultar bordes decorativos
		calendar.setBounds(39, 471, 255, 180); // Posición y tamaño
		calendar.setBorder(new LineBorder(new Color(255, 192, 203)));
		contentPane.add(calendar);



		btnAnadir = new JButton("Añadir");
		btnAnadir.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		btnAnadir.setBounds(1060, 630, 152, 41);
		btnAnadir.setBackground(new Color(255, 220, 230)); // Establecer el color de fondo rosa
		contentPane.add(btnAnadir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		btnCancelar.setBounds(856, 630, 152, 41);
		btnCancelar.setBackground(new Color(255, 220, 230)); 
		contentPane.add(btnCancelar);
		
		lblFoto = new JLabel("/Imagen/nombre_foto.png");
		lblFoto.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblFoto.setBounds(588, 438, 204, 41);
		contentPane.add(lblFoto);
		
		lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon(Añadir_Personaje.class.getResource("/Imagenes/fondo_Añadir2.jpg")));
		lblFondo.setBounds(-42, -19, 1328, 767);
		contentPane.add(lblFondo);
		
		
		
		

		btnAnadir.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
	    UIManager.put("OptionPane.background", new Color(160, 202, 238));
	    UIManager.put("Panel.background", new Color(160, 202, 238));
	    UIManager.put("OptionPane.messageForeground", Color.BLACK);
	    UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style", Font.PLAIN, 16));
	    
	    if (e.getSource().equals(btnAnadir)) {
	        String nombre = textFieldNombre_Personaje.getText();
	        if (!l.existePersonaje(nombre)) {
	            String descripcion = textPaneDescrip.getText();
	            String curiosidad = textPaneCuriosidad.getText();
	            String ruta_foto = String.valueOf(textFieldRuta_Foto.getText());
	            
	            Date cumple = calendar.getDate();
	            
	            // Verificar que cumple no sea null antes de establecerlo en el JCalendar
	            if (cumple != null) {
	                calendar.setDate(cumple);
	            } else {
	                // Si cumple es null, podrías establecer una fecha predeterminada o mostrar un mensaje de advertencia al usuario.
	                JOptionPane.showMessageDialog(this, "Por favor, selecciona una fecha de cumpleaños.", "Error", JOptionPane.ERROR_MESSAGE);
	                return; // Salir del método si la fecha de cumpleaños es nula
	            }
	            
	            int opcion = JOptionPane.showConfirmDialog(this,
	                    "¿Estás seguro de que deseas añadir este personaje?", "Confirmar",
	                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

	            if (opcion == JOptionPane.OK_OPTION) {
	                int codigo = l.nuevoCodigoPer();
	                Personaje character = new Personaje(nombre, descripcion, cumple, curiosidad, ruta_foto, codigo);
	                l.añadirPersonaje(character);

	                JOptionPane.showMessageDialog(this, "Personaje añadido correctamente.", "Éxito",JOptionPane.INFORMATION_MESSAGE);
	                
	                // Limpiar los campos después de añadir el personaje
	                textFieldNombre_Personaje.setText("");
	                textPaneDescrip.setText("");
	                textPaneCuriosidad.setText("");
	                textFieldRuta_Foto.setText("");
	                
	                                
	            } else {
	                JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado",
	                        JOptionPane.ERROR_MESSAGE);
	            }

	        } else {
	            JOptionPane.showMessageDialog(this, "El personaje ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } else if (e.getSource().equals(btnCancelar)) {
	        JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado", JOptionPane.ERROR_MESSAGE);
	    }
=======
		UIManager.put("OptionPane.background", new Color(160, 202, 238));
		UIManager.put("Panel.background", new Color(160, 202, 238));
		UIManager.put("OptionPane.messageForeground", Color.BLACK);
		UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style", Font.PLAIN, 16));
		if (e.getSource().equals(btnAnadir)) {
			String nombre = textFieldNombre_Personaje.getText();
			try {
				if (!l.existePersonaje(nombre)) {
					String descripcion = textPaneDescrip.getText();
					String curiosidad = textPaneCuriosidad.getText();
					String ruta_foto = String.valueOf(textFieldRuta_Foto.getText());
					
					Date cumple = calendar.getDate();
					
					int opcion = JOptionPane.showConfirmDialog(this,
							"¿Estás seguro de que deseas añadir este personaje?", "Confirmar",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

					if (opcion == JOptionPane.OK_OPTION) {
						int codigo = l.nuevoCodigo();
						Personaje character = new Personaje(nombre, descripcion, cumple, curiosidad, ruta_foto, codigo);
						l.añadirPersonaje(character);

						JOptionPane.showMessageDialog(this, "Personaje añadido correctamente.", "Éxito",JOptionPane.INFORMATION_MESSAGE);
						 try {
							Paneles.tabbedPane.setSelectedIndex(0);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} else {
						JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(this, "El personaje ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(btnCancelar)) {
			JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado", JOptionPane.ERROR_MESSAGE);
		}
>>>>>>> 163920fdecd89d119a535956cf511468d78d3def
	}


}