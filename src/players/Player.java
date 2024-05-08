package players;

import board.Board;

public abstract class Player {
	
	public abstract Board makeMove(Board board, int turn);
	
}
