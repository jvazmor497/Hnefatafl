package mainGame;

import board.Board;

public class Hnefatafl {

	public static void main(String[] args) {
		new Hnefatafl().show();
	}

	private void show() {
		mainMenu();
	}

	private void newGame() {
		Board boardtest = new Board();
		Move blackmove = new Move();
		System.out.println("SET DE MOVIMIENTOS DE PRUEBA");
		System.out.println("\n--- Turno 1: Estado inicial ---\n");
		boardtest.drawBoard();
		//// La idea de turno se compondría de los siguientes 3 comandos.
		clearScr();
		System.out.println("\n--- Turno 2 Mov. Normal---\n");
		boardtest.setBoard(blackmove.newMove(boardtest.getBoard(), 4, 0, 4, 3));
		boardtest.drawBoard();
		/// ------------
		clearScr();
		System.out.println("\n--- Turno 3 Mov. Fuera---\n");
		boardtest.setBoard(blackmove.newMove(boardtest.getBoard(), 4, 3, 2, 23));
		boardtest.drawBoard();
		/// ------------
		clearScr();
		System.out.println("\n--- Turno 4 Mov. En misma casilla ---\n");
		boardtest.setBoard(blackmove.newMove(boardtest.getBoard(), 4, 3, 4, 3));
		boardtest.drawBoard();
		/// ------------
		clearScr();
		System.out.println("\n--- Turno 5 Mov. Diagonal ---\n");
		boardtest.setBoard(blackmove.newMove(boardtest.getBoard(), 4, 3, 3, 4));
		boardtest.drawBoard();
		/// -----------
		clearScr();
		System.out.println("\n--- Turno 6 Mov. A Casilla Ocupada ---\n");
		boardtest.setBoard(blackmove.newMove(boardtest.getBoard(), 4, 3, 3, 5));
		boardtest.drawBoard();
		/// -----------
		clearScr();
		System.out.println("\n--- Turno 7 Mov. A Matar pieza---\n");
		boardtest.setBoard(blackmove.newMove(boardtest.getBoard(), 6, 0, 6, 3));
		boardtest.drawBoard();
		/// -----------
		clearScr();
		System.out.println("\n--- Turno 8 Nos vamos pal borde---\n");
		boardtest.setBoard(blackmove.newMove(boardtest.getBoard(), 6, 3, 5, 3));
		boardtest.drawBoard();
		/// -----------
		clearScr();
		System.out.println("\n--- Turno 9 Mov.Pal Borde 2---\n");
		boardtest.setBoard(blackmove.newMove(boardtest.getBoard(), 5, 3, 5, 2));
		boardtest.drawBoard();

		System.out.println("\n--- Turno 10 Mov.Pal Borde 3---\n");
		boardtest.setBoard(blackmove.newMove(boardtest.getBoard(), 5, 2, 5, 1));
		boardtest.drawBoard();
		
	}

	private void clearScr() {
		for (int i = 0; i < 2; i++) {
			System.out.println();
		}
	}

	private void mainMenu() {
		boolean exit = false; // Cambiar cuando haga el menú

		do {

			// Mejorar el menú en algún momento

			System.out.println("  _    _             __      _    __ _  \r\n"
					+ " | |  | |           / _|    | |  / _| | \r\n" + " | |__| |_ __   ___| |_ __ _| |_| |_| | \r\n"
					+ " |  __  | '_ \\ / _ \\  _/ _` | __|  _| | \r\n" + " | |  | | | | |  __/ || (_| | |_| | | | \r\n"
					+ " |_|  |_|_| |_|\\___|_| \\__,_|\\__|_| |_| \r\n");

//			System.out.println("\n==========================================\n");
//			System.out.println("--- Menu ---");
//			System.out.println("\n\n1-. Empezar nueva partida\n"); // Empezar partida nueva → Elegir jugadores [H-H ,
//																	// H-CPU, CPU-CPU] → (si H-CPU elegir entre Negras o
//																	// Blancas o Aleatorio)
//			System.out.println("2-. Ayuda\n");
//			System.out.println("3-. Salir\n");

			// Dos carácteres "⠀" y el carácter ⚫︎ miden excatamente lo mismo
			// Estos seran las casillas blancas y las fichas respectivamente

//			+-----------+----------+
//			|    Tipo   | Cáracter |
//			+-----------+----------+
//			|   Ficha   |    ⚫︎    |
//			+-----------+----------+
//			|    Rey    |    ☹︎    |
//			+-----------+----------+
//			| En Blanco |    ⠀⠀    |
//			+-----------+----------+

			System.out.println("\n==============================================\n");
			newGame();
			System.out.println("\n==============================================\n");
		} while (exit);

	}

}
