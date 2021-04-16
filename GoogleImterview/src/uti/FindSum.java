package uti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class FindSum {

	public static void main(String[] args) {
		final int surchedSum = 15;
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 9, 5, 6, 7, 4));

		twoLoops(list, surchedSum);
		binarySearch(list, surchedSum);
		sortedArray(list, surchedSum);
		hashSetSearch(list, surchedSum);
	}

	public static void twoLoops(ArrayList<Integer> a, int sum) {
		int firstIndex = 0, lastIndex = 0;
		boolean foundSum = false;
		for (int i = 0; i < a.size(); i++) {
			for (int j = i + 1; j < a.size(); j++) {
				if (a.get(i) + a.get(j) == sum) {
					firstIndex = i;
					lastIndex = j;
					foundSum = true;
				}
			}
		}
		if (foundSum) {
			System.out.println("Found sum: " + a.get(firstIndex) + " + " + a.get(lastIndex));
		} else {
			System.out.println("Sum not found");
		}
	}

	public static void binarySearch(ArrayList<Integer> a, int sum) {
		int i = 0, j = 0;
		boolean foundSum = false;
		Collections.sort(a);
		for (; i < a.size() - 1; i++) {
			int low = i + 1;
			int high = a.size() - 1;
			int balance = sum - a.get(i);
			while (low <= high) {
				int mid = (low + high) / 2;
				if (balance < a.get(mid)) {
					high = mid - 1;
				} else if (balance == a.get(mid)) {
					j = mid;
					foundSum = true;
					break;
				} else {
					low = mid + 1;
				}
			}
			if(foundSum) {
				break;
			}
		}
		if (foundSum) {
			System.out.println("Found sum: " + a.get(i) + " + " + a.get(j));
		} else {
			System.out.println("Sum not found");
		}
	}

	public static void sortedArray(ArrayList<Integer> a, int sum) {
		Collections.sort(a);
		int high = a.size() - 1;
		int low = 0;
		boolean foundSum = false;
		while (low < high) {
			int s = a.get(low) + a.get(high);
			if (s > sum) {
				high--;
			} else if (s < sum) {
				low++;
			} else {
				foundSum = true;
				break;
			}
		}
		if (foundSum) {
			System.out.println("Found sum: " + a.get(low) + " + " + a.get(high));
		} else {
			System.out.println("Sum not found");
		}
	}
	
	public static void hashSetSearch(ArrayList<Integer> a, int sum) {
		int i = 0;
		int n = 0;
		boolean foundSum = false;
		HashSet<Integer> set = new HashSet<>();
		for (; i < a.size(); i++) {
			int balance = sum - a.get(i);
			if (set.contains(a.get(i))) {
				n = balance;
				foundSum = true;
				break;
			}
			else {
				set.add(balance);
			}
		}
		if(foundSum) {
			System.out.println("Found sum: " + a.get(i) + " + " + n);
		}
		else {
			System.out.println("Sum not found");
		}
	}

}
