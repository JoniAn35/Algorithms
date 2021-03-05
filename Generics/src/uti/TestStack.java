package uti;

import java.util.Scanner;

public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Stack<String> stack = new Stack<>();
		for(int i = 0; i < 5; i++) {
			stack.add(sc.next());
		}
		
		for(int i = 5; i > 0; i--) {
			System.out.print(stack.get(i - 1) + " ");
		}
	}

}
