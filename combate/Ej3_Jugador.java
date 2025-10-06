package combate;
import java.util.List;

public class Ej3_Jugador {
	private String nombre;
	private int salud;
	private int nivel;
	private List<Ej3_Objeto> inventario;
	private Ej3_Objeto objetoEquipado;
	
	public Ej3_Jugador(String nombre,int salud,int nivel,List<Ej3_Objeto>inventario) {
		this.nombre=nombre;
		this.salud=salud;
		this.nivel=nivel;
		this.inventario=inventario;
		this.objetoEquipado=null;
	}
	public String getNombre() {return nombre;}
	public int getSalud() {return salud;}
	public int getNivel() {return nivel;}
	
	public void equiparObjeto(Ej3_Objeto obj) {
		if (inventario.contains(obj)) {
			objetoEquipado=obj;
			System.out.println("Objeto equipado: "+obj.getNombre());
		}
	}
	public Ej3_Objeto getObjetoEquipo() {return objetoEquipado;}
	public boolean estaVivo() {return salud>0;}
	public void recibirDaño(int daño) {
		salud-=daño;
		if(salud<0) {salud=0;}
	}
	public int atacar() {
		if (objetoEquipado != null) {
			return objetoEquipado.getPoder();
		}else {
			return nivel*1;
		}
	}
	public void usarObjeto(String nombreObjeto) {
		for (Ej3_Objeto obj:inventario) {
			if(obj.getNombre().equals(nombreObjeto)) {
				obj.usar(this);
				return;
			}
		}
		System.out.println("No tienes ese objeto en tu inventario.");
	}
}