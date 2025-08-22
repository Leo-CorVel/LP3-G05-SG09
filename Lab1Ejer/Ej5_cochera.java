package Lab1Ejer;
import java.util.Scanner;

public class Ej5_cochera {
	public static double tarifa(double horas) {
		if (horas<=1)return 3.0;
		double total=3.0+(horas-1)*0.5;
		return Math.min(total, 12.0);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Ingrese las horas: " );
		double horas=sc.nextDouble();
		double monto=tarifa(horas);
		System.out.print("El monto total es: S/."+monto);
	}	
}
