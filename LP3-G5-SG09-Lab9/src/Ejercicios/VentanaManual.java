package Ejercicios;

import javax.swing.*;
import java.awt.event.*;

public class VentanaManual extends JFrame {
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JButton btnSaludar;

    public VentanaManual() {
        setTitle("Ejemplo desde código");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); 

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 30, 80, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 30, 120, 25);
        add(txtNombre);

        btnSaludar = new JButton("Saludar");
        btnSaludar.setBounds(230, 30, 90, 25);
        add(btnSaludar);

        // Evento del botón
        btnSaludar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                JOptionPane.showMessageDialog(null, "Hola, " + nombre + "!");
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaManual();
    }
}
