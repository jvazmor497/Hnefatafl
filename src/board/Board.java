package board;

/**
 *
 * La clase Board representa el tablero. Esta almacena un array de casillas.
 * Proporciona métodos para modificar el tablero, colocar las piezas al inicio
 * de una nueva partida, y comparar distintos tableros entre si.
 *
 *
 * @author Jose Miguel Vazquez Moreno
 * @version 1.0
 * @since 1.0
 *
 */
public class Board {

	/**
	 * Array de Casillas de la que se compone un tablero
	 */
	private Square[][] board;

	/**
	 *  
	 * Constructor de la clase Board
	 * 
	 */
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

	/**
	 *
	 * Método que pinta el tablero por pantalla.
	 *
	 */
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

	/**
	 * 
	 * Coloca las piezas Atacantes
	 * 
	 */
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

	/**
	 * 
	 * Coloca las piezas Defensivas
	 * 
	 */
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

	/**
	 * 
	 * Coloca la pieza del rey
	 * 
	 */
	private void setKingPieces(Square[][] board) {
		board[5][5].setPiece(new Piece(PieceType.KING));
	}

	/**
	 * 
	 * Obtiene el tablero
	 * 
	 */
	public Square[][] getBoard() {
		return board;
	}

	/**
	 * 
	 * Coloca el tablero actual a el tablero dado por parametro
	 * 
	 */
	public void setBoard(Square[][] board) {
		this.board = board;
	}

	/**
	 * 
	 * Copia el contenido de un tablero dado por parámetro al tablero actual
	 * 
	 */
	public void copyBoard(Square[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				this.board[i][j] = new Square(i, j);
				this.board[i][j].setPiece(board[i][j].getPiece());
			}
		}
	}

	/**
	 * 
	 * Compara casilla por casilla si dos tableros son iguales
	 * 
	 */
	public boolean boardCompareEquals(Board board) {

		Square[][] boardSquares = board.getBoard();

		// Va comprobando casilla por casilla
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				if (!this.board[i][j].getPiece().equals(boardSquares[i][j].getPiece())) {
					return false; // en el momento que se difiera una casilla, devuelve false
				}
			}
		}

		return true; // Si todo fue igual, devuelve true

	}

}
