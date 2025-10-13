package Ejercicios;

public class Personaje {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;
    private int nivel; //Ejercicio 2

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        if (vida <= 0 || ataque <= 0 || defensa <= 0 || alcance <= 0)
            throw new IllegalArgumentException("Los valores deben ser mayores que cero");

        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
        this.nivel=1; //Ejercicio 2
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getAlcance() { return alcance; }
    public int getNivel() {return nivel;}// Ejercicio 2

    public void setVida(int vida) { this.vida = vida; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public void setDefensa(int defensa) { this.defensa = defensa; }
    public void setAlcance(int alcance) { this.alcance = alcance; }
    //Ejercicio 2
    public void subirNivel() {
    	this.nivel++;
    	this.vida+=10;
    	this.ataque+=5;
    	this.defensa+=5;
    	this.alcance+=1;
    }
    
    @Override
    public String toString() {
        return nombre + "," + vida + "," + ataque + "," + defensa + "," + alcance+" , "+nivel;
    }
// Ejercicio 2
    public static Personaje fromString(String linea) {
        String[] datos = linea.split(",");
        Personaje p = new Personaje(
            datos[0],
            Integer.parseInt(datos[1]),
            Integer.parseInt(datos[2]),
            Integer.parseInt(datos[3]),
            Integer.parseInt(datos[4])
        );
        if (datos.length == 6) {
        	p.nivel = Integer.parseInt(datos[5]);
        }
        return p;
    }
}
