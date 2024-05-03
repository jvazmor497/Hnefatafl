package board;

public class Board {

	Square[][] board;

	public void drawBoard() {

		System.out.println();

		char colChar = 'A';

		// Dibuja las letras de la columna
		System.out.print("  ");
		for (int col = 0; col < board.length; col++) {
			System.out.print(" " + (colChar) + "  ");
			colChar++;
		}

		// Dibuja el Tablero con sus respectivas filas numeradas
		System.out.println();

		for (int row = 0; row < board.length; row++) {
			System.out.printf("%-2d ", (row + 1));
			for (int col = 0; col < board[row].length; col++) {

				System.out.print(board[row][col]);
			}
			System.out.println();
		}

	}

	public Board() {

		// Generamos todas las casillas del tablero
		this.board = new Square[11][11];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				this.board[i][j] = new Square(i, j);
			}
		}

		// Colocamos piezas
		setAttPieces(board);
		setDeffPieces(board);
		setKingPieces(board);

	}

	// Coloca las piezas Atacantes
	private void setAttPieces(Square[][] board) {

		// Arriba
		for (int i = 3; i <= 7; i++) {
			board[0][i].setPiece(new Piece(PieceType.ATTACKER));
		}
		board[1][5].setPiece(new Piece(PieceType.ATTACKER));
		// Izquierda
		for (int i = 3; i <= 7; i++) {
			board[i][0].setPiece(new Piece(PieceType.ATTACKER));
		}
		board[5][1].setPiece(new Piece(PieceType.ATTACKER));
		// Abajo
		for (int i = 3; i <= 7; i++) {
			board[10][i].setPiece(new Piece(PieceType.ATTACKER));
		}
		board[9][5].setPiece(new Piece(PieceType.ATTACKER));
		// Derecha
		for (int i = 3; i <= 7; i++) {
			board[i][10].setPiece(new Piece(PieceType.ATTACKER));
		}
		board[5][9].setPiece(new Piece(PieceType.ATTACKER));
	}

	private void setDeffPieces(Square[][] board) {
		///
		board[3][5].setPiece(new Piece(PieceType.DEFFENDER));
		board[5][3].setPiece(new Piece(PieceType.DEFFENDER));
		board[7][5].setPiece(new Piece(PieceType.DEFFENDER));
		board[5][7].setPiece(new Piece(PieceType.DEFFENDER));
		///
		board[4][4].setPiece(new Piece(PieceType.DEFFENDER));
		board[4][5].setPiece(new Piece(PieceType.DEFFENDER));
		board[4][6].setPiece(new Piece(PieceType.DEFFENDER));
		///
		board[6][4].setPiece(new Piece(PieceType.DEFFENDER));
		board[6][5].setPiece(new Piece(PieceType.DEFFENDER));
		board[6][6].setPiece(new Piece(PieceType.DEFFENDER));
		///
		board[5][4].setPiece(new Piece(PieceType.DEFFENDER));
		board[5][6].setPiece(new Piece(PieceType.DEFFENDER));
	}

	private void setKingPieces(Square[][] board) {
		board[5][5].setPiece(new Piece(PieceType.KING));
	}

	public Square[][] getBoard() {
		return board;
	}

	public void setBoard(Square[][] board) {
		this.board = board;
	}

}
