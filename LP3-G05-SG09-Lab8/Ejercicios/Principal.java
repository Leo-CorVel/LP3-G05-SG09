package Ejercicios;
//Ejercicio 1
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {
    static final String DB_URL = "jdbc:sqlite:ejercicio1.db";
//Clave: 1234
    static final String CLAVE_ADMIN = "1234"; 
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            Class.forName("org.sqlite.JDBC");

            Connection con = DriverManager.getConnection(DB_URL);
            System.out.println("La Base de datos abierta correctamente.");

            Statement stmt = con.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS alumnos (" +"id INTEGER PRIMARY KEY AUTOINCREMENT, " +"nombre TEXT NOT NULL, " +
                         "edad INTEGER, " +"curso TEXT, " +"promedio REAL);");
            System.out.println("Tabla 'alumnos' verificada o creada.\n");

            int opcion;
            do {
                System.out.println("- - -MENÚ- - -");
                System.out.println("1. Ingresar alumno");
                System.out.println("2. Mostrar alumnos");
                System.out.println("3. Actualizar alumno");
                System.out.println("4. Borrar alumno");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        ingresarAlumno(con, sc);
                        break;
                    case 2:
                        mostrarAlumnos(con);
                        break;
                    case 3:
                        actualizarAlumno(con, sc);
                        break;
                    case 4:
                        borrarAlumno(con, sc);
                        break;
                    case 0:
                        System.out.println("Saliendo del programa");
                        break;
                    default:
                        System.out.println("ERROR -  Opción no válida.");
                }
                System.out.println();
            } while (opcion != 0);

            con.close();
            System.out.println("Conexión cerrada correctamente.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
//Ingresar alumno
    static void ingresarAlumno(Connection con, Scanner sc) throws SQLException {
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese curso: ");
        String curso = sc.nextLine();
        System.out.print("Ingrese promedio: ");
        double promedio = sc.nextDouble();
        sc.nextLine();

        if (verificarClave(sc)) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO alumnos (nombre, edad, curso, promedio) VALUES (?, ?, ?, ?)");
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setString(3, curso);
            ps.setDouble(4, promedio);
            ps.executeUpdate();
            System.out.println("Alumno insertado correctamente.");
        } else {
            System.out.println("ERROR - Clave incorrecta. Operación cancelada.");
        }
    }
//Mostrar alumnos
    static void mostrarAlumnos(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM alumnos");

        System.out.println("\n LISTA DE ALUMNOS:");
        System.out.println("ID | NOMBRE | EDAD | CURSO | PROMEDIO");
        System.out.println("--------------------------------------");
        while (rs.next()) {
            System.out.printf("%d | %s | %d | %s | %.2f%n",
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("curso"),
                    rs.getDouble("promedio"));
        }
    }
//Actualizar alumno
    static void actualizarAlumno(Connection con, Scanner sc) throws SQLException {
        System.out.print("Ingrese el ID del alumno a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nueva edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo curso: ");
        String curso = sc.nextLine();
        System.out.print("Nuevo promedio: ");
        double promedio = sc.nextDouble();
        sc.nextLine();

        if (verificarClave(sc)) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE alumnos SET nombre=?, edad=?, curso=?, promedio=? WHERE id=?");
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setString(3, curso);
            ps.setDouble(4, promedio);
            ps.setInt(5, id);

            int filas = ps.executeUpdate();
            if (filas > 0) System.out.println("Alumno actualizado correctamente.");
            else System.out.println("No se encontró un alumno con ese ID.");
        } else {
            System.out.println("Clave incorrecta. Operación revertida.");
        }
    }

//Borrar alumno
    static void borrarAlumno(Connection con, Scanner sc) throws SQLException {
        System.out.print("Ingrese el ID del alumno a borrar: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (verificarClave(sc)) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM alumnos WHERE id=?");
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) System.out.println("Alumno eliminado correctamente.");
            else System.out.println("No se encontró un alumno con ese ID.");
        } else {
            System.out.println("Clave incorrecta. Operación cancelada.");
        }
    }
//Verificación de clave de seguridad
    static boolean verificarClave(Scanner sc) {
        System.out.print("Ingrese clave de confirmación: ");
        String clave = sc.nextLine();
        return clave.equals(CLAVE_ADMIN);
    }
}