package uti;

public class Pow {

	public static void main(String[] args) {
		final int x = 2;
		final int n = 5;
		System.out.println(x + "^" + n + " = " + pow(2, 5));

	}

	public static int pow(int x, int n) {
		return pow(x, n, 1);
	}
	
	private static int pow(int x, int n, int result) {
		if (n == 0) {
			return result;
		}

		return pow(x, n - 1, result * x);
	}
	
}
