package uti;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;

import javax.swing.JPanel;

class MazePanel extends JPanel {

	boolean displayPath = false;

	Maze m;
	int margin = 3;

	public MazePanel() {

		try {
			m = new Maze("src/mazes.txt");
			
			if (MazeSolver.solveMaze(m)) {
				System.out.println("You won!");
			} else {
				System.out.println("No path");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void findPath() {
		displayPath = true;
		repaint();
	}

	public void cleanPath() {
		displayPath = false;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 
		g.setColor(Color.WHITE);
		
		int width = getWidth() / m.maze[0].length - margin;
		int height = getHeight() / m.maze.length - margin; 
		
		
		for (int i = 0; i < m.maze.length; i++) {
			for (int j = 0; j < m.maze[i].length; j++) {
				if (m.maze[i][j] == 1 || m.maze[i][j] == 3) {
					g.fillRect(margin + j * (width + margin), margin + i * (height * margin), width, height);
				} else if (m.maze[i][j] == 2) {
					g.setColor(Color.RED);
					g.fillRect(margin + j * (width + margin), margin + i * (height * margin), width, height);
					g.setColor(Color.WHITE);
				}
			}
		}
		
		if (displayPath) {
			g.setColor(Color.BLACK);
			for (Position p : m.path) {
				g.fillRect(margin + p.x * (width + margin), margin + p.y * (height * margin), width, height);
			}
		}

	}
}