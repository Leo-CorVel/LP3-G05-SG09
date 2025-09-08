package Lab3Ej4;

public class ImpresoraMultifuncional implements Imprimible, Escaneable {

    @Override
    public void imprimir(String documento) {
        System.out.println("Impresora multifuncional imprime: " + documento);
    }

    @Override
    public void escanear(String documento) {
        System.out.println("Impresora multifuncional escanea: " + documento);
    } 
}
