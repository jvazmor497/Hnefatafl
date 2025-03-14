package mainGame;

import java.util.Optional;

import board.Board;
import board.Colors;
import board.PieceType;
import board.Square;
import board.SquareType;

/**
 * La clase "Move" contiene métodos para validar y ejecutar movimientos en un tablero de juego,
 * manejando diversas condiciones como verificar los límites del tablero, movimientos de piezas,
 * capturar piezas del oponente y verificar si las piezas son de tu propiedad a la hora de mover.
 * 
 * @author Jose Miguel Vazquez Moreno
 * @version 1.0
 * @since 1.0
 */
public class Move {
	/**
	 * 
	 * El metodo newMove, comprueba que los movimientos proporcionados por
	 * parámetros sean validos y luego, si lo son, mueve las piezas al lugar
	 * indicado. Luego, vuelve a devolver el Array de casillas pasado por parametro
	 * 
	 */
	public Square[][] newMove(Square[][] board, int x, int y, int fx, int fy, int turnNum) {

		if (isNotInsideArray(board.length, x, y, fx, fy)) {
			System.out.println("\nMovimiento no valido.\nDebe estar dentro del array.");
		} else if (x == fx && y == fy) {
			System.out.println("\nMovimiento no valido.\nNo puedes moverte al mismo sitio en el que estás.");
		} else if (isDiagonalMove(x, y, fx, fy)) {
			System.out.println("\nMovimiento no valido.\nNo puedes mover diagonalmente.");
		} else if (isActualEmpty(board, x, y)) {
			System.out.println("\nMovimiento no valido.\nNo puedes mover una casilla vacía.");
		} else if (!isValidMove(board, x, y, fx, fy)) {
			System.out.println("\nMovimiento no valido.\nCasilla ocupada.");
		} else if (!isUrOwnPiece(board, x, y, turnNum)) {
			System.out.println("\nMovimiento no valido.\nLa ficha elegida no es tu ficha");
		} else if (isSpecialSquare(board, x, y, fx, fy)) {
			System.out.println("\nMovimiento no valido.\nLa ficha elegida no se puede mover a un borde");
		} else {
			// Seteamos en la casilla nueva la pieza
			board[fx][fy].setPiece(board[x][y].getPiece());
			// Vaciamos la casilla anterior
			board[x][y].setPiece(Optional.empty());
			// Mandamos par de mensajes por consola
			System.out.printf("\nMovimiento valido.\n");
			// Matamos las piezas necesarias
			killAnotherPiece(board, fx, fy);
			// Comprobamos si ocurre una Victoria
		}
		return board;
	}

	/**
	 * 
	 * El sobrecarga del metodo newMove, comprueba que los movimientos
	 * proporcionados por parámetros sean validos y luego, si lo son, mueve las
	 * piezas al lugar indicado. Luego, vuelve a devolver el Array de casillas
	 * pasado por parametro. Esta sobrecarga hace que no muestre mensajes por pantalla.
	 * 
	 */
	public Square[][] newMove(Square[][] board, int x, int y, int fx, int fy, int turnNum, boolean bot) {
		if (isNotInsideArray(board.length, x, y, fx, fy)) {
		} else if (x == fx && y == fy) {
		} else if (isDiagonalMove(x, y, fx, fy)) {
		} else if (isActualEmpty(board, x, y)) {
		} else if (!isValidMove(board, x, y, fx, fy)) {
		} else if (!isUrOwnPiece(board, x, y, turnNum)) {
		} else if (isSpecialSquare(board, x, y, fx, fy)) {
		} else {
			// Seteamos en la casilla nueva la pieza
			board[fx][fy].setPiece(board[x][y].getPiece());
			// Vaciamos la casilla anterior
			board[x][y].setPiece(Optional.empty());
			// Matamos las piezas necesarias
			killAnotherPiece(board, fx, fy);
			// Comprobamos si ocurre una Victoria
		}
		return board;
	}

