package Actividades;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarPedido() {
        String nombrePlato = vista.solicitarNombrePlato();
        String tipo = vista.solicitarTipoPlato();
        if (!nombrePlato.isEmpty() && !tipo.isEmpty()) {
            modelo.agregarPedido(new Pedido(nombrePlato, tipo));
            vista.mostrarMensaje("Pedido agregado: " + nombrePlato + " (" + tipo + ")");
        } else {
            vista.mostrarMensaje("El nombre y tipo no pueden estar vacíos.");
        }
    }

    public void mostrarPedidos() {
        vista.mostrarPedidos(modelo.getPedidos());
    }

    public void eliminarPedido() {
        String nombre = vista.solicitarNombrePlato();
        if (modelo.eliminarPedido(nombre)) {
            vista.mostrarMensaje("Pedido eliminado: " + nombre);
        } else {
            vista.mostrarMensaje("No se encontró el pedido.");
        }
    }

    public void actualizarPedido() {
        vista.mostrarMensaje("Introduce el nombre del pedido a actualizar:");
        String nombreViejo = vista.solicitarNombrePlato();

        List<Pedido> pedidos = modelo.getPedidos();
        Pedido encontrado = null;
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombreViejo)) {
                encontrado = p;
                break;
            }
        }

        if (encontrado == null) {
            vista.mostrarMensaje("No se encontró el pedido a actualizar.");
            return;
        }

        vista.mostrarMensaje("Introduce el nuevo nombre (dejar vacío para no cambiar):");
        String nuevoNombre = vista.solicitarNombrePlato();
        vista.mostrarMensaje("Introduce el nuevo tipo (dejar vacío para no cambiar):");
        String nuevoTipo = vista.solicitarTipoPlato();

        if (!nuevoNombre.trim().isEmpty()) {
            encontrado.setNombrePlato(nuevoNombre.trim());
        }
        if (!nuevoTipo.trim().isEmpty()) {
            encontrado.setTipo(nuevoTipo.trim());
        }

        vista.mostrarMensaje("Pedido actualizado correctamente.");
    }

    public void buscarPorNombre() {
        vista.mostrarMensaje("Introduce el nombre a buscar:");
        String nombre = vista.solicitarNombrePlato();
        List<Pedido> resultados = modelo.getPedidos().stream()
                .filter(p -> p.getNombrePlato().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
        vista.mostrarPedidos(resultados);
    }

    public void buscarPorTipo() {
        vista.mostrarMensaje("Introduce el tipo a buscar:");
        String tipo = vista.solicitarTipoPlato();
        List<Pedido> resultados = modelo.getPedidos().stream()
                .filter(p -> p.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
        vista.mostrarPedidos(resultados);
    }

    public void contarPedidos() {
        int total = modelo.getPedidos().size();
        vista.mostrarMensaje("Total de pedidos (activos): " + total);

        vista.mostrarMensaje("Introduce el tipo para contar (o deja vacío para omitir):");
        String tipo = vista.solicitarTipoPlato();
        if (tipo != null && !tipo.trim().isEmpty()) {
            long countByType = modelo.getPedidos().stream()
                    .filter(p -> p.getTipo().equalsIgnoreCase(tipo.trim()))
                    .count();
            vista.mostrarMensaje("Pedidos del tipo '" + tipo + "': " + countByType);
        }
    }

    public void marcarCompleto() {
        vista.mostrarMensaje("Introduce el nombre del pedido a marcar como completo:");
        String nombre = vista.solicitarNombrePlato();
        if (modelo.marcarCompleto(nombre)) {
            vista.mostrarMensaje("Pedido marcado como COMPLETO: " + nombre);
        } else {
            vista.mostrarMensaje("No se encontró el pedido o ya estaba completado/eliminado.");
        }
    }

    public void mostrarPorEstado() {
        vista.mostrarMensaje("Introduce el estado a mostrar (Pendiente, Completo, Eliminado):");
        String estado = vista.solicitarEstado();

        if (estado.equalsIgnoreCase("Pendiente")) {
            vista.mostrarPedidos(modelo.getPedidosPorEstado("Pendiente"));
        } else {
            List<Pedido> historialFiltrado = modelo.getHistorial().stream()
                    .filter(p -> p.getEstado().equalsIgnoreCase(estado))
                    .collect(Collectors.toList());
            vista.mostrarPedidos(historialFiltrado);
        }
    }

    public void mostrarPendientes() {
        vista.mostrarMensaje("Pedidos pendientes: " + modelo.contarPendientes());
    }

    public void mostrarHistorial() {
        vista.mostrarPedidos(modelo.getHistorial());
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1": agregarPedido(); break;
                case "2": mostrarPedidos(); break;
                case "3": eliminarPedido(); break;
                case "4": actualizarPedido(); break;
                case "5": buscarPorNombre(); break;
                case "6": buscarPorTipo(); break;
                case "7": contarPedidos(); break;
                case "8": marcarCompleto(); break;
                case "9": mostrarPorEstado(); break;
                case "10": mostrarPendientes(); break;
                case "11": mostrarHistorial(); break;
                case "12": vista.mostrarMensaje("Saliendo..."); break;
                default: vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("12"));
        vista.cerrarScanner();
    }
}


