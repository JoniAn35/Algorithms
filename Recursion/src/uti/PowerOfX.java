package uti;

import java.util.Scanner;

public class PowerOfX {

	public static void main(String[] args) {
		final int power = 4;
		double x;
		Scanner sc = new Scanner(System.in);
		x = sc.nextDouble();

		// recursion
		System.out.println(powerOfX(x, power));

		// the iterative variant
		double result = 1;
		for (int i = 0; i < power; i++) {
			result *= x;
		}
		System.out.println(result);
	}

	public static double powerOfX(double number, int power) {
		if (power == 0)
			return 1;
		else
			return number * powerOfX(number, power - 1);
	}

}
