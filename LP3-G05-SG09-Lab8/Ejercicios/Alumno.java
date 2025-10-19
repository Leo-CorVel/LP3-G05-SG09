package Ejercicios;
//Ejerccicio 2
public class Alumno {
    private int id;
    private String nombre;
    private int edad;
    private String curso;
    private double promedio;

    public Alumno(int id, String nombre, int edad, String curso, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
        this.promedio = promedio;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCurso() { return curso; }
    public double getPromedio() { return promedio; }

    @Override
    public String toString() {
        return String.format("%d | %s | %d | %s | %.2f", id, nombre, edad, curso, promedio);
    }
}