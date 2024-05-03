package board;

import java.util.Optional;

public class Square {

	final Position POSITION;

	String color;

	TypeSquares typesquare;

	Optional<Piece> piece = Optional.empty();

	public Square(int row, int column) {

		// POSITION = {}; - Cada vez que se crea una casilla, se crea una nueva
		// posición.

		this.POSITION = new Position(row, column);

		// typesquare = {}; - Establece el tipo de Cuadrado que tiene el tablero

		if ((column == 0 & row == 0) || (column == 10 & row == 0) || (column == 0 & row == 10)
				|| (column == 10 & row == 10)) {
			typesquare = TypeSquares.CORNER;
		} else if (column == 5 & row == 5) {
			typesquare = TypeSquares.THRONE;
		} else {
			typesquare = TypeSquares.REGULAR;
		}

		// color = {}; - Implementa los colores en el tablero

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

	public void setPiece(Optional<Piece> piece) {
		this.piece = piece;
	}

	public void setPiece(Piece piece) {
		this.piece = Optional.of(piece);
	}

	public Position getPOSITION() {
		return POSITION;
	}

	public Optional<Piece> getPiece() {
		return piece;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", color, piece.isPresent() ? piece.get().toString() : "⠀⠀", Colors.RESET);
	}

}
