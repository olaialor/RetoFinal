package Vista;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class VPersonaje extends JFrame implements ActionListener{

    public VPersonaje() {
        setTitle("Ejemplo de GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Crear el panel que contendrá las partes
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        
        // Agregar las partes al panel central
        for (int i = 0; i < 20; i++) { // Agregamos más partes para demostrar el funcionamiento del scrollbar
            JPanel panel = createPanel();
            centerPanel.add(panel);
            centerPanel.add(Box.createVerticalStrut(20)); // Separación entre las partes
        }

        // Crear JScrollPane para el panel central
        JScrollPane scrollPane = new JScrollPane(centerPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Configurar el JScrollPane
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        getContentPane().add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    protected void prueba() {
		// TODO Auto-generated method stub
		
	}

	private JPanel createPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Agregar imagen a la izquierda
        ImageIcon icon = new ImageIcon("ruta/a/imagen.png"); // Cambiar la ruta por la ruta de tu imagen
        JLabel imageLabel = new JLabel(icon);
        panel.add(imageLabel, BorderLayout.WEST);

        // Agregar JLabel en el centro
        JLabel label = new JLabel("Texto del label");
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label, BorderLayout.CENTER);

        // Agregar JButton debajo del JLabel
        JButton button = new JButton("Botón");
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción del botón
                JOptionPane.showMessageDialog(null, "Lolo.");
            }
        });
        panel.add(button, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VPersonaje().setVisible(true);
            }
        });
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
