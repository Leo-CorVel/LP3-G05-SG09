package Ejercicios;
//Ejercicio 2
public class PruebaPar {
    public static void main(String[] args) {
        Par<Integer, String> par1 = new Par<>(1, "Hola");
        Par<Integer, String> par2 = new Par<>(1, "Hola");
        Par<Integer, String> par3 = new Par<>(2, "Mundo");

        System.out.println("Par1: " + par1);
        System.out.println("Par2: " + par2);
        System.out.println("Par3: " + par3);

        // Pruebas de esIgual
        System.out.println("¿Par1 es igual a Par2? " + par1.esIgual(par2)); // true
        System.out.println("¿Par1 es igual a Par3? " + par1.esIgual(par3)); // false
    }
}
