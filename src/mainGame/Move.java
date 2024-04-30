package mainGame;

import java.util.Optional;

import board.Square;

public class Move {

	Square[][] newMove(Square[][] board, int x, int y, int fx, int fy) {
		if (!isValidMove(board, x, y, fx, fy)) {
			System.out.println(
					"Movimiento no valido.\nNo puedes moverte diagonalmente o había una pieza en la casilla destino.");
		} else if (!isInsideArray(board.length, x, y, fx, fy)) {
			System.out.println("Movimiento no valido.\nNo puedes colocar una pieza fuera del tablero.");
		} else if (!isAPieceInSquare(board, x, y)) {
			System.out
					.println("Movimiento no valido.\nNo puedes colocar tu pieza en la misma casilla en la que estás!");
		} else {
			board[fx][fy].setPiece(board[x][y].getPiece());
			board[x][y].setPiece(Optional.empty());
			System.out.printf("Movimiento valido.\nPieza: %d-%d movida a %d-%d\n", x, y, fx, fy);
		}
		return board;
	}

	boolean isInsideArray(int arrlenght, int x, int y, int fx, int fy) {
		return (((x >= 0) && (x <= arrlenght)) && ((y >= 0) && (y <= arrlenght)) && ((fx >= 0) && (fx <= arrlenght))
				&& ((fy >= 0) && (fy <= arrlenght)));
	}

	boolean isAPieceInSquare(Square[][] board, int x, int y) {
		return (board[x][y].getPiece().isPresent());
	}

	boolean isValidMove(Square[][] board, int x, int y, int fx, int fy) {
		if ((x != fx) && (y == fy)) {
			for (int i = x + 1; i <= fx; i++) {
				if (board[i][y].getPiece().isPresent()) {
					return true;
				}
			}

		} else if ((x == fx) && (y != fy)) {
			for (int i = y + 1; i <= fy; i++) {
				if (board[x][i].getPiece().isPresent()) {
					return false;
				}
			}
		} else {
			return true;
		}
		return true;
	}

}
