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
		if (n == 1) {
			return true;
		}
		else if (n == 0) {
			return false;
		}
		else {
			return odd(n - 2);
		}
	}
	
	public static boolean even(int n) {
		if (n == 1) {
			return false;
		}
		else if (n == 0) {
			return true;
		}
		else {
			return even(n - 2);
		}
	}

}
