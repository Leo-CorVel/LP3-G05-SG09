package combate;
import java.util.List;
import java.util.ArrayList;

public class Ej3_CombateMain {
    public static void main(String[] args) {
        List<Ej3_Objeto> inventario = new ArrayList<>();
        Ej3_Arma espada = new Ej3_Arma("Espada", 10);
        Ej3_Pocion pocion = new Ej3_Pocion("Poción de Vida", 20);
        inventario.add(espada);
        inventario.add(pocion);

        Ej3_Jugador jugador = new Ej3_Jugador("Héroe", 100, 1, inventario);
        jugador.equiparObjeto(espada);

        List<Ej3_Enemigo> enemigos = new ArrayList<>();
        enemigos.add(new Ej3_Enemigo("Goblin", 30, 1, "Bestia"));
        enemigos.add(new Ej3_Enemigo("Orco", 50, 2, "Guerrero"));

        Ej3_CombateModelo modelo = new Ej3_CombateModelo(jugador, enemigos);
        Ej3_CombateVista vista = new Ej3_CombateVista();
        Ej3_CombateControlador controlador = new Ej3_CombateControlador(modelo, vista);

        controlador.iniciarCombate();
    }
}
