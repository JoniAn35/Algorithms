package uti;

import java.awt.Color;
import java.util.Date;
import java.util.Random;

class Ball {
	Random rand = new Random();
	int x = 0;
	int y = 0; // Current ball position
	int dx = rand.nextInt(10); // Increment on ball's x-coordinate
	int dy = rand.nextInt(10);; // Increment on ball's y-coordinate
	int radius = rand.nextInt(19) + 2; // Ball radius
	Date timeCreated = new Date();
	Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
}
