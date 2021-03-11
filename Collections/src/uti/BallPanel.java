package uti;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Timer;

import javax.swing.JPanel;

class BallPanel extends JPanel {
	private int delay = 10;
	private ArrayList<Ball> list = new ArrayList<>();
// Create a timer with the initial delay
	protected Timer timer = new Timer(delay, new TimerListener());

	private class TimerListener implements ActionListener {
		@Override /** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	private boolean hasClash(Ball ball) {
		double distance;

		for (int i = 0; i < list.size(); i++) {
			Ball clash = list.get(i);
			distance = Math.sqrt(Math.pow(ball.x - clash.x, 2) + Math.pow(ball.y - clash.y, 2));
			if (ball != clash && (distance < (ball.radius + clash.radius))) {
				if (ball.timeCreated.before(clash.timeCreated)) {
					ball.radius += clash.radius;
					list.remove(clash);
				} else {
					clash.radius += ball.radius;
					list.remove(ball);
				}
				return true;
			}
		}
		return false;
	}

	public BallPanel() {
		timer.start();
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Ball ball;
				double distance;
				for (int i = 0; i < list.size(); i++) {
					ball = list.get(i);
					distance = Math.sqrt(Math.pow(ball.x - e.getX(), 2) + Math.pow(ball.y - e.getY(), 2));
					if (distance < (ball.radius)) {
						list.remove(ball);
					}
				}
			}
		});
	}

	public void add() {
		list.add(new Ball());
	}

	public void subtract() {
		if (list.size() > 0)
			list.remove(list.size() - 1); // Remove the last ball
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < list.size(); i++) {
			Ball ball = (Ball) list.get(i); // Get a ball
			g.setColor(ball.color); // Set ball color
			// Check boundaries
			if (ball.x < 0 || ball.x > getWidth()) {
				ball.dx = -ball.dx;
			}
			if (ball.y < 0 || ball.y > getHeight()) {
				ball.dy = -ball.dy;
			}

			hasClash(ball);

			// Adjust ball position
			ball.x += ball.dx;
			ball.y += ball.dy;
			g.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius * 2, ball.radius * 2);

		}
	}

	public void suspend() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}

	public void setDelay(int delay) {
		this.delay = delay;
		timer.setDelay(delay);
	}

}
