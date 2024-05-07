package board;

import java.util.Optional;

/**
 *
 * 
 * La clase Square representa las casillas del tablero.
 * 
 * 
 *
 * @author Jose Miguel Vazquez Moreno
 * @version 1.0
 * @since 1.0
 *
 */
public class Square {

	/**
	 * 
	 * Indica la posición de la casilla
	 * 
	 * @see Position
	 */
	final Position POSITION;

	/**
	 * 
	 * Representa el color de fondo de la casilla
	 * 
	 * @see Colors
	 */
	String color;

	/**
	 * 
	 * Representa el tipo de casilla que es
	 * 
	 * @see SquareType
	 */
	SquareType typesquare;

	/**
	 * 
	 * Representa la pieza que hay en la casilla. Esta puede o no estar en la
	 * casilla.
	 * 
	 * @see Piece
	 */
	Optional<Piece> piece;

	/*
	 * Constructor de la clase Square
	 * 
	 * 
	 */
	public Square(int row, int column) {

		/**
		 * 
		 * Cada vez que se crea una casilla, se crea una nueva posición.
		 * 
		 */
		this.POSITION = new Position(row, column);

		/**
		 * 
		 * Coloca una pieza vacía
		 * 
		 */
		this.piece = Optional.empty();

		/**
		 * 
		 * Establece el tipo de casilla que tiene la casilla actual
		 * 
		 */
		if ((column == 0 & row == 0) || (column == 10 & row == 0) || (column == 0 & row == 10)
				|| (column == 10 & row == 10)) {
			typesquare = SquareType.CORNER;
		} else if (column == 5 & row == 5) {
			typesquare = SquareType.THRONE;
		} else {
			typesquare = SquareType.REGULAR;
		}

		/**
		 * 
		 * Implementa los colores en el tablero
		 * 
		 */
		color = switch (typesquare) {
		case CORNER -> Colors.LIGHT_YELLOW_BG;
		case THRONE -> Colors.RED_BG;
		default -> {
			if ((column % 2 == 0 && row % 2 != 0) || (row % 2 == 0 && column % 2 != 0)) {
				yield Colors.BLACK_BG;
			} else {
				yield Colors.WHITE_BG;
			}
		}
		};
	}

	/**
	 * 
	 * Coloca la pieza Optional dada por parámetro en la pieza actual
	 * 
	 */
	public void setPiece(Optional<Piece> piece) {
		this.piece = piece;
	}

	/**
	 * 
	 * Coloca la pieza dada por parámetro en la pieza actual
	 * 
	 */
	public void setPiece(Piece piece) {
		this.piece = Optional.of(piece);
	}

	/**
	 * 
	 * Coloca el color dado por parametro a la pieza actual
	 * 
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * 
	 * Obtiene la posición de la pieza
	 * 
	 */
	public Position getPOSITION() {
		return POSITION;
	}

	/**
	 * 
	 * Obtiene de que tipo es la pieza
	 * 
	 */
	public SquareType getTypesquare() {
		return typesquare;
	}

	/**
	 * 
	 * Obtiene la pieza actual
	 * 
	 */
	public Optional<Piece> getPiece() {
		return piece;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", color, piece.isPresent() ? piece.get().toString() : "⠀⠀", Colors.RESET);
	}

}
