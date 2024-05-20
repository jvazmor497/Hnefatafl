package board;

/**
 *
 * 
 * La clase Piece representa lasa piezas del tablero.
 * 
 * 
 *
 * @author Jose Miguel Vazquez Moreno
 * @version 1.0
 * @since 1.0
 *
 */
public class Piece {

	/**
	 * Las piezas pertenecen a un tipo
	 *
	 *
	 */
	private PieceType type; // Son de x Tipo

	/**
	 * 
	 * Constructor de la clase Piece
	 * 
	 */
	Piece(PieceType type) {

		this.type = type;

	}

	/**
	 * 
	 * Devuelve de que tipo es la pieza actual
	 * 
	 */
	public PieceType getType() {
		return type;
	}

	@Override
	public String toString() {
		return String.format("%s%s", (type == PieceType.ATTACKER) ? Colors.LIGHT_RED_TEXT
				: (type == PieceType.DEFFENDER) ? Colors.BLUE_TEXT : Colors.YELLOW_TEXT, "⚫︎");
	}

}
