package uti;

public class ReversingNumbers {

	public static void main(String[] args) {
	   	final int number = 1234567;
	  
		// recursion
		xMethod(number);
	   	
		System.out.println();
		
		// the iterative variant
		for (int n = number; n > 0; n /= 10) {
			System.out.print(n % 10);
		}
	}

	public static void xMethod(int n) {
	   	if (n > 0) {
	   		System.out.print(n % 10);
	   		xMethod(n / 10);
	   	}
	}


}
