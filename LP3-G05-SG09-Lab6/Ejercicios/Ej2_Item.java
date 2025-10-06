package Ejercicios;

public class Ej2_Item {
	private String nombre;
	private int cantidad;
	private String tipo;
	private String descripcion;
	
	public Ej2_Item(String nombre,int cantidad,String tipo,String descpicon) {
		this.nombre=nombre;
		this.cantidad=cantidad;
		this.tipo=tipo;
		this.descripcion=descripcion;
	}
	public String getNombre() {return nombre;}
	public int getCantidad() {return cantidad;}
	public String getTipo() {return tipo;}
	public String getDescripcion() {return descripcion;}
	
	public void setCantida(int cantidad) {this.cantidad=cantidad;}
	
	public void usarItem() {
		if (cantidad>0) {
			cantidad--;
			System.out.println("Usaste: "+nombre+". Quedan "+cantidad);
		}else {
			System.out.println("No quedan unidades de "+nombre);
		}
	}
	
	@Override
	public String toString() {
		return nombre+" ("+tipo+") - Cantidad: "+cantidad+" - "+descripcion;
	}
}
