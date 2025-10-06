package combate;

public class Ej3_Pocion extends Ej3_Objeto{
	private int curacion;
	public Ej3_Pocion(String nombre, int curacion) {
		super(nombre);
		this.curacion=curacion;
	}
	@Override
	public void usar(Ej3_Jugador jugador) {
		int saludAntes = jugador.getSalud();
		jugador.recibirDaño(-curacion);
		System.out.println(jugador.getNombre()+" usa "+getNombre()+" y recupera "+curacion+" de salud.("+saludAntes+" -> "+jugador.getSalud()+")");	
	}
}
