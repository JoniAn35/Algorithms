package uti;

import java.util.ArrayList;
import java.util.Collections;

public class GenericMethods {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(96);
		list.add(15);
		list.add(83);
		list.add(43);
		
		shuffle(list);
		sort(list);
		System.out.println(min(list));
	}
	public static <T> void shuffle(ArrayList<T> list) {
		Collections.shuffle(list);
		System.out.println(list);
	}
	public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
		Collections.sort(list);
		System.out.println(list);
	}
	public static <T extends Comparable<T>> T min(ArrayList<T> list) {
		T min = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if(min.compareTo(list.get(i)) > 0) {
				min = list.get(i); 
			}
		}
		return min;
	}

}
