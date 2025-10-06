package Ejercicios;

import java.util.List;
import java.util.Scanner;

public class Ej2_InventarioVista {
	private Scanner scanner=new Scanner(System.in);
	
	public void mostrarInventario(List<Ej2_Item> items) {
		if (items.isEmpty()) {
			System.out.println("El inventario esta Vacio");
		}else {
			System.out.println("Inventario: ");
			for (Ej2_Item item : items) {
				System.out.println("- "+item);
			}
		}
		
	}
	public void mostrarMensaje(String mensaje) {System.out.println(mensaje);}
	
	public void mostarDetalleItem(Ej2_Item item) {
		if (item !=null) {
			System.out.println("Detalles del Item:");
			System.out.println("Nombre: "+item.getNombre());
			System.out.println("Tipo: "+item.getTipo());
			System.out.println("Cantidad: "+item.getCantidad());
			System.out.println("Descripción: "+item.getDescripcion());
		}else {
			System.out.println("Item no encontrado. :(");
		}
	}
	public String leerTexto(String prompt) {
		System.out.println(prompt);
		return scanner.nextLine();
	}
	public int leerEntero(String prompt) {
		System.out.println(prompt);
		int valor=scanner.nextInt();
		scanner.nextLine();
		return valor;
	}
	public void cerrar() {scanner.close();}
	
	
}
