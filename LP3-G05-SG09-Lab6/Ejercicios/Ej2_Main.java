package Ejercicios;

public class Ej2_Main {
    public static void main(String[] args) {
        Ej2_InventarioModelo modelo = new Ej2_InventarioModelo();
        Ej2_InventarioVista vista = new Ej2_InventarioVista();
        Ej2_InventarioControlador controlador = new Ej2_InventarioControlador(modelo, vista);

        controlador.iniciar();
    }
}
