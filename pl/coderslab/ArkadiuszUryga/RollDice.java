package pl.coderslab.ArkadiuszUryga;

import java.util.Random;
import java.util.StringTokenizer;

public class RollDice {

	public static void main(String[] args) {
		
		

		
		//Write each in a separate line codes of roll dice type (min 2 for each dice type)
		
		String roll1 = "4D3+4";
		String roll2 = "7D3+2";
		String roll3 = "4D4+7";
		String roll4 = "7D4+8";
		String roll5 = "4D6+5";
		String roll6 = "2D6+3";
		String roll7 = "6D8+3";
		String roll8 = "9D8+5";
		String roll9 = "3D10+3";
		String roll10 = "2D10+8";
		String roll11 = "9D12+9";
		String roll12 = "2D12+8";
		String roll13 = "8D20+1";
		String roll14 = "D20+4";
		String roll15 = "6D100";
		String roll16 = "2D100+40";
		rollCube(roll1);
		rollCube(roll2);
		rollCube(roll3);
		rollCube(roll4);
		rollCube(roll5);
		rollCube(roll6);
		rollCube(roll7);
		rollCube(roll8);
		rollCube(roll9);
		rollCube(roll10);
		rollCube(roll11);
		rollCube(roll12);
		rollCube(roll13);
		rollCube(roll14);
		rollCube(roll15);
		rollCube(roll16);
		
	}
	//write a method that accepts a string - code throws a cube, returning the result int throw
	private static int rollCube(String roll)	{
		int sum=0;
		int x; //ilość rzutów kostką
		int y; //liczba ścian kostki
		int z; //liczba dodawana na końcu po wykonaniu wszystkich rzutów
		String firstSplit;
		System.out.println();
		System.out.println("=======================================");
		System.out.println(roll);
		System.out.println("=======================================");
		System.out.println();
		StringTokenizer st = new StringTokenizer(roll,"\\+");
		
			firstSplit=st.nextToken();
			if (st.hasMoreTokens()) {
				z=Integer.parseInt(st.nextToken());
			}
			else	{
				z=0;
			}
			StringTokenizer st2 = new StringTokenizer(firstSplit, "D");
			int count =st2.countTokens();
			if (count==1) {
				x=1;
				y=Integer.parseInt(st2.nextToken());
				
			}
			else	{
				x=Integer.parseInt(st2.nextToken());
				y=Integer.parseInt(st2.nextToken());
				
			}
			Random rand = new Random();
			for (int i=1;i<=x;i++) {
				int randomed=rand.nextInt(y)+1;
				System.out.println("Rzut "+i+". Wyzrucono "+randomed);
				sum+=randomed;
			}
			sum+=z;
			if (x>4) {
				System.out.println(x+" rzutów kostką "+y+"-ścienną zmodyfikowane o wartość "+z+" daje w sumie "+sum );	
			}
			else	{
			System.out.println(x+" rzuty kostką "+y+"-ścienną zmodyfikowane o wartość "+z+" dają w sumie "+sum );
			}
		
		
		return sum;
		
	}

}
