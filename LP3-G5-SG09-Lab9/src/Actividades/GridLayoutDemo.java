package Actividades;
import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo extends JFrame {
    public GridLayoutDemo() {
        setTitle("GridLayout - Integrantes: Leonardo D. Cornejo Velarde");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 3, 10, 10));

        add(new JButton("Botón 1"));
        add(new JButton("Botón 2"));
        add(new JButton("Botón 3"));
        add(new JButton("Botón 4"));
        add(new JButton("Botón 5"));
        add(new JButton("Botón 6"));

        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutDemo();
    }
}
