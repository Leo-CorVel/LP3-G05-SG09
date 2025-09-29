package Ejercicios;

public class Main {
    public static void main(String[] args) {
        Contenedor<String, Integer> contenedor1 = new Contenedor<>();
        contenedor1.agregarPar("Edad", 25);
        contenedor1.agregarPar("Nota", 18);
        contenedor1.agregarPar("Años de Experiencia", 5);

        System.out.println("Contenido del contenedor 1:");
        contenedor1.mostrarPares();

        Contenedor<Persona, Boolean> contenedor2 = new Contenedor<>();
        Persona p1 = new Persona("Carlos", 30);
        Persona p2 = new Persona("María", 25);

        contenedor2.agregarPar(p1, true);
        contenedor2.agregarPar(p2, false);

        System.out.println("\nContenido del contenedor 2:");
        contenedor2.mostrarPares();

        System.out.println("\nPar en índice 1 de contenedor1: " + contenedor1.obtenerPar(1));
    }
}
