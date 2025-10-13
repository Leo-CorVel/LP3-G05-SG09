package Ejercicios;
import java.util.Scanner;

public class MainGestor {
    public static void main(String[] args) {
        Gestor g = new Gestor();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE PERSONAJES ---");
            System.out.println("1. Agregar personaje");
            System.out.println("2. Mostrar personajes");
            System.out.println("3. Modificar personaje");
            System.out.println("4. Eliminar personaje");
            // Ejercicio 2
            System.out.println("5. Filtrar por atributo");
            System.out.println("6. Actualizar un solo atributo");
            System.out.println("7. Mostrar estadísticas");
            System.out.println("8. Importar desde archivo externo");
            System.out.println("9. Subir de nivel");
            System.out.println("10. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: "); String n = sc.nextLine();
                    System.out.print("Vida: "); int v = sc.nextInt();
                    System.out.print("Ataque: "); int a = sc.nextInt();
                    System.out.print("Defensa: "); int d = sc.nextInt();
                    System.out.print("Alcance: "); int al = sc.nextInt();
                    g.agregar(new Personaje(n, v, a, d, al));
                }
                case 2 -> g.mostrar();
                case 3 -> {
                    System.out.print("Nombre del personaje a modificar: ");
                    String n = sc.nextLine();
                    System.out.print("Nueva vida: "); int v = sc.nextInt();
                    System.out.print("Nuevo ataque: "); int a = sc.nextInt();
                    System.out.print("Nueva defensa: "); int d = sc.nextInt();
                    System.out.print("Nuevo alcance: "); int al = sc.nextInt();
                    g.modificar(n, v, a, d, al);
                }
                case 4 -> {
                    System.out.print("Nombre del personaje a eliminar: ");
                    String n = sc.nextLine();
                    g.eliminar(n);
                }
                // Ejercicio 2
                case 5 -> {
                    System.out.print("Atributo (vida/ataque/defensa/alcance): ");
                    String atr = sc.nextLine();
                    g.filtrarPorAtributo(atr);
                }
                case 6 -> {
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("Atributo a modificar: ");
                    String atr = sc.nextLine();
                    System.out.print("Nuevo valor: ");
                    int val = sc.nextInt(); sc.nextLine();
                    g.actualizarAtributo(n, atr, val);
                }
                case 7 -> g.mostrarEstadisticas();
                case 8 -> {
                    System.out.print("Nombre del archivo externo (ej: nuevos.txt): ");
                    String file = sc.nextLine();
                    g.importar(file);
                }
                case 9 -> {
                    System.out.print("Nombre del personaje: ");
                    String n = sc.nextLine();
                    g.subirNivel(n);
                }
            }
        } while (opcion != 10);
        sc.close();
    }
}
