package board;

import java.util.Arrays;

public class Board {

	Square[][] board = new Square[1][1];

	public void drawBoard() {
		System.out.println(Arrays.deepToString(board).replaceAll("^\\[", "").replaceAll("], ", System.lineSeparator()).replaceAll("\\]\\]", "").replaceAll(", ", "").replaceAll("\n\\[", "").replaceFirst("\\[", ""));
	}

	public Board() {

		this.board = new Square[11][11];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				this.board[i][j] = new Square(i, j);
			}
		}

	}

}
