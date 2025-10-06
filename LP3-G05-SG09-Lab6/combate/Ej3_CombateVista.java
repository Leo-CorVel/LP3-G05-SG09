package combate;
import java.util.List;

public class Ej3_CombateVista {
    public void mostrarEstado(Ej3_Jugador jugador, List<Ej3_Enemigo> enemigos) {
        System.out.println("\n=== Estado del combate ===");
        System.out.println("Jugador: " + jugador.getNombre()
                + " | Salud: " + jugador.getSalud()
                + " | Nivel: " + jugador.getNivel());
        System.out.println("Enemigos:");
        for (Ej3_Enemigo e : enemigos) {
            String estado = e.estaVivo() ? "Vivo" : "Muerto";
            System.out.println("- " + e.getNombre() + " (" + e.getTipo() + ") | Salud: " + e.getSalud()
                    + " | Estado: " + estado);
        }
    }
    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}
