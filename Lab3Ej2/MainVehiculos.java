package Lab3Ej2;

import java.util.ArrayList;

public class MainVehiculos {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Coche());
        vehiculos.add(new Bicicleta());
        vehiculos.add(new Moto());
        for (Vehiculo v : vehiculos) {
            v.acelerar();
        }
    }
}
