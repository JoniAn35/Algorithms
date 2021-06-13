package uti;

import javax.swing.JFrame;

public class TicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(400,400);
		frame.add(new TicTacToePanel());
		frame.setTitle("Tic tac toe");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
