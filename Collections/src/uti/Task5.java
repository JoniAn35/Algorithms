package uti;

import java.util.LinkedList;
import java.util.Random;

public class Task5 {
	public static void main(String[] args) {
		Random rnd = new Random();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 5000000; i++) {
			list.add(rnd.nextInt());
		}
		Integer value = new Integer(0);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000000; i++) {
			value = list.get(i);
		}
		long stop = System.currentTimeMillis();
		System.out.println("Elapsed time is" + (stop - start) / 1000 + " seconds");

	}

}