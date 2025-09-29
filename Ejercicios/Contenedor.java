package Ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Contenedor<F, S> {
    private List<Par<F, S>> listaPares;
    
    public Contenedor() {
        listaPares = new ArrayList<>();
    }
    public void agregarPar(F primero, S segundo) {
        Par<F, S> nuevoPar = new Par<>(primero, segundo);
        listaPares.add(nuevoPar);
    }
    public Par<F, S> obtenerPar(int indice) {
        if (indice >= 0 && indice < listaPares.size()) {
            return listaPares.get(indice);
        }
        return null;
    }
    public List<Par<F, S>> obtenerTodosLosPares() {
        return listaPares;
    }
    public void mostrarPares() {
        if (listaPares.isEmpty()) {
            System.out.println("El contenedor está vacío.");
        } else {
            for (Par<F, S> par : listaPares) {
                System.out.println(par);
            }
        }
    }
}
