package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Board;
import mainGame.Move;

class MoveTest {

	// Movimientos Validos //
	@Test
	void movimientoVertical() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		boolean isValid;
		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 3;
		int fy = 2;
		int turn = 1;

		// Realizamos Movimiento
		tempBoard.copyBoard(mainBoard.getBoard());

		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn, true));

		isValid = !mainBoard.boardCompareEquals(tempBoard);

		// isValid Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// idValid Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertTrue(isValid);

	}

	@Test
	void movimientoHorizontal() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		boolean isValid;
		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 3;
		int fy = 2;
		int turn = 1;

		// Realizamos Movimiento
		tempBoard.copyBoard(mainBoard.getBoard());

		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn, true));

		isValid = !mainBoard.boardCompareEquals(tempBoard);

		// isValid Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// idValid Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertTrue(isValid);

	}

//	// Movimientos NO Validos //
	@Test
	void movimientoDiagonal() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		boolean isValid;
		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 4;
		int fy = 1;
		int turn = 1;

		// Realizamos Movimiento
		tempBoard.copyBoard(mainBoard.getBoard());

		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn, true));

		isValid = !mainBoard.boardCompareEquals(tempBoard);

		// isValid Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// idValid Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(isValid);
	}

	@Test
	void movimientoTP() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		boolean isValid;
		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 5;
		int fy = 3;
		int turn = 1;

		// Realizamos Movimiento
		tempBoard.copyBoard(mainBoard.getBoard());

		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn, true));

		isValid = !mainBoard.boardCompareEquals(tempBoard);

		// isValid Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// idValid Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(isValid);

	}

	@Test
	void movimientoConFichaDePorMedio() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		boolean isValid;
		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 3;
		int fy = 8;
		int turn = 1;

		// Realizamos Movimiento
		tempBoard.copyBoard(mainBoard.getBoard());

		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn, true));

		isValid = !mainBoard.boardCompareEquals(tempBoard);

		// isValid Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// idValid Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(isValid);

	}

	@Test
	void movimientoACasillaYaOcupada() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		boolean isValid;
		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 3;
		int fy = 5;
		int turn = 1;

		// Realizamos Movimiento
		tempBoard.copyBoard(mainBoard.getBoard());

		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn, true));

		isValid = !mainBoard.boardCompareEquals(tempBoard);

		// isValid Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// idValid Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(isValid);

	}

	@Test
	void movimientoAMismoSitio() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 3;
		int fy = 0;
		int turn = 1;

		boolean isValid;
		// Realizamos Movimiento
		tempBoard.copyBoard(mainBoard.getBoard());

		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn, true));

		isValid = !mainBoard.boardCompareEquals(tempBoard);

		// isValid Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// idValid Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(isValid);

	}

	@Test
	void movimientoACasillaEspecial() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		boolean isValid;
		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 0;
		int fy = 0;
		int turn = 1;

		// Realizamos Movimiento
		tempBoard.copyBoard(mainBoard.getBoard());

		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn, true));

		isValid = !mainBoard.boardCompareEquals(tempBoard);

		// isValid Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// idValid Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(isValid);

	}

	@Test
	void movimientoAfueraDelTablero() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		boolean isValid;
		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 7;
		int y = 0;
		int fx = 12;
		int fy = 0;
		int turn = 1;

		// Realizamos Movimiento
		tempBoard.copyBoard(mainBoard.getBoard());

		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn, true));

		isValid = !mainBoard.boardCompareEquals(tempBoard);

		// isValid Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// idValid Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(isValid);

	}

	@Test
	void movimientoCasillaVacia() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		boolean isValid;
		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 1;
		int y = 1;
		int fx = 1;
		int fy = 2;
		int turn = 1;

		// Realizamos Movimiento
		tempBoard.copyBoard(mainBoard.getBoard());

		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn, true));

		isValid = !mainBoard.boardCompareEquals(tempBoard);

		// isValid Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// idValid Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(isValid);

	}

	@Test
	void movimientoPiezaContraria() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		boolean isValid;
		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 5;
		int y = 3;
		int fx = 5;
		int fy = 2;
		int turn = 1;

		// Realizamos Movimiento
		tempBoard.copyBoard(mainBoard.getBoard());

		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn, true));

		isValid = !mainBoard.boardCompareEquals(tempBoard);

		// isValid Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// idValid Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(isValid);

	}

}
