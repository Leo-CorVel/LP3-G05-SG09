package Ejercicios;

import java.io.*;
import java.util.*;

public class Gestor {
    private List<Personaje> personajes;
    private final String archivo = "personajes.txt";

    public Gestor() {
        personajes = new ArrayList<>();
        cargar();
    }

    public void agregar(Personaje p) {
        for (Personaje per : personajes) {
            if (per.getNombre().equalsIgnoreCase(p.getNombre())) {
                System.out.println("El personaje ya existe.");
                return;
            }
        }
        personajes.add(p);
        guardar();
        System.out.println("Personaje agregado.");
    }

    public void mostrar() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        personajes.forEach(System.out::println);
    }

    public void eliminar(String nombre) {
        personajes.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
        guardar();
        System.out.println("Personaje eliminado.");
    }

    public void modificar(String nombre, int vida, int ataque, int defensa, int alcance) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.setVida(vida);
                p.setAtaque(ataque);
                p.setDefensa(defensa);
                p.setAlcance(alcance);
                guardar();
                System.out.println("Personaje modificado.");
                return;
            }
        }
        System.out.println("Personaje no encontrado.");
    }

    private void guardar() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Personaje p : personajes)
                pw.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargar() {
        File f = new File(archivo);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                personajes.add(Personaje.fromString(linea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// 🔹 EJERCICIO 2: FUNCIONALIDADES EXTRA
    public void filtrarPorAtributo(String atributo) {
        personajes.sort((p1, p2) -> {
            return switch (atributo.toLowerCase()) {
                case "vida" -> Integer.compare(p2.getVida(), p1.getVida());
                case "ataque" -> Integer.compare(p2.getAtaque(), p1.getAtaque());
                case "defensa" -> Integer.compare(p2.getDefensa(), p1.getDefensa());
                case "alcance" -> Integer.compare(p2.getAlcance(), p1.getAlcance());
                default -> 0;
            };
        });
        mostrar();
    }
    public void cargarAleatorios() {
        if (!personajes.isEmpty()) return;
        String[] nombres = {"Arthur", "Luna", "Drako", "Milo", "Zara"};
        Random r = new Random();
        for (String n : nombres) {
            personajes.add(new Personaje(
                n,
                50 + r.nextInt(51),
                10 + r.nextInt(11),
                5 + r.nextInt(11),
                3 + r.nextInt(5)
            ));
        }
        guardar();
        System.out.println("Personajes aleatorios cargados.");
    }
    public void actualizarAtributo(String nombre, String atributo, int nuevoValor) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                switch (atributo.toLowerCase()) {
                    case "vida" -> p.setVida(nuevoValor);
                    case "ataque" -> p.setAtaque(nuevoValor);
                    case "defensa" -> p.setDefensa(nuevoValor);
                    case "alcance" -> p.setAlcance(nuevoValor);
                    default -> {
                        System.out.println("Atributo no válido.");
                        return;
                    }
                }
                guardar();
                System.out.println("Atributo actualizado correctamente.");
                return;
            }
        }
        System.out.println("Personaje no encontrado.");
    }
    public void mostrarEstadisticas() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes.");
            return;
        }
        double promVida = personajes.stream().mapToInt(Personaje::getVida).average().orElse(0);
        double promAtaque = personajes.stream().mapToInt(Personaje::getAtaque).average().orElse(0);
        double promDefensa = personajes.stream().mapToInt(Personaje::getDefensa).average().orElse(0);
        double promAlcance = personajes.stream().mapToInt(Personaje::getAlcance).average().orElse(0);

        System.out.println("Estadísticas generales:");
        System.out.println("Total de personajes: " + personajes.size());
        System.out.printf("Promedio Vida: %.2f | Ataque: %.2f | Defensa: %.2f | Alcance: %.2f%n",
                promVida, promAtaque, promDefensa, promAlcance);
    }
    public void importar(String nombreArchivo) {
        File f = new File(nombreArchivo);
        if (!f.exists()) {
            System.out.println("Archivo no encontrado.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null)
                personajes.add(Personaje.fromString(linea));
            guardar();
            System.out.println("Personajes importados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void subirNivel(String nombre) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.subirNivel();
                guardar();
                System.out.println("- " + nombre + " ha subido al nivel " + p.getNivel());
                return;
            }
        }
        System.out.println("Personaje no encontrado.");
    }
}

