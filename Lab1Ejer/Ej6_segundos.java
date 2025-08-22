package Lab1Ejer;
import java.util.Scanner;

public class Ej6_segundos {
	public static int Total(int horas, int minutos, int segundos) {
		return horas*3600 + minutos*60 + segundos;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Ingrese las horas: " );
		int horas=sc.nextInt();
		System.out.print("Ingrese los minutos: " );
		int minutos=sc.nextInt();
		System.out.print("Ingrese los segundos: " );
		int segundos=sc.nextInt();
		
		int total=Total(horas,minutos,segundos);
		System.out.print("El total en segundos es: "+total);
	}	
}
