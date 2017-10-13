package pl.coderslab.ArkadiuszUryga;

import java.util.Scanner;

public class nextInt {

	public static void main(String[] args) {
		

	}
	public static int getInt(String message)	{
    	Scanner scan= new Scanner(System.in);
    	System.out.println(message);
    	while (!scan.hasNextInt())	{
    		System.out.println("miała być liczba \n"+message);
    		scan.next();
    		
    	}
    	return scan.nextInt();
    }

}
