package uti;

import java.util.Arrays;
import java.util.PriorityQueue;

public class UnionIntersectionDifference {

	public static void main(String[] args) {
		PriorityQueue<String> queue1 = new PriorityQueue<>();
		queue1.add("George");
		queue1.add("Jim");
		queue1.add("John");
		queue1.add("Blake");
		queue1.add("Kevin");
		queue1.add("Michael");
		System.out.println("Queue 1:" + queue1);

		PriorityQueue<String> queue2 = new PriorityQueue<>();
		queue2.add("George");
		queue2.add("Katie");
		queue2.add("Kevin");
		queue2.add("Michelle");
		queue2.add("Ryan");
		System.out.println("Queue 2:" + queue2);

		System.out.println("\nUnion: " + union(queue1, queue2));
		System.out.println("Intersection: " + intersection(queue1, queue2));
		System.out.println("Difference: " + difference(queue1, queue2));
	}

	public static PriorityQueue<String> union(PriorityQueue<String> queue1, PriorityQueue<String> queue2) {
		PriorityQueue<String> union = new PriorityQueue<>(queue1);
		for (String q : queue2) {
			if (!union.contains(q)) {
				union.add(q);
			}
		}
//		return new PriorityQueue<String>(union);
		return union;
	}

	public static PriorityQueue<String> intersection(PriorityQueue<String> queue1, PriorityQueue<String> queue2) {
		PriorityQueue<String> intersection = new PriorityQueue<>(queue1);
		for (String q : queue1) {
			if (!queue2.contains(q)) {
				intersection.remove(q);
			}
		}
//		return new PriorityQueue<String>(union);
		return intersection;
	}

	public static PriorityQueue<String> difference(PriorityQueue<String> queue1, PriorityQueue<String> queue2) {
		PriorityQueue<String> difference = new PriorityQueue<>(queue1);
		for (String q : queue2) {
			if (difference.contains(q)) {
				difference.remove(q);
			}
			else {
				difference.add(q);
			}
		}
//		return new PriorityQueue<String>(union);
		return difference;
	}
}
