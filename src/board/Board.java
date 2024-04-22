package board;

import java.util.Arrays;

public class Board {
	
	Square[][] board;
	
	public void drawBoard() {
		Arrays.deepToString(board);
	}
	
	public Board() {
	//		board = {{new Square(new Position(0,0))},{new Square(new Position(0,1))}};
	//
	
	}
	
}
