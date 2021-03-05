package uti;

import java.util.Scanner;

public class TestGenericStack {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner sc = new Scanner(System.in);
		GenericStackArray<String> stack = new GenericStackArray<>();
		
		for(int i = 0; i < 5; i++) {
			stack.push(sc.next());
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.print(stack.pop() + " ");
		}
	}
	
}
