package uti;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int decimal = sc.nextInt();
		
		String result = new StringBuffer(dec2Bin(decimal)).reverse().toString();
		System.out.println(result);
	}

	public static String dec2Bin(int value) {
		String s = "";
		if (value == 1) {
			return s + 1;
		}
		else {
			s += value % 2;
			return s + dec2Bin(value / 2);
		}
	}
	
}
