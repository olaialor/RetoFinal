package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
import Controlador.Controlador;
import Modelo.Personaje;

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
	private JLabel lblNewLabel;
    private JButton btnAnadir;
    private JButton btnCancelar;
    private Controlador l;
    private JTextField textFieldCumpleaños;

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
        contentPane.add(textPaneDescrip);

        lblCuriosidad = new JLabel("Curiosidad");
        lblCuriosidad.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
        lblCuriosidad.setBounds(614, 176, 193, 23);
        contentPane.add(lblCuriosidad);

        textPaneCuriosidad = new JTextPane();
        textPaneCuriosidad.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
        textPaneCuriosidad.setBounds(614, 221, 464, 172);
        contentPane.add(textPaneCuriosidad);

        lblCumpleaos = new JLabel("Cumpleaños (aaaa-MM-dd)");
        lblCumpleaos.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
        lblCumpleaos.setBounds(39, 438, 285, 23);
        contentPane.add(lblCumpleaos);

        lblRutaFoto = new JLabel("Ruta Foto");
        lblRutaFoto.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
        lblRutaFoto.setBounds(470, 445, 193, 23);
        contentPane.add(lblRutaFoto);

        textFieldRuta_Foto = new JTextField();
        textFieldRuta_Foto.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
        textFieldRuta_Foto.setColumns(10);
        textFieldRuta_Foto.setBounds(470, 478, 489, 41);
        contentPane.add(textFieldRuta_Foto);

        btnAnadir = new JButton("Añadir");
        btnAnadir.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
        btnAnadir.setBounds(1060, 630, 152, 41);
        contentPane.add(btnAnadir);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
        btnCancelar.setBounds(856, 630, 152, 41);
        contentPane.add(btnCancelar);

        textFieldCumpleaños = new JTextField();
        textFieldCumpleaños.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
        textFieldCumpleaños.setColumns(10);
        textFieldCumpleaños.setBounds(39, 478, 255, 41);
        contentPane.add(textFieldCumpleaños);

        
        lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Añadir_Personaje.class.getResource("/Imagenes/FondoAñadir2.jpg")));
		lblNewLabel.setBounds(-42, -19, 1328, 767);
		contentPane.add(lblNewLabel);

		
        btnAnadir.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
                    String cumpleString = textFieldCumpleaños.getText();
                    LocalDate cumple = LocalDate.parse("2000-01-01");
                    try {
                        cumple = LocalDate.parse(cumpleString);
                    } catch (DateTimeParseException e1) {
                        JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    int opcion = JOptionPane.showConfirmDialog(this,
                            "¿Estás seguro de que deseas añadir este personaje?", "Confirmar",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (opcion == JOptionPane.OK_OPTION) {
                        int codigo = l.nuevoCodigo();
                        Personaje character = new Personaje(nombre, descripcion, cumple, curiosidad, ruta_foto,
                                codigo);
                        l.añadirPersonaje(character);
                        Añadir_Personaje.this.setVisible(false);
                        Añadir_Personaje.this.dispose();
                        try {
                            Paneles frame = new Paneles(l);
                            frame.setVisible(true);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(this, "Personaje añadido correctamente.", "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "El personaje ya existe.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource().equals(btnCancelar)) {
            JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado", JOptionPane.ERROR_MESSAGE);
        }
    }
}
