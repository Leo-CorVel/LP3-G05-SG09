package Lab3Ej4;

public class Impresora implements Imprimible {

    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimiendo documento: " + documento);
    }
}
