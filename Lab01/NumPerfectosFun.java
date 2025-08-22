package Lab01;
import java.util.Scanner;

public class NumPerfectosFun {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Introduce un numero: ");
		int n=scanner.nextInt();
		imprimirNumPerf(n);
	}
	//Verifica si son numeros perfectos
	public static boolean esPerfecto(int num) {
		int sumaDivisores=0;
		for(int i=1;i<=num/2;i++) {
			if(num%i==0) {
				sumaDivisores +=i;
			}
		}
		return sumaDivisores == num;
	}
	//Función para encontrar y mostrar todos los números perfectos menores a un número dado n
	public static void imprimirNumPerf(int n) {
		for (int num=1;num<n;num++) {
			if (esPerfecto(num)) {
				System.out.println(num+" es un numero perfecto");
			}
		}
	}
}
