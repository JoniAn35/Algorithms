package uti;

import java.util.Arrays;
import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		final int size = 10;
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[size];
		for(int i = 0; i < size; i++) {
			nums[i] = sc.nextInt();
		}
		
		System.out.println("The avegare of the numbers is " + average(nums, size));
	}

	public static double average(int[] n, int size) {
		return sum(n, 0) / 10;
	}
	
	private static double sum(int[] n, double result) {
		int size = n.length;
		if(size == 0) {
			return result;
		}
		else {
			return sum(Arrays.copyOf(n, n.length-1), result + n[size - 1]);
		}
	}
}
