package uti;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class VowelsAndConsonants {

	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("/Users/yoanaangelova/Desktop/java/Algorithms/Sets/src/uti/lemons.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return;
		}
		
		HashSet<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'U', 'O', 'a', 'e', 'i', 'u', 'o'));
		int ch;
		int numberOfVowels = 0;
		int numberOfConsonants = 0;
		try {
			while((ch = fr.read()) != -1) {
				char character = (char)ch;
				if ((64 < character && character < 91) || (96 < character && character < 123)) {
					if (vowels.contains(character)) {
						numberOfVowels++;
					}
					else {
						numberOfConsonants++;
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Vowels: " + numberOfVowels + "\nConsonants: " + numberOfConsonants);
	}

}
