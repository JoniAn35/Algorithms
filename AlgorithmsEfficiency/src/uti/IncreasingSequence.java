package uti;

import java.util.Scanner;

public class IncreasingSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String s = sc.next();
		
		String sequence = "";
		sequence += s.charAt(0); 
		int ascii = (int)s.charAt(0);
		int n = s.length();
		char symbol;
		// O(n)
		for(int i = 1; i < n; i++) {
			symbol = s.charAt(i);
			if(ascii < (int)symbol) {
				sequence += symbol;
				ascii = (int)symbol;
			}
		}
		System.out.println(sequence);
	}

}
