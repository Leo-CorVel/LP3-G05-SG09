package Ejercicios;
//Ejercicio 3
public class Empleado {
    private int numero;
    private String nombre;
    private double sueldo;

    public Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    @Override
    public String toString() {
        return numero + "," + nombre + "," + sueldo;
    }
    public static Empleado fromString(String linea) {
        String[] datos = linea.split(",");
        return new Empleado(
            Integer.parseInt(datos[0]),
            datos[1],
            Double.parseDouble(datos[2])
        );
    }
}
