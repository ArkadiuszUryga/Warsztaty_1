package pl.coderslab.ArkadiuszUryga.Lotto;
import static coderslab.ArkadiuszUryga.nextInt.getInt;

import java.util.Arrays;

import java.util.Random;
import java.util.Scanner;


public class Lotto {

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
		int[] test= {1,2,3,4,9,8};
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
			System.out.println("Tym razem nie wygrałeś niczego. Spróbujesz ponownie?");
			}
			else if	(howMany==3) {
				System.out.println("Trafiłeś trójkę. W rzeczywistości oznacza to wygraną na poziomie ok. 24 zł. Warto?");
			}
			else if	(howMany==4) {
				System.out.println("Trafiłeś czwórkę. W rzeczywistości oznacza to wygraną na poziomie ok. 165 zł. Warto?");
			}
			else if	(howMany==5) {
				System.out.println("Trafiłeś piątkę. W rzeczywistości oznacza to wygraną na poziomie ok. 5 tys. zł. Liczyłeś ile razy musiałeś zagrać, aby zobaczyć ten komunikat?");
			}
			else	{
				System.out.println("Rewelacja. Trafiłeś szóstkę. Wygrałeś w zależności od szczęścia od 1 do 20 mln zł (średnio 1,5 mln zł). Albo masz cholernie dużo szczęścia, albo bardzo dużo czasu na wpisywanie kolejnych liczb!");
				System.out.println("Dobra rada: oszczędź swoje pieniądze i nie licz już na kolejną szóstkę w życiu!");
			}
			
	}
}
