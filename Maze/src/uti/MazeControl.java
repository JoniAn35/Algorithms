package uti;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MazeControl extends JPanel {

	private MazePanel mazePanel = new MazePanel();

	private JButton findPathBtn = new JButton("Find Path");
	private JButton cleanPathBtn = new JButton("Reset");

	public MazeControl() {

		setLayout(new BorderLayout());
		add(mazePanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.add(findPathBtn);
		buttonPanel.add(cleanPathBtn);

		findPathBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mazePanel.findPath();
			}
		});

		cleanPathBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mazePanel.cleanPath();
			}
		});
	}
}
