package uti;

import java.util.Scanner;

public class OneStringInAnother {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first string: ");
		String s1 = sc.next();
		System.out.println("Enter the first string: ");
		String s2 = sc.next();
		
		int n = s1.length();
		int m = s2.length();
		int i = 0, j = 0;
		
		if(n < m) {
			System.out.println("No match");
		}
		else {
			// O(n)
			// s1 = Mississipi
			// s2 = sip
			for (; i < n; i++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					j++;
				}
				else {
					j = 0;
					if(s1.charAt(i) == s2.charAt(j)) {
						j++;
						
					}
				}
				
				if(j == m) {
					break;
				}
			}
		}
		
		if(j == m) {
			System.out.println("matched at index " + (i - m + 1));
		}
		else {
			System.out.println("No match");
		}
	}

}
