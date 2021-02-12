package uti;

import java.util.Scanner;

public class TowerOfHanoi {

	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of disks: ");
		int n = input.nextInt();
		// Find the solution recursively
		System.out.println("The moves are: " + moveDisks(n, 'A', 'B', 'C'));
		
	}

	/**
	 * The method for finding the solution to move n disks from fromTower to toTower
	 * with auxTower
	 */
	
//	public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
//	
//		if (n == 1) // Stopping condition
//			System.out.println("Move disk " + n + " from "+ fromTower + " to " + toTower);
//		else {
//			moveDisks(n - 1, fromTower, auxTower, toTower);
//			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
//			moveDisks(n - 1, auxTower, toTower, fromTower);
//		}
//	}
	
	public static int moveDisks(int n, char fromTower, char toTower, char auxTower) {
		int numberOfMoves = 0;
		if (n == 1) // Stopping condition
			return 1;
		else {
			numberOfMoves++;
			return numberOfMoves + moveDisks(n - 1, fromTower, auxTower, toTower) + 
					moveDisks(n - 1, auxTower, toTower, fromTower);
		}
	}

}
