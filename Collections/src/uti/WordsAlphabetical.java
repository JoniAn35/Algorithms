package uti;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class WordsAlphabetical {

	public static void main(String[] args) {
		Scanner sc = new Scanner(WordsAlphabetical.class.getResourceAsStream("lemons.txt"));
		LinkedList<String> list = new LinkedList<>();
		
		while (sc.hasNextLine()) {
			String word = sc.next();
			
			System.out.print(word + " ");
			if(word.indexOf(".") != -1) {
				System.out.println();
			}
			
			list.add(word);
		}
		
		Collections.sort(list);
		System.out.print(list);
	}

}
