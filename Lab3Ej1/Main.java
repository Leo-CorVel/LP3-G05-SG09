package Lab3Ej1;

public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Leonardo Cornejo", 48000, "TI");
        CalcularPago calculadora = new CalcularPago();

        double pagoMensual = calculadora.calcularPagoMensual(empleado);

        System.out.println("Empleado: " + empleado.getNombre());
        System.out.println("Departamento: " + empleado.getDepartamento());
        System.out.println("Salario anual: $" + empleado.getSalario());
        System.out.println("Pago mensual: $" + pagoMensual);
    }
}
