package Lab1Ejer;
import java.util.Scanner;

public class Ej4_menor {
	public static double menor(double a,double b,double c) {
		return Math.min(a, Math.min(b, c));
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Ingrese un numero: " );
		double a=sc.nextDouble();
		System.out.print("Ingrese un numero: " );
		double b=sc.nextDouble();
		System.out.print("Ingrese un numero: " );
		double c=sc.nextDouble();
		System.out.print("El meno numero es: "+ menor(a,b,c));
	}
}
