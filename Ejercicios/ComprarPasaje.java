package Ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComprarPasaje extends JFrame {

    // Componentes
    private JTextField txtNombre, txtDni, txtFecha;
    private JCheckBox chkAudifonos, chkManta, chkRevista;
    private JRadioButton rbtnPiso1, rbtnPiso2;
    private JComboBox<String> cboOrigen, cboDestino;
    private JList<String> lstServicio;
    private JButton btnMostrar, btnLimpiar;
    private ButtonGroup grupoPiso;

    public ComprarPasaje() {
        setTitle("Compra de Pasajes - Empresa de Transporte");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2, 5, 5));
        setLocationRelativeTo(null);

        //Etiquetas y campos de texto
        add(new JLabel("Nombre completo:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Documento de identidad (DNI):"));
        txtDni = new JTextField();
        add(txtDni);

        add(new JLabel("Fecha de viaje (dd/mm/aaaa):"));
        txtFecha = new JTextField();
        add(txtFecha);

        //Casillas de verificación
        add(new JLabel("Servicios opcionales:"));
        JPanel panelOpciones = new JPanel();
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevista = new JCheckBox("Revista");
        panelOpciones.add(chkAudifonos);
        panelOpciones.add(chkManta);
        panelOpciones.add(chkRevista);
        add(panelOpciones);

        //Botones de opción (radio)
        add(new JLabel("Seleccione el piso del bus:"));
        JPanel panelPiso = new JPanel();
        rbtnPiso1 = new JRadioButton("1er Piso");
        rbtnPiso2 = new JRadioButton("2do Piso");
        grupoPiso = new ButtonGroup();
        grupoPiso.add(rbtnPiso1);
        grupoPiso.add(rbtnPiso2);
        panelPiso.add(rbtnPiso1);
        panelPiso.add(rbtnPiso2);
        add(panelPiso);

        //Cuadros combinados (combobox)
        add(new JLabel("Lugar de origen:"));
        cboOrigen = new JComboBox<>(new String[]{"Lima", "Arequipa", "Cusco", "Trujillo", "Piura"});
        add(cboOrigen);

        add(new JLabel("Lugar de destino:"));
        cboDestino = new JComboBox<>(new String[]{"Lima", "Arequipa", "Cusco", "Trujillo", "Piura"});
        add(cboDestino);

        //Lista de servicios
        add(new JLabel("Tipo de servicio:"));
        lstServicio = new JList<>(new String[]{"Económico", "Standard", "VIP"});
        lstServicio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(lstServicio));

        //Botones
        btnMostrar = new JButton("Mostrar resumen");
        btnLimpiar = new JButton("Limpiar todo");
        add(btnMostrar);
        add(btnLimpiar);

        //Eventos
        btnMostrar.addActionListener(e -> mostrarResumen());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        setVisible(true);
    }

    // Método para mostrar los datos en un JOptionPane
    private void mostrarResumen() {
        String nombre = txtNombre.getText();
        String dni = txtDni.getText();
        String fecha = txtFecha.getText();
        String piso = rbtnPiso1.isSelected() ? "1er Piso" : (rbtnPiso2.isSelected() ? "2do Piso" : "No seleccionado");
        String origen = (String) cboOrigen.getSelectedItem();
        String destino = (String) cboDestino.getSelectedItem();
        String servicio = lstServicio.getSelectedValue();

        // Servicios opcionales
        String adicionales = "";
        if (chkAudifonos.isSelected()) adicionales += "Audífonos ";
        if (chkManta.isSelected()) adicionales += "Manta ";
        if (chkRevista.isSelected()) adicionales += "Revista ";
        if (adicionales.isEmpty()) adicionales = "Ninguno";

        JOptionPane.showMessageDialog(this,
                "=== RESUMEN DE COMPRA ===\n" +
                "Nombre: " + nombre + "\n" +
                "DNI: " + dni + "\n" +
                "Fecha de viaje: " + fecha + "\n" +
                "Origen: " + origen + "\n" +
                "Destino: " + destino + "\n" +
                "Tipo de servicio: " + servicio + "\n" +
                "Piso: " + piso + "\n" +
                "Servicios opcionales: " + adicionales,
                "Resumen de Pasaje", JOptionPane.INFORMATION_MESSAGE);
    }
    private void limpiarCampos() {
        txtNombre.setText("");
        txtDni.setText("");
        txtFecha.setText("");
        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevista.setSelected(false);
        grupoPiso.clearSelection();
        cboOrigen.setSelectedIndex(0);
        cboDestino.setSelectedIndex(0);
        lstServicio.clearSelection();
    }

    public static void main(String[] args) {
        new ComprarPasaje();
    }
}
