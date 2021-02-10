package uti;

public class PowerOfTwo {

	public static void main(String[] args) {
		final int power = 4;
		
		// recursion
		System.out.println(powerOfTwo(power));
		
		// the iterative variant
		long result = 1;
		for(int i = 0; i < power; i++) {
			result *= 2;
		}
		System.out.println(result);
	}

	public static int powerOfTwo(int n) {
	   	 if (n == 0)
	   		 return 1;
	   	 else
	   		 return 2 * powerOfTwo(n - 1);
	}
	
}
