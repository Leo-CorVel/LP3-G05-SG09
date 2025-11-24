package Ejercicio4;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ReproductorMusica extends JFrame {

    private JButton btnPlay, btnPause, btnResume;
    private Clip clip;
    private Long posicionPausa = 0L;

    public ReproductorMusica() {
        super("Reproductor de Música - LP3");

        setLayout(new GridLayout(3, 1, 10, 10));

        btnPlay = new JButton("Reproducir");
        btnPause = new JButton("Pausar");
        btnResume = new JButton("Reanudar");

        add(btnPlay);
        add(btnPause);
        add(btnResume);

        // EVENTOS
        btnPlay.addActionListener(e -> reproducir());
        btnPause.addActionListener(e -> pausar());
        btnResume.addActionListener(e -> reanudar());

        setSize(400, 220);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void reproducir() {
        try {
            File archivo = new File("C:\\Users\\Usuario\\Documents\\UCSM\\2024\\par\\Lp3-L1\\Fase1\\LP3-G5-SG09-Lab10\\src\\Ejercicio4/Through-The-Fire-And-Flames.wav");

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            posicionPausa = 0L;
            clip.setMicrosecondPosition(0);
            clip.start();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al reproducir audio:\n" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void pausar() {
        if (clip != null && clip.isRunning()) {
            posicionPausa = clip.getMicrosecondPosition();
            clip.stop();
        }
    }

    private void reanudar() {
        if (clip != null) {
            clip.setMicrosecondPosition(posicionPausa);
            clip.start();
        }
    }

    public static void main(String[] args) {
        new ReproductorMusica();
    }
}
