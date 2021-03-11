package uti;

import javax.swing.JFrame;

public class Task3Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 180);
		frame.add(new Task3Panel());
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
