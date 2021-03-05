package uti;

import java.util.ArrayList;
import java.util.Arrays;

public class Stack<T> extends ArrayList<T>{
	
	public void push(T o) {
		add(o);
	}
	
	public T pop() {
		T t = get(size() - 1);
		remove(size() - 1);
		return t;
	}
	
	public T peek() {
		return get(size() - 1);
	}

}
