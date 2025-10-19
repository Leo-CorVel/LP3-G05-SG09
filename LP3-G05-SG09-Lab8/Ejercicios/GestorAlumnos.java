package Ejercicios;
//Ejercicio 2
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GestorAlumnos {
    private List<Alumno> listaAlumnos = new ArrayList<>();

    public static class Alumno {
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
            return id + " | " + nombre + " | " + edad + " | " + curso + " | " + promedio;
        }
    }
// Añadir alumno al arreglo
    public void agregarAlumno(int id, String nombre, int edad, String curso, double promedio) {
        listaAlumnos.add(new Alumno(id, nombre, edad, curso, promedio));
    }
// Obtener todos
    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }
    /**
     * Método para consultar alumnos con parámetros personalizados:
     * A) Campos a mostrar
     * B) Condición (ej: edad>20, curso="Java")
     * C) Orden ascendente/descendente por campo
     * D) Límite de registros
     */
    public void consultar(String campos, String condicion, String ordenCampo, boolean ascendente, int limite) {
        List<Alumno> resultado = new ArrayList<>(listaAlumnos);
// Aplicar filtro (condición)
        resultado = filtrar(resultado, condicion);
// Ordenar
        resultado = ordenar(resultado, ordenCampo, ascendente);
// Limitar
        if (limite > 0 && limite < resultado.size()) {
            resultado = resultado.subList(0, limite);
        }
// Mostrar campos solicitados
        mostrarCampos(resultado, campos);
    }
// Filtro con seguridad (sin errores de null)
    private List<Alumno> filtrar(List<Alumno> lista, String condicion) {
        if (condicion == null || condicion.trim().isEmpty()) {
            return lista;
        }

        condicion = condicion.replaceAll("\\s+", "");
        String finalCondicion = condicion;

        return lista.stream().filter(a -> {
            try {
// edad>20, promedio<15.5, curso="Java"
                if (finalCondicion.contains(">")) {
                    String[] p = finalCondicion.split(">");
                    if (p[0].equalsIgnoreCase("edad"))
                        return a.getEdad() > Integer.parseInt(p[1]);
                    if (p[0].equalsIgnoreCase("promedio"))
                        return a.getPromedio() > Double.parseDouble(p[1]);
                } else if (finalCondicion.contains("<")) {
                    String[] p = finalCondicion.split("<");
                    if (p[0].equalsIgnoreCase("edad"))
                        return a.getEdad() < Integer.parseInt(p[1]);
                    if (p[0].equalsIgnoreCase("promedio"))
                        return a.getPromedio() < Double.parseDouble(p[1]);
                } else if (finalCondicion.contains("=")) {
                    String[] p = finalCondicion.split("=");
                    String valor = p[1].replaceAll("\"", "");
                    if (p[0].equalsIgnoreCase("curso"))
                        return a.getCurso().equalsIgnoreCase(valor);
                    if (p[0].equalsIgnoreCase("nombre"))
                        return a.getNombre().equalsIgnoreCase(valor);
                    if (p[0].equalsIgnoreCase("id"))
                        return a.getId() == Integer.parseInt(valor);
                }
            } catch (Exception e) {
                System.out.println("⚠️ Condición no válida: " + finalCondicion);
            }
            return true;
        }).collect(Collectors.toList());
    }
// Ordenar por campo
    private List<Alumno> ordenar(List<Alumno> lista, String campo, boolean asc) {
        if (campo == null || campo.trim().isEmpty()) return lista;

        Comparator<Alumno> comp = switch (campo.toLowerCase()) {
            case "id" -> Comparator.comparingInt(Alumno::getId);
            case "nombre" -> Comparator.comparing(Alumno::getNombre);
            case "edad" -> Comparator.comparingInt(Alumno::getEdad);
            case "curso" -> Comparator.comparing(Alumno::getCurso);
            case "promedio" -> Comparator.comparingDouble(Alumno::getPromedio);
            default -> null;
        };

        if (comp == null) return lista;
        if (!asc) comp = comp.reversed();

        return lista.stream().sorted(comp).collect(Collectors.toList());
    }
// Mostrar campos elegidos
    private void mostrarCampos(List<Alumno> lista, String campos) {
        if (lista.isEmpty()) {
            System.out.println("⚠️ No hay registros que coincidan con la consulta.");
            return;
        }

        List<String> camposMostrar;
        if (campos == null || campos.trim().isEmpty() || campos.equalsIgnoreCase("todos")) {
            camposMostrar = List.of("id", "nombre", "edad", "curso", "promedio");
        } else {
            camposMostrar = Arrays.asList(campos.split(","));
        }

        System.out.println("\n📋 RESULTADO DE LA CONSULTA:");
        for (Alumno a : lista) {
            for (String c : camposMostrar) {
                c = c.trim().toLowerCase();
                switch (c) {
                    case "id" -> System.out.print(a.getId() + " | ");
                    case "nombre" -> System.out.print(a.getNombre() + " | ");
                    case "edad" -> System.out.print(a.getEdad() + " | ");
                    case "curso" -> System.out.print(a.getCurso() + " | ");
                    case "promedio" -> System.out.print(a.getPromedio() + " | ");
                }
            }
            System.out.println();
        }
    }
}