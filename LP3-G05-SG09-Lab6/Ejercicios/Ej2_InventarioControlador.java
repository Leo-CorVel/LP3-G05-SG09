package Ejercicios;
import java.util.List;

public class Ej2_InventarioControlador {
	private Ej2_InventarioModelo modelo;
	private Ej2_InventarioVista vista;
	public Ej2_InventarioControlador(Ej2_InventarioModelo modelo,Ej2_InventarioVista vista) {
		this.modelo=modelo;
		this.vista=vista;
	}
	
	public void agregarItem() {
		String nombre=vista.leerTexto("Nombre: ");
		int cantidad=vista.leerEntero("Cantidad: ");
		String tipo=vista.leerTexto("Tipo(Arma,Poscion,Equipo,etc): ");
		String descripcion=vista.leerTexto("Descripción: ");
		Ej2_Item nuevo= new Ej2_Item(nombre,cantidad,tipo,descripcion);
		modelo.agregarItem(nuevo);
		vista.mostrarMensaje("Item agregado: "+nombre);
	}
	public void eliminarItem() {
		String nombre=vista.leerTexto("Introduce el nombre del item a eliminar: ");
		Ej2_Item item=modelo.buscarItem(nombre);
		if(item != null) {
			modelo.eliminarItem(item);
			vista.mostrarMensaje("Item eliminado: "+nombre);
		}else {
			vista.mostrarMensaje("No se encontro el item");
		}
	}
	public void verInventario() {
		vista.mostrarInventario(modelo.obtenerItems());
	}
	public void mostrarDetalles() {
		String nombre=vista.leerTexto("Introduce el nombre del item a ver detalles: ");
		Ej2_Item item=modelo.buscarItem(nombre);
		vista.mostarDetalleItem(item);		
	}
	public void usarItem() {
		String nombre=vista.leerTexto("Introduce el nombre del item a usar: ");
		Ej2_Item item = modelo.buscarItem(nombre);
		if (item != null) {
			item.usarItem();
		}else {
			vista.mostrarMensaje("Item no encontrado.");
		}
	}
	public void buscarItem() {
		String nombre=vista.leerTexto("Introduce el nombre del item a buscar: ");
		Ej2_Item item=modelo.buscarItem(nombre);
		if(item != null) {
			vista.mostrarMensaje("Item encontrado: "+item);
		}else {
			vista.mostrarMensaje("No se encontro el item: "+nombre);
		}
	}
	
	public void iniciar() {
		String opcion;
		do {
			System.out.println("---Menu---");
			System.out.println("1. Agregar Item");
			System.out.println("2. Ver Inventario");
			System.out.println("3. Eliminar Item");
			System.out.println("4. Mostrar Detalles de Item");
			System.out.println("5. Usar Item");
			System.out.println("6. Buscar Item");
			System.out.println("0. Salir");
			opcion=vista.leerTexto("Opción: ");
			
			switch(opcion) {
			case "1":
				agregarItem();
				break;
			case "2":
				verInventario();
				break;
			case "3":
				eliminarItem();
				break;
			case "4":
				mostrarDetalles();
				break;
			case "5":
				usarItem();
				break;
			case "6":
				buscarItem();
				break;
			case "0":
				vista.mostrarMensaje("Saliendo - Adios");
				break;
			default:
				vista.mostrarMensaje("ERROR - Opcion Invalida");	
			}
		}while(!opcion.equals("0"));
		vista.cerrar();	
	}
}	