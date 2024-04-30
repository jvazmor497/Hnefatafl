package board;

public class Piece {

	int xpos; // Están en una posicion
	int ypos; // Están en una posicion

	PieceType type; // Son de x Tipo

	public Piece(PieceType type) {

//		this.xpos = row;
//		this.ypos = column;
		this.type = type;

	}
//
//	// Coloca una pieza en un cuadrado
//	public void toSquare(int row, int column) {
//		this.xpos = row;
//		this.ypos = column;
//	}

	@Override
	public String toString() {
		return String.format("%s%s", (type == PieceType.ATTACKER) ? Colors.LIGHT_RED_TEXT
				: (type == PieceType.DEFFENDER) ? Colors.BLUE_TEXT : Colors.YELLOW_TEXT, "⚫︎");
	}

}
