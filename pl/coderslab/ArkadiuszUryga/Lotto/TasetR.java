package coderslab.ArkadiuszUryga.Lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class TasetR {

	public static void main(String[] args) {
		
	
		    
		    int tab[];
		    boolean pom = false;
		    int tabPom[];
		    int k = 0;
		    int zakres;
		     public tab(int n,int zakres)
		     {
		         this.zakres = zakres;
		         this.tab = new int[n];
		         this.tabPom = new int[n];
		     }
		     
		     public void losuj() throws Exception
		     {

		             if(zakres < tab.length) throw new Exception("Za mały zakres liczb");
		                Random rand = new Random();
		                for(int i=0; i<tab.length; i++)
		                {
		                    pom = false;
		                    tab[i] = rand.nextInt(zakres) + 1;
		                    for(int j=0; j<i; j++)
		                    {
		                        if(tab[i] == tab[j]) {
		                            pom = true;
		                            i--;
		                        }
		                    }
		                    if(pom == false)
		                    {
		                        tabPom[k] = tab[i];
		                        k++;
		                    }
		                }
		        
		     }
		     
		     public void wypisz()
		     {
		         System.out.println("Liczb jest " + k);
		         for(int i=0; i<k; i++)
		         {
		             System.out.print(tabPom[i] + " ");
		         }
		     }
		    
	
		

	}

}
