package uti;

import java.util.Scanner;

public class IncreasingSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String s = sc.next();
		
		String sequence = ""; 
		int ascii = 0;
		int n = s.length();
		char symbol;
		int max = 0;
		// O(n^2)
		for (int i = 0; i < n; i++) {
			int currentMax = 0;
			String currentSequence = s.substring(i, i + 1);
			ascii = (int)s.charAt(i);
			for(int j = i + 1; j < n; j++) {
				symbol = s.charAt(j);
				if(ascii < (int)symbol) {
					currentSequence += symbol;
					ascii = (int)symbol;
					currentMax++;
				}
			}
			if(max < currentMax) {
				max = currentMax;
				sequence = currentSequence;
			}
		}
		System.out.println(sequence);
	}

}
