package uti;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Capitals {

	public static void main(String[] args) {
		// /Users/yoanaangelova/Desktop/java/Algorithms/Maps/src/uti/CountriesOfEurope.txt
		// /Users/yoanaangelova/Desktop/java/Algorithms/Maps/src/uti/CountriesOfEurope.txt"
		Scanner readText = new Scanner(
				Capitals.class.getResourceAsStream("CountriesOfEurope.txt")); 
		Map<String, String> countriesOfEurope = new TreeMap<>();
		while(readText.hasNext()) {
			countriesOfEurope.put(readText.next(), readText.next());
		}
		
		int points = 0;
		ArrayList<String> countries = new ArrayList<>(countriesOfEurope.keySet());
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		String answear = "";
		
		System.out.println("Write the capitals to the givven countreis:");
		do{
			String country = countries.get(r.nextInt(countriesOfEurope.size()));
			System.out.println(country);
			answear = sc.next();
			if(!answear.equals("exit")) {
				if (answear.equals(countriesOfEurope.get(country))) {
				points++;
				System.out.println("Correct. You have " + points + " points.");
				}
				else {
					points--;
					System.out.println("Incorrect. The correct answear is " + countriesOfEurope.get(country) 
						+ ".\nYou have " + points + " points.");
				}
			}
		}while(!answear.equals("exit"));
		
		System.out.println("End of the game.");
		sc.close();
	}

}
