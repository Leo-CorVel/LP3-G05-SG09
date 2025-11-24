package Ejercicio3;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ReproductorSonidos extends JFrame {

    private JButton btnAplausos, btnCampana, btnExplosion;

    public ReproductorSonidos() {

        super("Reproductor de Efectos de Sonido - Swing");

        setLayout(new GridLayout(3, 1, 10, 10));

        btnAplausos = new JButton("Aplausos");
        btnCampana = new JButton("Campana");
        btnExplosion = new JButton("Explosión");

        add(btnAplausos);
        add(btnCampana);
        add(btnExplosion);

        // EVENTOS
        btnAplausos.addActionListener(e -> reproducirSonido("C:\\Users\\Usuario\\Documents\\UCSM\\2024\\par\\Lp3-L1\\Fase1\\LP3-G5-SG09-Lab10\\src\\Ejercicio3/Aplausos.wav"));
        btnCampana.addActionListener(e -> reproducirSonido("C:\\Users\\Usuario\\Documents\\UCSM\\2024\\par\\Lp3-L1\\Fase1\\LP3-G5-SG09-Lab10\\src\\Ejercicio3/Campana.wav"));
        btnExplosion.addActionListener(e -> reproducirSonido("C:\\Users\\Usuario\\Documents\\UCSM\\2024\\par\\Lp3-L1\\Fase1\\LP3-G5-SG09-Lab10\\src\\Ejercicio3/Bomba.wav"));

        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // MÉTODO GENERAL PARA REPRODUCIR SONIDOS
    private void reproducirSonido(String archivo) {
        try {
            File file = new File(archivo);
            if (!file.exists()) {
                JOptionPane.showMessageDialog(this,
                        "No se encontró el archivo: " + archivo,
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            AudioInputStream audio = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();

            clip.open(audio);
            clip.start();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al reproducir sonido:\n" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        new ReproductorSonidos();
    }
}
