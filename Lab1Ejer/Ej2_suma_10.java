package Lab1Ejer;

import java.util.Scanner;
public class Ej2_suma_10 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[10];
		for (int i=0;i<10;i++) {
			System.out.print("Ingrese un número : ");
			int num = sc.nextInt();
			while(i>0 && num <=arr[i-1]) {
				System.out.print("El numero debe ser mayor que el anterior. Ingrese un número: ");
				num=sc.nextInt();
			}
			arr[i]=num;
		}
		System.out.print("Arreglo: ");
		for(int n:arr) System.out.print(n+" ");
	}
}
