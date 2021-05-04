package uti;

public class Animal implements Comparable<Animal>{
	int height;
	
	Animal(int hight) {
		this.height = hight;
	}
	
	@Override
	public int compareTo(Animal o) {
		return this.height - o.height;
	}	
	
	public String toString() {
		return "Height: " + height + "cm.";
	}
}
