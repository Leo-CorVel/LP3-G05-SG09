package Ejercicio1;
//Ejercicio 1
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GestionProducto extends JFrame {

    private JTextField txtNombre, txtPrecio, txtStock, txtCategoria;
    private JButton btnActualizar;
    private JLabel lblResultado;
    private Producto producto;

    public GestionProducto() {

        super("Gestión de Producto - Java Swing");
        producto = new Producto();
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Nombre del Producto:"));
        txtNombre = new JTextField();
        add(txtNombre);
        add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        add(txtPrecio);
        add(new JLabel("Cantidad en Stock:"));
        txtStock = new JTextField();
        add(txtStock);
        add(new JLabel("Categoría:"));
        txtCategoria = new JTextField();
        add(txtCategoria);

        btnActualizar = new JButton("Actualizar Producto");
        add(btnActualizar);

        lblResultado = new JLabel("Datos del producto aparecerán aquí");
        add(lblResultado);

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();
            }
        });

        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void actualizarProducto() {
        try {
            producto.setNombre(txtNombre.getText());
            producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
            producto.setCantidadStock(Integer.parseInt(txtStock.getText()));
            producto.setCategoria(txtCategoria.getText());

            lblResultado.setText(producto.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: Precio o Stock no tienen formato numérico.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        new GestionProducto();
    }
}
