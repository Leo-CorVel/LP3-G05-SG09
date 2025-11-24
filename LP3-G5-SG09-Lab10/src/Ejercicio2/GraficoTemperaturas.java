package Ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraficoTemperaturas extends JFrame {

    private JTextField[] campos = new JTextField[7];
    private JButton btnMostrar;
    private PanelGrafico panelGrafico;

    private String[] dias = {
            "Lunes", "Martes", "Miércoles", "Jueves",
            "Viernes", "Sábado", "Domingo"
    };

    public GraficoTemperaturas() {
        super("Gráfico de Temperaturas Semanales");

        setLayout(new BorderLayout(10, 10));

        // ------------------- PANEL DE ENTRADA -------------------
        JPanel panelEntrada = new JPanel(new GridLayout(8, 2, 5, 5));

        for (int i = 0; i < 7; i++) {
            panelEntrada.add(new JLabel(dias[i] + ":"));
            campos[i] = new JTextField();
            panelEntrada.add(campos[i]);
        }

        btnMostrar = new JButton("Mostrar Gráfico");
        panelEntrada.add(btnMostrar);

        add(panelEntrada, BorderLayout.WEST);

        // ------------------- PANEL DEL GRÁFICO -------------------
        panelGrafico = new PanelGrafico();
        panelGrafico.setPreferredSize(new Dimension(600, 400));
        add(panelGrafico, BorderLayout.CENTER);

        // -------- EVENTO DEL BOTÓN -----------
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarGrafico();
            }
        });

        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void actualizarGrafico() {
        double[] temps = new double[7];

        try {
            for (int i = 0; i < 7; i++) {
                temps[i] = Double.parseDouble(campos[i].getText());
            }

            panelGrafico.setTemperaturas(temps);
            panelGrafico.repaint();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: Las temperaturas deben ser numéricas.",
                    "Formato inválido",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ---------------- PANEL PERSONALIZADO PARA DIBUJAR ----------------
    class PanelGrafico extends JPanel {

        private double[] temperaturas = new double[7];

        public void setTemperaturas(double[] temperaturas) {
            this.temperaturas = temperaturas;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.BLACK);

            int margen = 40;
            int w = getWidth();
            int h = getHeight();
            int parteAncho = (w - 2 * margen) / 6;
            double min = temperaturas[0];
            double max = temperaturas[0];
            for (double t : temperaturas) {
                if (t < min) min = t;
                if (t > max) max = t;
            }
            if (max == min) max += 1;
            g2.drawLine(margen, h - margen, w - margen, h - margen);
            g2.drawLine(margen, margen, margen, h - margen);      
            int[] x = new int[7];
            int[] y = new int[7];
            for (int i = 0; i < 7; i++) {
                x[i] = margen + i * parteAncho;
                y[i] = (int) (h - margen - (temperaturas[i] - min) / (max - min) * (h - 2 * margen));
                g2.setColor(Color.GREEN);
                g2.fillOval(x[i] - 5, y[i] - 5, 10, 10);
                g2.setColor(Color.BLACK);
                g2.drawString(dias[i], x[i] - 20, h - margen + 20);
            }
            g2.setColor(Color.BLUE);
            for (int i = 0; i < 6; i++) {
                g2.drawLine(x[i], y[i], x[i + 1], y[i + 1]);
            }
        }
    }
    public static void main(String[] args) {
        new GraficoTemperaturas();
    }
}
