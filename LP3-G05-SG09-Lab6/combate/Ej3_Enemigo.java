package combate;

public class Ej3_Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Ej3_Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public String getTipo() { return tipo; }

    public boolean estaVivo() {
        return salud > 0;
    }

    public void recibirDaño(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
    }

    public int atacar() {
        return nivel * 2;
    }
}
