package Lab3Ej4;

public class Main {
    public static void main(String[] args) {
        Imprimible impresoraBasica = new Impresora();
        impresoraBasica.imprimir("Contrato.pdf");

        System.out.println("-------------------------");

        ImpresoraMultifuncional multifuncional = new ImpresoraMultifuncional();
        multifuncional.imprimir("Factura.docx");
        multifuncional.escanear("Foto.png");
    }
}
