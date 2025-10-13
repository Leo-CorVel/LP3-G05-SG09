package Ejercicios;
//Ejercicio 3
import java.io.*;
import java.util.*;

public class EmpleadoControlador {
    private final String archivo = "empleados.txt";
    private List<Empleado> empleados;

    public EmpleadoControlador() {
        empleados = new ArrayList<>();
        leerEmpleados();
    }
    public void leerEmpleados() {
        empleados.clear();
        File f = new File(archivo);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                empleados.add(Empleado.fromString(linea));
            }
        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo: " + e.getMessage());
        }
    }
    private void guardar() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Empleado e : empleados)
                pw.println(e);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar los datos: " + e.getMessage());
        }
    }
    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("📂 No hay empleados registrados.");
            return;
        }
        System.out.println("\n📋 LISTA DE EMPLEADOS:");
        empleados.forEach(emp -> 
            System.out.printf("N°: %d | Nombre: %s | Sueldo: %.2f%n",
                    emp.getNumero(), emp.getNombre(), emp.getSueldo()));
    }
    public void agregarEmpleado(Empleado nuevo) {
        for (Empleado e : empleados) {
            if (e.getNumero() == nuevo.getNumero()) {
                System.out.println("⚠️ Ya existe un empleado con ese número.");
                return;
            }
        }
        empleados.add(nuevo);
        guardar();
        System.out.println("✅ Empleado agregado correctamente.");
    }
    public Empleado buscarEmpleado(int numero) {
        for (Empleado e : empleados) {
            if (e.getNumero() == numero) {
                return e;
            }
        }
        return null;
    }
    public void eliminarEmpleado(int numero) {
        boolean eliminado = empleados.removeIf(e -> e.getNumero() == numero);
        if (eliminado) {
            guardar();
            System.out.println("🗑️ Empleado eliminado correctamente.");
        } else {
            System.out.println("❌ No se encontró el empleado.");
        }
    }
}
