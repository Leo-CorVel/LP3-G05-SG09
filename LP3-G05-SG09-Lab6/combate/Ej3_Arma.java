package combate;

public class Ej3_Arma extends Ej3_Objeto{
	private int poder;
	public Ej3_Arma(String nombre,int poder) {
		super(nombre);
		this.poder=poder;
	}
	@Override
	public int getPoder() {return poder;}
	@Override
	public void usar(Ej3_Jugador jugador) {
		System.out.println("Has seleccionado el arma: "+getNombre());
	}
}
