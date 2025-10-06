package Actividades;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    public String solicitarTipoPlato() {
        System.out.print("Introduce el tipo de plato (Entrada, Principal, Postre, etc.): ");
        return scanner.nextLine();
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (Pedido pedido : pedidos) {
                System.out.println("- " + pedido);
            }
        }
    }

    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar Pedido por Nombre");
        System.out.println("6. Buscar Pedido por Tipo");
        System.out.println("7. Contar Pedidos");
        System.out.println("8. Marcar Pedido como Completo");
        System.out.println("9. Mostrar Pedidos por Estado");
        System.out.println("10. Mostrar Contador de Pendientes");
        System.out.println("11. Mostrar Historial");
        System.out.println("12. Salir");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String solicitarEstado() {
        System.out.print("Introduce el estado (Pendiente o Completo): ");
        return scanner.nextLine();
    }

    public void cerrarScanner() {
        scanner.close();
    }
}


