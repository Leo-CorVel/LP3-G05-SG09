package combate;

public abstract class Ej3_Objeto {
    private String nombre;

    public Ej3_Objeto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    public int getPoder() {
        return 0;
    }
    public abstract void usar(Ej3_Jugador jugador);
}
