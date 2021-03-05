package uti;

import java.util.Arrays;

public class GenericStackArray<T> {
//	private java.util.ArrayList <T> list = new java.util.ArrayList<>();
	private T[] t = (T[]) new Object[5];
	private int size;

	public GenericStackArray() {
		size = 0;
	}
	
	public int getSize() {
		return size;
	}

	public T peek() {
		return t[size - 1];
	}

	public void push(T o) {
		if(size >= t.length) {
			Arrays.copyOf(t, t.length*2);
		}
		t[size++] = o;
	}

	public T pop() {
		T o = t[--size];
		return o;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		return "stack: " + t.toString();
	}

	public void setSize(int size) {
		this.size = size;
	}
}
