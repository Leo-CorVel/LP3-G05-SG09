package Lab3Ej3;

public class Coche implements VehiculoMotorizado {
    @Override
    public void acelerar() {
        System.out.println("El coche acelera usando el motor");
    }

    @Override
    public void encenderMotor() {
        System.out.println("El coche enciende su motor");
    }
}
