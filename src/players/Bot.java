package players;

import java.util.ArrayList;
import java.util.Random;

import board.Board;
import board.PieceType;
import board.Square;
import mainGame.Move;

public class Bot extends Player {

	public Board makeMove(Board board, int turn) {

		Random rand = new Random();

		ArrayList<Square> ownedSquares = new ArrayList<Square>();
		ArrayList<Square> validPosition = new ArrayList<Square>();

		boolean otherPiece = true;
		int pieceSel;

		Move move = new Move();
		Board comparableBoard = new Board();
		Board comparableBoard2 = new Board();

		int x, y, fx, fy;

		do {
			comparableBoard.copyBoard(board.getBoard());

			// Busca en que casillas tiene piezas validas
			for (Square[] squarex : board.getBoard()) {
				for (Square squarey : squarex) {
					if (squarey.getPiece().isPresent() && squarey.getPiece().get().getType()
							.equals(turn % 2 == 0 ? PieceType.DEFFENDER : PieceType.ATTACKER)) {
						ownedSquares.add(squarey);
					}
					if (squarey.getPiece().isPresent() && squarey.getPiece().get().getType().equals(PieceType.KING)
							&& turn % 2 == 0) {
						ownedSquares.add(squarey);
					}
				}
			}

			// Seleciona una pieza aleatoria.
			pieceSel = rand.nextInt(ownedSquares.size());

//			System.out.println(ownedSquares.toString());
			// Iguala X e Y a la posicion de esa pieza
			x = ownedSquares.get(pieceSel).getPOSITION().getROW();
			y = ownedSquares.get(pieceSel).getPOSITION().getCOLUMN();

//			System.out.printf("\n|%s|%s|\n", x, y);

			// Comprueba que movimientos puede hacer esa pieza
			for (Square[] squarex : board.getBoard()) {
				for (Square squarey : squarex) {
					comparableBoard2.copyBoard(comparableBoard.getBoard());
//				comparableBoard2.drawBoard();
					comparableBoard2.setBoard(move.newMove(comparableBoard2.getBoard(), x, y,
							squarey.getPOSITION().getROW(), squarey.getPOSITION().getCOLUMN(), turn, true));
//				System.out.println(squarey.getPOSITION().getCOLUMN() + squarey.getPOSITION().getROW());
//				System.out.println(comparableBoard.boardCompareEquals(comparableBoard2.getBoard()));
					if (!comparableBoard2.boardCompareEquals(comparableBoard.getBoard())) {
						validPosition.add(squarey);
					}
				}
			}

//			System.out.println(validPosition.size());
//			System.out.println(validPosition.toString());
			if (validPosition.size() > 0) {
				// Selecciona uno de ellos aleatoriamente
				pieceSel = rand.nextInt(validPosition.size());

				// Iguala FX e FY a la posicion de esa casilla
				fx = validPosition.get(pieceSel).getPOSITION().getROW();
				fy = validPosition.get(pieceSel).getPOSITION().getCOLUMN();

				comparableBoard.setBoard(move.newMove(board.getBoard(), x, y, fx, fy, turn, true));

				move.colorChange(comparableBoard, x, y, fx, fy);
				otherPiece = false;
			} else {
				otherPiece = true;
			}
		} while (otherPiece);
		return comparableBoard;
	}
}
//x, y, squarey.getPOSITION().getROW(), squarey.getPOSITION().getCOLUMN()
//		if () {
//		} else if (x == fx && y == fy) {
//		} else if (isDiagonalMove(x, y, fx, fy)) {
//		} else if (isActualEmpty(board, x, y)) {
//		} else if (!isValidMove(board, x, y, fx, fy)) {
//		} else if (!isUrOwnPiece(board, x, y, turnNum)) {
//		} else if (isSpecialSquare(board, x, y, fx, fy)) {

// Elige uno de ellos aleatoriamiente

// Mueve la pieza al destino

//		do {
//			do {
//				x = rand.nextInt(10);
//				y = rand.nextInt(10);
//			} while (move.isActualEmpty(board.getBoard(), x, y));
//
//			do {
//				fx = rand.nextInt(10);
//				fy = rand.nextInt(10);
//			} while (move.isValidMove(board.getBoard(), x, y, fx, fy));
//			comparableBoard.setBoard(move.newMove(board.getBoard(), x, y, fx, fy, turn, true));
//			System.out.printf("\n%s|%s|%s|%s|\n", x, y, fx, fy);
//		} while (board.boardCompareEquals(comparableBoard.getBoard()));
