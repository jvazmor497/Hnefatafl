package board;

public class Piece {

	PieceType type; // Son de x Tipo

	public Piece(PieceType type) {

		this.type = type;

	}

	public PieceType getType() {
		return type;
	}

	@Override
	public String toString() {
		return String.format("%s%s", (type == PieceType.ATTACKER) ? Colors.LIGHT_RED_TEXT
				: (type == PieceType.DEFFENDER) ? Colors.BLUE_TEXT : Colors.YELLOW_TEXT, "⚫︎");
	}

}
