package pl.coderslab.ArkadiuszUryga;
import static pl.coderslab.ArkadiuszUryga.nextInt.getInt;
import static pl.coderslab.ArkadiuszUryga.Randz.rand;
import java.util.Scanner;



public class Game1 {

	public static void main(String[] args) {
		int rnd = rand();
		System.out.println("Wylosowano liczbę z zakresu 1-100. Spróbuj ją zgadnąć. Wprowadź w konsoli swój typ");
		Scanner scan = new Scanner(System.in);
		
		int check=0;
		while	(check!=1)	{
			int a =getInt("Podaj liczbę");
			if (a<1 || a>100)	{
				System.out.println("Przeczytaj jeszcze raz. Liczba z zakresu 1-100!!!!!!");
			}
			if	(a>rnd && (a>0 || a<100)) {
				System.out.println("Podana liczba jest za duża. Spróbuj ponownie");
			}
			else if	(a<rnd && (a>0 || a<100)) {
				System.out.println("Podana liczba jest za mała. Spróbuj ponownie");
			}
			else	{
				System.out.println("Udało Ci się zgadnąć. Bravo!");
				check=1;
			}
		}
		
		

	}

}
