package combate;


import java.util.List;
import java.util.Random;

public class Ej3_CombateModelo {
    private Ej3_Jugador jugador;
    private List<Ej3_Enemigo> enemigos;

    public Ej3_CombateModelo(Ej3_Jugador jugador, List<Ej3_Enemigo> enemigos) {
        this.jugador = jugador;
        this.enemigos = enemigos;
    }

    public Ej3_Jugador getJugador() {
        return jugador;
    }

    public List<Ej3_Enemigo> getEnemigos() {
        return enemigos;
    }

    public void turnoJugador(Ej3_Enemigo objetivo) {
        int daño = jugador.atacar();
        objetivo.recibirDaño(daño);
    }

    public void turnoEnemigos() {
        Random rand = new Random();
        for (Ej3_Enemigo e : enemigos) {
            if (e.estaVivo()) {
                if (rand.nextBoolean()) {
                    int daño = e.atacar();
                    jugador.recibirDaño(daño);
                }
            }
        }
    }

    public boolean combateTerminado() {
        if (!jugador.estaVivo()) return true;
        for (Ej3_Enemigo e : enemigos) {
            if (e.estaVivo()) {
                return false;
            }
        }
        return true;
    }
}
