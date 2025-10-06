package Actividades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoModelo {
    private List<Pedido> pedidos;
    private List<Pedido> historial; // guarda pedidos eliminados o completados

    public PedidoModelo() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {pedidos.add(pedido);}

    public List<Pedido> getPedidos() {return pedidos;}

    public boolean eliminarPedido(String nombrePlato) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombrePlato)) {
                p.setEstado("Eliminado");
                historial.add(p);
                pedidos.remove(p);
                return true;
            }
        }
        return false;
    }

    public boolean marcarCompleto(String nombrePlato) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombrePlato) && p.getEstado().equals("Pendiente")) {
                p.setEstado("Completo");
                historial.add(p);
                pedidos.remove(p);
                return true;
            }
        }
        return false;
    }

    public List<Pedido> getPedidosPorEstado(String estado) {
        return pedidos.stream()
                .filter(p -> p.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }

    public int contarPendientes() {
        return (int) pedidos.stream()
                .filter(p -> p.getEstado().equals("Pendiente"))
                .count();
    }

    public List<Pedido> getHistorial() {
        return historial;
    }
}

