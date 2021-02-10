package uti;

public class SumOfIncreasingNumbers {

	public static void main(String[] args) {
		final int maxNumber = 5;
		// recursion
	   	System.out.println("Sum is " + xMethod(maxNumber));
	   	
	   	// the iterative variant
	   	int sum = 0;
	   	for(int n = 1; n <= maxNumber; n++) {
	   		sum += n;
	   	}
	   	System.out.println("Sum is " + sum);
	}

	public static int xMethod(int n) {
	   	 if (n == 1)
	   		 return 1;
	   	 else
	   		 return n + xMethod(n - 1);
	}


}
