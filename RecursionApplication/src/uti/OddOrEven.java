package uti;

import java.util.Scanner;

public class OddOrEven {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		
		if (odd(number)) {
			System.out.println("The number is odd.");
		}
		else {
			System.out.println("The number is even.");
		}

	}
	
	public static boolean odd(int n) {
		if (n < 2) {
			return n == 1;
		}
		return odd(n - 2);
	}
	
	public static boolean even(int n) {
		if (n < 2) {
			return n == 0;
		}
		return even(n - 2);
		
	}

}
