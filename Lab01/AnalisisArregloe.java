package Lab01;
import java.util.Scanner;

public class AnalisisArregloe {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Introduce el tamaño del arreglo: ");
		int n=scanner.nextInt();
		
		int[] arreglo=new int[n];
		System.out.print("Introduce los elementos del arreglo: ");
		leerArreglo(scanner, arreglo);
		
		double promedio=calcularPromedio(arreglo);
		System.out.println("El promedio de los elementos es: " promedio);
	}
	public static void leerArreglo(Scanner scanner, int[] arreglo) {
		for (int i=0;i<arreglo.length;i++) {
			arreglo[i]=scanner.nextInt();
		}
	}
	public static double calcularPromedio(int[] arreglo) {
		int suma=0;
		for (int num : arreglo) {
			suma += num;
		}
		return (double) suma/arreglo.length;
	}
}
