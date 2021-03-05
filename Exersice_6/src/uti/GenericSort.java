package uti;

public class GenericSort {
	public static void main(String[] args) {
		Circle[] c = {new Circle(3), new Circle(), new Circle(2, "red", false)};
		Rectangle[] r = {new Rectangle(3, 4), new Rectangle(), new Rectangle(2, 5, "green", true)};
		
		sort(c);
		sort(r);
		
		printList(c);
		printList(r);
	}

	/** Sort an array of comparable objects */
	public static <T extends Comparable<T>> void sort(T[] list) {
		T currentMin;
		int currentMinIndex;

		for (int i = 0; i < list.length - 1; i++) {
// Find the minimum in the list[i+1..list.length−2]
			currentMin = list[i];
			currentMinIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (currentMin.compareTo(list[j]) > 0) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}

// Swap list[i] with list[currentMinIndex] if necessary;
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}

	/** Print an array of objects */
	public static void printList(Object[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
}
