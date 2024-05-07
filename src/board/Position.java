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
public class Position {

	/**
	 * Posicion X de la posición.
	 */
	final int ROW;

	/**
	 * Cordenada Y de la posición.
	 */
	final int COLUMN;

	/**
	 * Constructor de la clase Posición.
	 */
	public Position(int row, int column) {
		this.ROW = row;
		this.COLUMN = column;
	}

	/**
	 * Devuelve la fila de la posicion actual.
	 */
	public int getROW() {
		return ROW;
	}

	/**
	 * Devuelve la columna de la posicion actual.
	 */
	public int getCOLUMN() {
		return COLUMN;
	}

}
