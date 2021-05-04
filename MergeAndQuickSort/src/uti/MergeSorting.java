package uti;

import java.util.Comparator;

public class MergeSorting<T> {

	public static void main(String[] args) {
		Animal[] list = {new Animal(45), new Animal(150), new Animal(100),new Animal(400)};
		mergeSort(list);
//		for (int i = 0; i< list.length; i++) {
//			System.out.println(list[i]);
//		}
		
		mergeSort(list, new AnimalComparator());
		for (int i = 0; i< list.length; i++) {
			System.out.println(list[i]);
		}
	}

	public static <T extends Comparable<T>> void mergeSort(T[] list) {
		if (list.length > 1) {
			T[] firstHalf = (T[])new Comparable[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);

			int secondHalfLength = list.length - list.length / 2;
			T[] secondHalf = (T[])new Comparable[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);

			merge(firstHalf, secondHalf, list);
		}
	}

	public static <T extends Comparable<T>> void merge(T[] list1, T[] list2, T[] temp) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;

		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1].compareTo(list2[current2]) < 0) {
				temp[current3++] = list1[current1++];
			}
			else {
				temp[current3++] = list2[current2++];
			}
		}
		while (current1 < list1.length) {
			temp[current3++] = list1[current1++];
		}
		while (current2 < list2.length) {
			temp[current3++] = list2[current2++];
		}
	}
	
	public static <T> void mergeSort(T[] list, Comparator <? super T> comparator) {
		if (list.length > 1) {
			T[] firstHalf = (T[])new Comparable[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf, comparator);

			int secondHalfLength = list.length - list.length / 2;
			T[] secondHalf = (T[])new Comparable[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf, comparator);

			merge(firstHalf, secondHalf, list, comparator);
		}
	}

	public static <T> void merge(T[] list1, T[] list2, T[] temp, Comparator <? super T> comparator) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;

		while (current1 < list1.length && current2 < list2.length) {
			if (comparator.compare(list1[current1], list2[current2]) < 0) {
				temp[current3++] = list1[current1++];
			}
			else {
				temp[current3++] = list2[current2++];
			}
		}
		while (current1 < list1.length) {
			temp[current3++] = list1[current1++];
		}
		while (current2 < list2.length) {
			temp[current3++] = list2[current2++];
		}
	}
}