	/**
	 * La funcion comprueba que el movimiento desde (x,y) hasta (fx, fy) esté hecho dentro del array.
	 * 
	 * @param boardSize El parametro 'boardSize' representa el tamaño del tablero.
	 * @param x Representa la cordenada x de la posicion original de la ficha
	 * @param y Representa la cordenada y de la posicion original de la ficha
	 * @param fx Representa la cordenada x de la posicion final de la ficha
	 * @param fy Representa la cordenada y de la posicion final de la ficha
	 * @return Devuelve un booleano dependiendo de si el movimiento se está haciendo o no dentro del array.
	 */
	private boolean isNotInsideArray(int boardSize, int x, int y, int fx, int fy) {
		return (((x < 0 || x >= boardSize)) || ((y < 0 || y >= boardSize)) || ((fx < 0 || fx >= boardSize))
				|| ((fy < 0 || fy >= boardSize)));
	}

	/**
	 * Comprueba que no haya piezas durante el camino hacia la casilla final. Se ayuda de la función positionCheck para ello
	 * 
	 * @see positionCheck
	 */
	private boolean isValidMove(Square[][] board, int x, int y, int fx, int fy) {

		MoveType moveType = moveTypeCheck(x, y, fx, fy);
		int distance = Math.max(Math.abs(fx - x), Math.abs(fy - y));

		for (int i = 1; i <= distance; i++) {

			// Retorna si es un movimiento invalido

			if (positionCheck(moveType, board, x, y, i) == null
					|| positionCheck(moveType, board, x, y, i).getPiece().isPresent()) {
				return false;
			}
		}
		// Retorna si el movimiento es valido
		return true;
	}

	/**
	 * 
	 * Determina si un movimiento es diagonal o no es valido
	 * 
	 */
	private boolean isDiagonalMove(int x, int y, int fx, int fy) {

		if (x != fx && y != fy) {
			return true;
		}
		return Math.abs(fx - x) == Math.abs(fy - y);
	}

	/**
	 * 
	 * Comprueba si la casilla pasada por parametro, esta o no vacía
	 * 
	 */
	private boolean isActualEmpty(Square[][] board, int x, int y) {
		return board[x][y].getPiece().isEmpty();
	}

