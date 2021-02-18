package uti;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SierpinskiTriangleFrame extends JFrame {
	static int r = 0, gr = 0, b = 255;
	int num = 0;

	private SierpinskiTrianglePanel trianglePanel = new SierpinskiTrianglePanel(); // To display the pattern

	public SierpinskiTriangleFrame() {
// Panel to hold label, text field, and a button
		JButton minus = new JButton("-");
		JButton plus = new JButton("+");
		
		JPanel panel = new JPanel();
		panel.add(minus);
		panel.add(plus);
// Add a Sierpinski triangle panel to the frame
		add(trianglePanel);
		add(panel, BorderLayout.SOUTH);
// Register a listener
		plus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				num++;
				trianglePanel.setOrder(num);
			}
		}); 
		
		minus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (num != 0) {
					num--;
					trianglePanel.setOrder(num);
				}
			}
		});

	}

}
