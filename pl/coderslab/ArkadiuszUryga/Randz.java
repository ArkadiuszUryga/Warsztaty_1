package pl.coderslab.ArkadiuszUryga;
//losuje jedną liczbę z zakresu 1-100
import java.util.Random;

public class Randz {

	public static void main(String[] args) {
		

	}
	public static int rand	() {
		Random rand=new Random();
		int randNumber = rand.nextInt(101);
		return randNumber;
	}

}
