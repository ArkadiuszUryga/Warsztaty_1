package pl.coderslab.ArkadiuszUryga;
// najczęściej powtarzających się słów nie zapisuję w pliku tekstowym. uzyskuję ten sam efekt korzystajc z hashmapy
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Comparator;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


class PopularTitles {

	public static void main(String[] args) {
		String site = "https://www.onet.pl/";
		Connection connect = Jsoup.connect(site);
		try {
			HashMap<String, Integer> slowa = new HashMap<String, Integer>(); //inicjalizacja hashmapy przed jakąkolwiek pętlą
		    Document document = connect.get();
		    //pobranie tytułów z tagu html **span** z atrybutem class o wartości **title**
		    Elements links = document.select("span.title");
		    for (Element elem : links) {
		    	//każdy tytuł dzielę na słowa po spacjach i wypisanych poniżej znakach
		        StringTokenizer st = new StringTokenizer(elem.text(), ".,!?:-/| ");
		        
		        while (st.hasMoreTokens()) { 
		        	String token=st.nextToken();
		        	//usuwam cudzysłowy
		        	token=token.replace("\"", "");
		        	token=token.toLowerCase();
		        	//jeżeli długość słowa nie jest większa niż 3 nie biorę go pod uwagę
		        	if (token.length()>3) {
		        		//jeżeli słowo już jest w hashmapie nadpisuję go ze zwiększoną wartością
		        		if (slowa.containsKey(token))	{
		        			
		        			int wartosc=slowa.get(token);
		        			wartosc++;
		        			slowa.put(token, wartosc);
		        		}
		        		else	{
		        			//jeśli słowa nie ma jest dopisywane z wrtością 1
		        			slowa.put(token, 1);
		        		}
		             
		        	}
		        	
		        } 
		        
		    }
		    //poniższy kod (aż do return result) sortuje mapę po wartościach. wykorzystuje dodatkową klasę ValueComparator
		    TreeMap<String, Integer> sortedMap = sortMapByValue(slowa);  
			System.out.println("Najczęściej pojawiające się w tytułach artykułów słowa na stronie: "+site);
			//rozdzielenie mapy na pary: klucz, wartość w celu czytelniejszego wypisania na ekran
			Set<Map.Entry<String, Integer>> pary = sortedMap.entrySet();
			//wypisuję na ekranie posortowaną po wartościach mapę. limit określa po ilu przejściach pętla ma być przerwana
			int limit = 0;
			
			for (Map.Entry<String, Integer> para: pary) {
				if (limit<=10) {
	            System.out.println(para.getKey() + " " + para.getValue()+" powtórzeń");
				}
				else	{
					break;
				}
				limit++;
	        }      
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
	public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map){
		Comparator<String> comparator = new ValueComparator(map);
		//TreeMap is a map sorted by its keys. 
		//The comparator is used to sort the TreeMap by keys. 
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
	}
	
	

}