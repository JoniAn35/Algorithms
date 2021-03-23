package uti;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class PairsOfCharacters {

	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("/Users/yoanaangelova/Desktop/java/Algorithms/StacksAndQueues/src/uti/TestProgramForPOC.java");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return;
		}
		Stack<Character> list = new Stack<>();
		ArrayList<Character> open = new ArrayList<>(Arrays.asList('(', '[', '{'));
		ArrayList<Character> close = new ArrayList<>(Arrays.asList(')', ']', '}'));
		
		boolean isTheCodeRight = true;
		int ch;
		try {
			while((ch = fr.read()) != -1) {
				char character = (char)ch;
				if(open.contains(character)) {
					list.push(character);
					continue;
				}
				if (close.contains(character)) {
					try {
						char c = list.pop();
						if (close.indexOf(character) != open.indexOf(c)) {
							isTheCodeRight = false;
							break;
						}
					} catch (EmptyStackException e) {
						isTheCodeRight = false;
						break;
					}
				}
			}
			
			if (isTheCodeRight) {
				isTheCodeRight = list.isEmpty();
			}
		} catch (IOException e) {
			e.printStackTrace();
			
			return;
		}
		finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(isTheCodeRight);
	}

}
