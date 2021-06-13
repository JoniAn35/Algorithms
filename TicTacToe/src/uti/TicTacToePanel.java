package uti;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class TicTacToePanel extends JPanel {
	private boolean xOnTurn = true;
	
	private static int noWin = 0;
	private static int horizontalwin = 1;
	private static int verticalWin = 2;
	private static int leftInclineWin = 3;
	private static int rightInclinedWin = 4;

	private int winningCombination = noWin;
	private int winningI = -1;
	private int winningJ = -1;

	private char[][] board = { 	{ ' ', ' ', ' ' }, 
								{ ' ', ' ', ' ' }, 
								{ ' ', ' ', ' ' }, 
													};

	private double boardMarginRatio = 0.1;
	private double elementMarginRatio = 0.2;
	private int upBoardBorder;
	private int downBoardBorder;
	private int leftBoardBorder;
	private int rightBoardBorder;
	private int squareWidth;
	private int squareHeight;

	public TicTacToePanel() {
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (winningCombination != noWin) {
					return;
				}

				int x = e.getX();
				int y = e.getY();
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (board[i][j] == ' ' 
								&& x > leftBorder(j) && x < rightBorder(j) 
								&& y < downBorder(i) && y>upBorder(i)) {
							board[i][j] = xOnTurn ? 'x' : 'o';
							
							winningCombination = checkForWinner(i, j);

							if (winningCombination > noWin) {
								winningI = i;
								winningJ = j;
								break;
							}
							xOnTurn = !xOnTurn;
							repaint();
						}
					}
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			
		});
	}

	private int checkForWinner(int i, int j) {
		if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
			return horizontalwin;
		} else if (board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
			return verticalWin;
		} else if (i == j && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			return leftInclineWin;
		} else if (i + j == 2 && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
			return rightInclinedWin;
		} else {
			return noWin;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBoard(g);
		if (winningCombination > noWin) {
			drawWinner(g);
		}
	}

	private void drawWinner(Graphics g) {
		Color color = new Color(255, 0, 0, 170);
		g.setColor(color);
		if (winningCombination == horizontalwin) {
			g.drawLine(leftBorder(0), upBorder(winningI) + squareHeight / 2, rightBorder(2),
					upBorder(winningI) + squareHeight / 2);
		} else if (winningCombination == verticalWin) {
			g.drawLine(leftBorder(winningJ) + squareWidth / 2, upBorder(0), leftBorder(winningJ) + squareWidth / 2,
					downBorder(2));
		} else if (winningCombination == leftInclineWin) {
			g.drawLine(leftBorder(0), upBorder(0), rightBorder(2), downBorder(2));
		} else if (winningCombination == rightInclinedWin) {
			g.drawLine(rightBorder(2), upBorder(0), leftBorder(0), downBorder(2));
		}

		g.setColor(Color.BLACK);
	}

	private void drawBoard(Graphics g) {
		upBoardBorder = (int) (boardMarginRatio * getHeight());
		downBoardBorder = (int) (getHeight() - boardMarginRatio * getHeight());
		leftBoardBorder = (int) (boardMarginRatio * getWidth());
		rightBoardBorder = (int) (getWidth() - boardMarginRatio * getWidth());
		squareWidth = (int) ((getWidth() - 2 * boardMarginRatio * getWidth()) / 3);
		squareHeight = (int) ((getHeight() - 2 * boardMarginRatio * getHeight()) / 3);

		for (int i = 1; i < 3; i++) {
			// horizontal lines
			g.drawLine(leftBoardBorder, upBorder(i), rightBoardBorder, upBorder(i));

			// vertical lines
			g.drawLine(i * squareWidth + leftBoardBorder, upBoardBorder, i * squareWidth + leftBoardBorder,
					downBoardBorder);
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 'x') {
					// left diagonal
					g.drawLine((int) (leftBorder(j) + elementMarginRatio * squareWidth),
							(int) (upBorder(i) + elementMarginRatio * squareHeight),
							(int) (rightBorder(j) - elementMarginRatio * squareWidth),
							(int) (downBorder(i) - elementMarginRatio * squareHeight));
					// right diagonal
					g.drawLine((int) (rightBorder(j) - elementMarginRatio * squareWidth),
							(int) (upBorder(i) + elementMarginRatio * squareHeight),
							(int) (leftBorder(j) + elementMarginRatio * squareWidth),
							(int) (downBorder(i) - elementMarginRatio * squareHeight));
				} else if (board[i][j] == 'o') {
					g.drawOval((int) (leftBorder(j) + elementMarginRatio * squareWidth),
							(int) (upBorder(i) + elementMarginRatio * squareHeight),
							(int) (squareWidth - 2 * elementMarginRatio * squareWidth),
							(int) (squareHeight - 2 * elementMarginRatio * squareHeight));
				}
			}
		}
	}

	private int leftBorder(int j) {
		return j * squareWidth + leftBoardBorder;
	}

	private int rightBorder(int j) {
		return (j + 1) * squareWidth + leftBoardBorder;
	}

	private int upBorder(int i) {
		return i * squareHeight + upBoardBorder;
	}

	private int downBorder(int i) {
		return (i + 1) * squareHeight + upBoardBorder;
	}
}
