package uti;

public class BubbleSort {
	/** Bubble sort method */
	public static void bubbleSort(int[] list) {
		for (int k = 0; k < list.length - 1; k++) {
			for (int i = 0; i < list.length - 1 - k; i++) {
				if (list[i] > list[i + 1]) {
					// Swap list[i] with list[i + 1]
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
				}
			}
		}
	}
	
//	public static void bubbleSort(int[] list) {
//		boolean needNextPass = true;
//		for (int k = 0; k < list.length - 1 && needNextPass; k++) {
//			// Array may be sorted and next pass not needed
//			needNextPass = false;
//			for (int i = 0; i < list.length - k - 1; i++) {
//				if (list[i] > list[i + 1]) {
//					// Swap list[i] with list[i + 1]
//					int temp = list[i];
//					list[i] = list[i + 1];
//					list[i + 1] = temp;
//					needNextPass = true; // Next pass still needed
//				}
//			}
//		}
//	}
//	
}

/**
 * T = (n - 1) + c + (n - 2) + c + (n - 3) + c + .... + 1 + c =
 * 	 = (n - 1 + 1 ) * (n - 1) / 2 + (n - 1) * c =
 * 	 = n * (n - 1) / 2 + (n - 1) * c =
 * 	 = 0.5 * n^2 - n * (0.5 - c) + c =
 * 	 = n^2
 * 
 * => O(n^2)
 */
