package Ejercicios;
import java.util.List;
import java.util.ArrayList;

public class Ej2_InventarioModelo {
	private List<Ej2_Item> items;
	
	public Ej2_InventarioModelo(){items=new ArrayList<>(); }
	public void agregarItem(Ej2_Item item) {items.add(item);}
	public void eliminarItem(Ej2_Item item) {items.remove(item);}
	
	public List<Ej2_Item> obtenerItems(){return items;}
	
	public Ej2_Item buscarItem(String nombre) {
		for(Ej2_Item item : items) {
			if(item.getNombre().equalsIgnoreCase(nombre)) {
				return item;
			}
		}
		return null;
	}
}
