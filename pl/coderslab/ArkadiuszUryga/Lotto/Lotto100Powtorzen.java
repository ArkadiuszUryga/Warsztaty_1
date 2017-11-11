package pl.coderslab.ArkadiuszUryga.Lotto;
import static pl.coderslab.ArkadiuszUryga.nextInt.getInt;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class Lotto100Powtorzen {
	static final int CENA=3;
	static final int TROJKA=24;
	static final int CZWORKA=212;
	static final int PIATKA=5675;
	static final int SZOSTKA=3389141;
	
	public static void main(String[] args) {
		Random rand=new Random();
		
		
		Scanner scan = new Scanner(System.in);
		int[] inserted = new int[6];
		for (int i=0;i<6;i++) {
			inserted[i] =getInt("Podaj liczbę "+(i+1)+" z 6. Zakres 1-49");
			while (inserted[i]<1 || inserted[i]>49)	{
				System.out.println("Podana liczba wykracza poza zadany zakres");
				inserted[i] =getInt("Podaj liczbę "+(i+1)+" z 6. Zakres 1-49");
			}
			for (int j=0; j<i; j++)	{
				if (inserted[i]==inserted[j])	{
					System.out.println("Wprowadziłeś już tą liczbę");
					inserted[i] =getInt("Podaj liczbę "+(i+1)+" z 6. Zakres 1-49");
				}
			}
		}
		Arrays.sort(inserted);
		System.out.print("Wprowadziłeś następujące liczby:");
		System.out.println(Arrays.toString(inserted));

		int wygrana=0;
		for (int powt=0;powt<100;powt++) {
		int[] randNumbers = new int[6];
		for (int i=0;i<6;i++) {
		randNumbers[i]= rand.nextInt(48) + 1;
		for (int j=0; j<i; j++)	{
			while (randNumbers[i]==randNumbers[j])	{
				System.out.println("Wprowadziłeś już tą liczbę");
				randNumbers[i] =rand.nextInt(48) + 1;
			}
		}		
		}

		Arrays.sort(randNumbers);
		System.out.print("A w losowaniu padły takie: ");
		System.out.println(Arrays.toString(randNumbers));
		int howMany=0;
		boolean contains;
			for (int k=0;k<6;k++)	{
				 for(int i : randNumbers){
			            if(i == inserted[k]){
			                howMany++;
			                break;
			            }
			}
		

	}
			
			if (howMany<3) {
				
			}
			else if	(howMany==3) {
				wygrana+=TROJKA;
			}
			else if	(howMany==4) {
					wygrana+=CZWORKA;
			}
			else if	(howMany==5) {
				wygrana+=PIATKA;			}
			else	{
			wygrana+=SZOSTKA;			}
		}
		System.out.println("Z wprowadzonymi liczbami zagrałeś 100 razy. Kupony kosztowały Cię 300 zł");
		System.out.println("Wygrałeś dzięki temu: "+wygrana+" zł");
		System.out.println("Bilans wyniósł "+(wygrana-300));
			
	}
}
