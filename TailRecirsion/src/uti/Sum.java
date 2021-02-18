package uti;

public class Sum {

	public static void main(String[] args) {
		final int number = 5;
		System.out.println("Sum is " + sum(number));
	}

	public static int sum(int n) {
		return sum(n, 0);
	}

	private static int sum(int n, int result) {
		if (n == 0)
			return result;
		else
			return sum(n - 1, result + n);
	}

}
