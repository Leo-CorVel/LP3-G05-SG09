package Lab1Ejer;

import java.util.Random;
public class Ej3_dado {
	public static void main(String[] args) {
		int[] freq=new int[6];
		Random rand=new Random();
		for(int i=0;i<20000;i++) {
			int cara=rand.nextInt(6);
			freq[cara]++;
		}
		for (int i=0; i<6 ;i++) {
			System.out.println("Cara "+(i+1)+": "+freq[i]);
		}
	}
}