	/**
	 * 
	 * Determina si un movimiento es realizado hacia una casilla especial, en este caso una esquina o el trono
	 * 
	 */
	private boolean isSpecialSquare(Square[][] board, int x, int y, int fx, int fy) {

		if (board[fx][fy].getTypesquare().equals(SquareType.CORNER)
				&& !(board[x][y].getPiece().get().getType().equals(PieceType.KING))
				|| (board[fx][fy].getTypesquare().equals(SquareType.THRONE)
						&& !(board[x][y].getPiece().get().getType().equals(PieceType.KING)))) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 *  Determina la dirección del movimiento en función de las coordenadas
	 *	dadas.
	 * 
	 */
	private MoveType moveTypeCheck(int x, int y, int fx, int fy) {
		if (fy > y) {
			return MoveType.RIGHT;
		} else if (fy < y) {
			return MoveType.LEFT;
		} else if (fx < x) {
			return MoveType.UP;
		} else {
			return MoveType.DOWN;
		}
	}

	/**
	 * 
	 * La función `killAnotherPiece` busca piezas para eliminar en el tablero según el tipo de pieza
	 * actual y las piezas circundantes.
	 * 
	 */
	private void killAnotherPiece(Square[][] board, int x, int y) {
		Square nextSquare;
		Square nextNextSquare;

		// Comprobamos de que tipo somos
		PieceType currentPieceType = board[x][y].getPiece().orElse(null).getType();
		PieceType diffPieceType = PieceType.KING;

		// Si es el rey, cambiamos a ser una pieza defensora, ya que en como esta
		// planteado esta función, nos interesa que la pieza rey funcione igual que si
		// es una pieza defensora

		if (currentPieceType.equals(PieceType.KING)) {
			currentPieceType = PieceType.DEFFENDER;

		}
		// Segun el tipo que sea, devolvemos el tipo contrario a la variable
		// diffPieceType
		diffPieceType = switch (currentPieceType) {
		case ATTACKER: {
			yield PieceType.DEFFENDER;
		}
		case DEFFENDER: {
			yield PieceType.ATTACKER;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + currentPieceType);
		};

		// Hacemos una comprobación de todos los lados a ver si podemos matar alguna
		// pieza
		for (MoveType move : MoveType.values()) { // Recorre todas las direcciones posibles

			nextSquare = positionCheck(move, board, x, y, 1);
			// distinto equipo, continua:
			if (nextSquare != null && nextSquare.getPiece().isPresent()
					&& nextSquare.getPiece().get().getType().equals(diffPieceType)) {
				// Obtiene la siguiente pieza
				nextNextSquare = positionCheck(move, board, x, y, 2);
				// Si la siguiente pieza es una pared, o hayuna pieza y además es del mismo
				// tipo, entonces se machaca
				if ((nextNextSquare == null) || (nextNextSquare != null && nextNextSquare.getPiece().isPresent()
						&& nextNextSquare.getPiece().get().getType().equals(currentPieceType))) {
					// Mensaje de pieza a Machacar
//					System.out.printf("Se ha eliminado la pieza en la posición %d-%s\n",
//							nextSquare.getPOSITION().getROW() + 1, (char) ('A' + nextSquare.getPOSITION().getCOLUMN()));
					// Machaca la pieza
					board[nextSquare.getPOSITION().getROW()][nextSquare.getPOSITION().getCOLUMN()]
							.setPiece(Optional.empty());
				} else {
				}
			}
		}
	}

	/**
	 * 
	 * La funcion 'colorChange' cambia el color del ultimo movimiento y vuelve a pintar el tablero representando ese movimiento
	 * 
	 */
	public void colorChange(Board board, int x, int y, int fx, int fy) {

		Board board2 = new Board();
		Square[][] boardArr;

		board2.copyBoard(board.getBoard());

		boardArr = board2.getBoard();

		boardArr[x][y].setColor(Colors.LIGHT_GREEN_BG);
		boardArr[fx][fy].setColor(Colors.LIGHT_GREEN_BG);

		board2.setBoard(boardArr);

		board2.drawBoard();

	}

	/**
	 * 
	 * Comprueba que hay en el lado que le digamos, el nº de casillas que pasemos
	 * por parametro. Esto sirve para comprobar si hay piezas de por medio en el tablero.
	 * 
	 */
	private Square positionCheck(MoveType posType, Square[][] board, int x, int y, int moves) {

		int opResult;

		// Pasamos el absoluto de moves para que no pueda dar lugar a error
		moves = Math.abs(moves);

		// Comprueba que no va a salir del tablero el movimiento
		// if ((x - moves < 0) || (y - moves < 0) || (x + moves > board.length) || (y +
		// moves > board.length)) {
		// return null;
		// }

		opResult = switch (posType) {
		case RIGHT: // "y+moves";
		{
			yield y + moves;
		}
		case LEFT: // "y-moves";
		{
			yield y - moves;
		}
		case UP: // "x-moves";
		{
			yield x - moves;
		}
		case DOWN:// "x+moves";
		{
			yield x + moves;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + posType);
		};

		if (opResult >= 11 || opResult < 0) {
			return null;
		} else {
			// Si no es una pared devuelve la casilla en concreto
			switch (posType) {

			case RIGHT: // "y-moves";
			case LEFT: // "y+moves";
			{
				return board[x][opResult];
			}

			case UP:// "x+moves";
			case DOWN: // "x-moves";
			{
				return board[opResult][y];
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + posType);
			}
		}
	}

	/**
	 * 
	 * Comprueba si tu pieza te pertenece
	 * 
	 * @param board
	 * 
	 * @param x representa la cordenada X de la pieza elegida en el tablero
	 * @param y representa la cordenada Y de la pieza elegida en el tablero
	 * @param turnNum indica el turno actual. Dependiendo del turno actual debe de ser el turno del jugador atacante o del jugador defensor
	 * @return devuelve un booleano indicando si la pieza es tuya o no
	 * 
	 */
	private boolean isUrOwnPiece(Square[][] board, int x, int y, int turnNum) {

		PieceType TurnOwn = turnNum % 2 == 0 ? PieceType.DEFFENDER : PieceType.ATTACKER;

		// Si es le rey, le pertenece al defensor
		if (board[x][y].getPiece().isPresent() && board[x][y].getPiece().get().getType() == PieceType.KING
				&& TurnOwn.equals(PieceType.DEFFENDER)) {
			return true;
		}

		return board[x][y].getPiece().isPresent() && board[x][y].getPiece().get().getType() == TurnOwn;
	}

}
