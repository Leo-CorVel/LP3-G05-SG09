package Ejercicios;
//Ejercicio 4
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class ContadorPalabra {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        File archivo = null;
        
        while (archivo == null) {
            System.out.println("Seleccione el archivo de texto para analizar...");
            int seleccion = fileChooser.showOpenDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                archivo = fileChooser.getSelectedFile();
                if (!archivo.exists() || !archivo.isFile()) {
                    System.out.println("El archivo seleccionado no es válido. Intente nuevamente.");
                    archivo = null;
                }
            } else {
                System.out.println("🚫 No se seleccionó ningún archivo. Saliendo del programa.");
                return;
            }
        }
        int totalLineas = 0;
        int totalPalabras = 0;
        int totalCaracteres = 0;
        Map<String, Integer> frecuencia = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                totalLineas++;
                totalCaracteres += linea.length();
                StringBuilder palabraActual = new StringBuilder();

                for (char c : linea.toCharArray()) {
                    if (Character.isLetterOrDigit(c)) {
                        palabraActual.append(c);
                    } else if (palabraActual.length() > 0) {
                        String palabra = palabraActual.toString().toLowerCase();
                        totalPalabras++;
                        frecuencia.put(palabra, frecuencia.getOrDefault(palabra, 0) + 1);
                        palabraActual.setLength(0);
                    }
                }
                if (palabraActual.length() > 0) {
                    String palabra = palabraActual.toString().toLowerCase();
                    totalPalabras++;
                    frecuencia.put(palabra, frecuencia.getOrDefault(palabra, 0) + 1);
                }
            }

            System.out.println("RESULTADOS DEL ANÁLISIS");
            System.out.println("Archivo: " + archivo.getName());
            System.out.println("----------------------------");
            System.out.println("Total de líneas: " + totalLineas);
            System.out.println("Total de palabras: " + totalPalabras);
            System.out.println("Total de caracteres: " + totalCaracteres);

            double promedio = (totalLineas > 0) ? (double) totalPalabras / totalLineas : 0;
            System.out.printf("Promedio de palabras por línea: %.2f%n", promedio);

            if (!frecuencia.isEmpty()) {
                int maxFrecuencia = Collections.max(frecuencia.values());

                List<String> masFrecuentes = new ArrayList<>();
                for (Entry<String, Integer> e : frecuencia.entrySet()) {
                    if (e.getValue() == maxFrecuencia) {
                        masFrecuentes.add(e.getKey());
                    }
                }

                System.out.println("\n🔠 Palabras más frecuentes (" + maxFrecuencia + " apariciones):");
                masFrecuentes.forEach(p -> System.out.println("- " + p));
            }

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
