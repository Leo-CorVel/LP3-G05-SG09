package Lab3Ej3;

public class MainVehiculo{
    public static void main(String[] args) {
        Vehiculo coche = new Coche();
        Vehiculo bici = new Bicicleta();

        coche.acelerar();
        bici.acelerar();

        VehiculoMotorizado coche2 = new Coche();
        coche2.encenderMotor();
        coche2.acelerar();
    }
}
