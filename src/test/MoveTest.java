package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Board;
import mainGame.Move;

class MoveTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	// Movimientos Validos //
	@Test
	void movimientoVertical() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 3;
		int fy = 2;
		int turn = 1;

		System.out.println("-- Vertical --");
		// Realizamos Movimiento
		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn));

		// Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertTrue(mainBoard.wasValid(tempBoard));

	}

	@Test
	void movimientoHorizontal() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 3;
		int fy = 2;
		int turn = 1;

		System.out.println("-- Horizontal --");
		// Realizamos Movimiento
		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn));

		// Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertTrue(mainBoard.wasValid(tempBoard));

	}

	// Movimientos NO Validos //
	@Test
	void movimientoDiagonal() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 4;
		int fy = 1;
		int turn = 1;

		System.out.println("-- Diagonal --");
		// Realizamos Movimiento
		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn));
		// Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertTrue(mainBoard.wasValid(tempBoard));

	}

	@Test
	void movimientoTP() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 5;
		int fy = 3;
		int turn = 1;

		System.out.println("-- TP --");
		// Realizamos Movimiento
		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn));

		// Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(move.wasValid(mainBoard, tempBoard));

	}

	@Test
	void movimientoConFichaDePorMedio() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 3;
		int fy = 8;
		int turn = 1;

		System.out.println("-- De por Medio --");
		// Realizamos Movimiento
		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn));

		// Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(move.wasValid(mainBoard, tempBoard));

	}

	@Test
	void movimientoACasillaYaOcupada() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 3;
		int fy = 5;
		int turn = 1;

		System.out.println("-- Casilla Ocupada --");
		// Realizamos Movimiento
		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn));

		// Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(move.wasValid(mainBoard, tempBoard));

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

		System.out.println("-- Me quedo en el sitio --");
		// Realizamos Movimiento
		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn));

		// Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(move.wasValid(mainBoard, tempBoard));

	}

	@Test
	void movimientoACasillaEspecial() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 3;
		int y = 0;
		int fx = 0;
		int fy = 0;
		int turn = 1;

		System.out.println("-- Casilla Especial --");
		// Realizamos Movimiento
		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn));

		// Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(move.wasValid(mainBoard, tempBoard));

	}

	@Test
	void movimientoAfueraDelTablero() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		Move move = new Move();

		// Inicialización de variables necesarias
		int x = 7;
		int y = 0;
		int fx = 12;
		int fy = 0;
		int turn = 1;

		System.out.println("-- Me voy para afuera --");
		// Realizamos Movimiento
		tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, turn));

		// Dará TRUE si son iguales y el movimiento SI se pudo hacer
		// Dará FALSE si son distintas, y el movimiento NO se pudo hacer
		assertFalse(move.wasValid(mainBoard, tempBoard));

	}

}
