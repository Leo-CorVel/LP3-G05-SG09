package combate;
import java.util.Scanner;

public class Ej3_CombateControlador {
    private Ej3_CombateModelo modelo;
    private Ej3_CombateVista vista;
    private Scanner scanner = new Scanner(System.in);

    public Ej3_CombateControlador(Ej3_CombateModelo modelo, Ej3_CombateVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarCombate() {
        while (!modelo.combateTerminado()) {
            vista.mostrarEstado(modelo.getJugador(), modelo.getEnemigos());

            vista.mostrarMensaje("\nTu turno: 1) Atacar   2) Usar objeto");
            String opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                vista.mostrarMensaje("¿A qué enemigo atacarás? Escribe su nombre:");
                String nombre = scanner.nextLine();
                Ej3_Enemigo objetivo = null;
                for (Ej3_Enemigo e : modelo.getEnemigos()) {
                    if (e.getNombre().equalsIgnoreCase(nombre) && e.estaVivo()) {
                        objetivo = e;
                        break;
                    }
                }
                if (objetivo != null) {
                    modelo.turnoJugador(objetivo);
                    vista.mostrarMensaje("Atacaste a " + objetivo.getNombre());
                } else {
                    vista.mostrarMensaje("Enemigo inválido o ya muerto.");
                }
            } else if (opcion.equals("2")) {
                vista.mostrarMensaje("¿Qué objeto usarás? Escribe nombre:");
                String nombreObj = scanner.nextLine();
                modelo.getJugador().usarObjeto(nombreObj);
            }
            modelo.turnoEnemigos();
            vista.mostrarMensaje("Los enemigos atacan...");

        }
        vista.mostrarEstado(modelo.getJugador(), modelo.getEnemigos());
        if (modelo.getJugador().estaVivo()) {
            vista.mostrarMensaje("¡Ganaste el combate!");
        } else {
            vista.mostrarMensaje("Has sido derrotado...");
        }
    }
}
