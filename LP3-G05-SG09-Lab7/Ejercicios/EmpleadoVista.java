package Ejercicios;
import java.util.Scanner;
//Ejercicio 3
public class EmpleadoVista {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpleadoControlador controlador = new EmpleadoControlador();
        int opcion;

        System.out.println("SISTEMA DE GESTIÓN DE EMPLEADOS");

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Listar empleados");
            System.out.println("2. Agregar empleado");
            System.out.println("3. Buscar empleado por número");
            System.out.println("4. Eliminar empleado por número");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            while (!sc.hasNextInt()) {
                System.out.println("⚠️ Ingrese un número válido.");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> controlador.listarEmpleados();
                case 2 -> {
                    try {
                        System.out.print("Número: ");
                        int numero = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Sueldo: ");
                        double sueldo = sc.nextDouble();
                        controlador.agregarEmpleado(new Empleado(numero, nombre, sueldo));
                    } catch (Exception e) {
                        System.out.println("❌ Error al ingresar los datos.");
                        sc.nextLine();
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el número del empleado: ");
                    int num = sc.nextInt();
                    Empleado e = controlador.buscarEmpleado(num);
                    if (e != null)
                        System.out.println("✅ Empleado encontrado: " + e);
                    else
                        System.out.println("❌ No se encontró el empleado.");
                }
                case 4 -> {
                    System.out.print("Ingrese el número del empleado a eliminar: ");
                    int num = sc.nextInt();
                    controlador.eliminarEmpleado(num);
                }
                case 5 -> System.out.println("👋 Saliendo del programa...");

                default -> System.out.println("⚠️ Opción no válida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
