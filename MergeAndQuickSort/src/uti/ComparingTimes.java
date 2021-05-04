package uti;

import java.util.Date;
import java.util.Random;

public class ComparingTimes {

	public static void main(String[] args) {
		final int length = 300_000;
		Random r = new Random();
		
		int[] list = new int[length];
		for(int i = 0; i < length; i++) {
			list[i] = r.nextInt(length * 2);
		}
		
		int[] copy1 = new int[length];
		System.arraycopy(list, 0, copy1, 0, list.length);
		int[] copy2 = new int[length];
		System.arraycopy(list, 0, copy2, 0, list.length);
		int[] copy3 = new int[length];
		System.arraycopy(list, 0, copy3, 0, list.length);
		
		Date start = new Date();
		
//		insertionSort(list);
		Date insertionEnd = new Date();
//		System.out.println(insertionEnd.getTime() - start.getTime());
		
		bubbleSort(copy1);
		Date bubbleEnd = new Date();
		System.out.println(bubbleEnd.getTime() - insertionEnd.getTime());
		
//		mergeSort(copy2);
//		Date mergeEnd = new Date();
//		System.out.println(mergeEnd.getTime() - insertionEnd.getTime());
//		
//		quickSort(copy3, 0, copy3.length - 1);
//		Date end = new Date();
//		System.out.println(end.getTime() - mergeEnd.getTime());
//		
	}
	
	public static void insertionSort(int[] list) {
		for (int i = 1; i < list.length; i++) {
			int currentElement = list[i];
			int k;
			for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
				list[k + 1] = list[k];
			}

			list[k + 1] = currentElement;
		}
	}
	
	public static void bubbleSort(int[] list) {
		boolean needNextPass = true;
		for (int k = 0; k < list.length - 1 && needNextPass; k++) {
			needNextPass = false;
			for (int i = 0; i < list.length - k - 1; i++) {
				if (list[i] > list[i + 1]) {
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					needNextPass = true; 
				}
			}
		}
	}
	
	public static void mergeSort(int[] list) {
		if (list.length > 1) {
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);

			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);

			merge(firstHalf, secondHalf, list);
		}
	}

	public static void merge(int[] list1, int[] list2, int[] temp) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;

		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}
		while (current1 < list1.length)
			temp[current3++] = list1[current1++];
		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}
	
	public static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	public static int partition(int[] list, int first, int last) {
		int pivot = list[first];
		int low = first + 1;
		int high = last; 
		while (high > low) {
			while (low <= high && list[low] <= pivot)
				low++;

			while (low <= high && list[high] > pivot)
				high--;

			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		while (high > first && list[high] >= pivot)
			high--;

		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		} else {
			return first;
		}
	}
}

/**
 * Time in milliseconds
 *  Array Size | Selection Sort | Bubble Sort | Merge Sort | Quick Sort
 *  -----------|----------------|-------------|------------|------------
 *    50 000   |	  1000	    |  4200-4500  |	  15-30	   |   15-30
 *   100 000   |   3800-4500	|	 17000	  |	  25-50	   |   40-50
 *   150 000   |	  8800	    |    38000	  |	  40-45    |   30-45
 *   200 000   |	 15500	    |	 68000	  |   50-55	   |   45-55
 *   250 000   |  24000-24400   |   107000	  |	  65-70	   |   50-55
 *   300 000   |	 35000	    |   155000	  |	    75	   |   50-60
 */
