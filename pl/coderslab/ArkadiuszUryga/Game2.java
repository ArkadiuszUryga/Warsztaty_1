package coderslab.ArkadiuszUryga;
//Odwróćmy teraz sytuację z warsztatu "Gra w zgadywanie liczb": to użytkownik pomyśli sobie liczbę z zakresu 1-1000, a komputer będzie 
//zgadywał i zrobi to maksymalnie w 10 ruchach (pod warunkiem, że gracz nie będzie oszukiwał).
//
//Zadaniem gracza będzie udzielanie odpowiedzi "więcej", "mniej", "trafiłeś".
//
//Do tego warsztatu dołączony jest schemat blokowy algorytmu. Zaimplementuj go w Javie.
//![flowchart](img/flowchart.png)
import java.util.Scanner;

public class Game2 {

	public static void main(String[] args) {
		final String MESSAGE="Wprowadź odpowiedź z klawiatury: \n 1 jeżeli zgadłem, \n 2 jeżeli moja liczba jest za wysoka, \n 3 jeżeli jest za niska";
		System.out.println("Pomyśl liczbę naturalną z zakresu 1-1000, a ja ją zgadnę w max. 10 ruchcach");
		System.out.println(MESSAGE);
		int min=0;
		int max=1000;
		int guess;
		int quessed=0;
		String answer;
		int count=1;
		for (int i=0;i<10;i++) {
			guess=((max-min)/2)+min;
			System.out.println("Zgaduję: "+guess);
			Scanner scan = new Scanner(System.in);
			answer=scan.nextLine();
			if (answer.equals("1"))	{
				quessed=1;
				break;
			}
			else	{
				if (answer.equals("2"))	{
					max=guess;
				}
				else	{
					if (answer.equals("3")) {
						min=guess;
					}
					else	{
						System.out.println("Nie oszukuj!");
					}
				}
			}
			count++;
			
		}
		if (quessed==0) {
			System.out.println("Wygrałeś, nie zgadłem Twojej liczby w 10 ruchach");
		}
		else	{
			System.out.println("Przegrałeś, a mi wystarczyło "+count+" ruchów");
		}
	}

}
