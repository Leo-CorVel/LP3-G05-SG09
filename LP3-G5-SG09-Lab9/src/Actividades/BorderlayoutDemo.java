package Actividades;
import javax.swing.*;
import java.awt.*;

public class BorderlayoutDemo extends JFrame {
    public BorderlayoutDemo() {
        setTitle("BorderLayout - Integrantes: Leonardo D. Cornejo Velarde");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        add(new JButton("Norte"), BorderLayout.NORTH);
        add(new JButton("Sur"), BorderLayout.SOUTH);
        add(new JButton("Este"), BorderLayout.EAST);
        add(new JButton("Oeste"), BorderLayout.WEST);
        add(new JButton("Centro"), BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderlayoutDemo();
    }
}
