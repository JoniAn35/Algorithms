package uti;

import java.util.Comparator;

public class BallComparator implements Comparator<Ball> {

	@Override
	public int compare(Ball o1, Ball o2) {
		return Double.compare(o2.radius, o1.radius);
	}

}
