package uti;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Task3Panel extends JPanel {
	private JButton sort = new JButton("Sort");
	private JButton shuffle = new JButton("Shuffle");
	private JButton reverse = new JButton("Reverse");
	private JTextField in = new JTextField(10);
	private JTextArea out = new JTextArea(5, 20);

	public Task3Panel() {
		JPanel panel = new JPanel();
		panel.add(sort);
		panel.add(shuffle);
		panel.add(reverse);
		panel.add(in);
		panel.add(out);
		setLayout(new BorderLayout());
		add(in, BorderLayout.PAGE_START);
		add(out, BorderLayout.PAGE_END);
		add(sort, BorderLayout.LINE_START);
		add(shuffle, BorderLayout.CENTER);
		add(reverse, BorderLayout.LINE_END);

		// Task3LinkedList list = new Task3LinkedList();
		LinkedList<String> linkedList = new LinkedList<String>();
		in.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!linkedList.contains(in.getText())) {
						linkedList.add(in.getText());
						out.setText(linkedList.toString());
						in.setText("");
					}
				}
			}
		});
		sort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(linkedList);
				out.setText(linkedList.toString());
			}
		});
		shuffle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.shuffle(linkedList);
				out.setText(linkedList.toString());
			}
		});
		reverse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.reverse(linkedList);
				out.setText(linkedList.toString());
			}
		});
	}

}