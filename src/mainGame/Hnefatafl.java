package mainGame;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import board.Board;
import board.PieceType;
import board.Square;

public class Hnefatafl {

	void show() {
		mainMenu();
	}

	private void newGame() {
		Board mainBoard = new Board();
		Board tempBoard = new Board();

		Move move = new Move();

		int i = 1;
		int x, y, fx, fy;

		Pattern pattern = Pattern.compile("(\\d+)-([A-K])\\s(\\d+)-([A-K])");
		Matcher matcher;

		boolean continueGame = true;
		boolean confirmLoop = true;

		String confirmAsk = "";
		String moveAsk = "";

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

		// Controla los turnos
		do {

			do {

				confirmLoop = true;
				System.out.printf("\n--Turno %d--\n", i);
				System.out.printf("Turno de %s\n", i % 2 == 0 ? "Defensor" : "Atacante");
				System.out.println("\n==============================================");
				mainBoard.drawBoard();
				System.out.println("\n==============================================\n");

				System.out.printf("\nElige tu movimiento [ Ej: 6-B 6-C ]:\t", i % 2 == 0);

				moveAsk = keyboard.nextLine();
				moveAsk = moveAsk.toUpperCase();

				matcher = pattern.matcher(moveAsk);

				if (matcher.find()) {

//					System.out.printf("moveAsk: %s\n", moveAsk);

					x = Integer.parseInt(matcher.group(1));
					y = matcher.group(2).charAt(0);
					fx = Integer.parseInt(matcher.group(3));
					fy = matcher.group(4).charAt(0);

//					System.out.printf("%d|%d|%d|%d|%d\n", x, y, fx, fy, i);

					// Igualar para poder hacer luego la comparación
					x--;
					fx--;
					y -= 65;
					fy -= 65;

//					System.out.printf("%d|%d|%d|%d|%d\n", x, y, fx, fy, i);

					tempBoard.copyBoard(mainBoard.getBoard());

					tempBoard.setBoard(move.newMove(tempBoard.getBoard(), x, y, fx, fy, i));

//					System.out.println("\nTEMP\n");
//					tempBoard.drawBoard();
//					System.out.println("\nMAIN\n");
//					mainBoard.drawBoard();

					if (!mainBoard.boardCompareEquals(tempBoard.getBoard())) {

						System.out.println("\n\nVista previa del movimiento:");
						tempBoard.drawBoard();
						System.out.print("\n¿Seguro que quieres hacer este movimiento? [S/N]:  ");

						confirmAsk = keyboard.nextLine();
						confirmAsk = confirmAsk.toUpperCase();

						if (confirmAsk.equals("S")) {

							confirmLoop = false;
							clearScr();
						} else {

							confirmLoop = true;
							clearScr();
						}
					}
				} else {
					// Mensajes de error
					System.out.println("Movimiento no valido.");
					System.out.println("No te he entendido.");
					System.out.println("Intenta escribir el comando similar al del ejemplo.");
					System.out.println("Y además debe estar dentro de los limites.");
				}

			} while (confirmLoop);

			mainBoard.copyBoard(tempBoard.getBoard());
			i++;

			if (gameLostBy(mainBoard.getBoard()) != PieceType.KING) {

				continueGame = false;

				System.out.printf("Partida finalizada. Perdedor: %s", gameLostBy(mainBoard.getBoard()));

			}
		} while (continueGame);

//		System.out.println("SET DE MOVIMIENTOS DE PRUEBA");
//		System.out.printf("\n--- Turno %d: Estado inicial ---\n", i++);
//		boardtest.drawBoard();
//		//// La idea de turno se compondría de los siguientes 3 comandos.
//		clearScr();
//		System.out.printf("\n--- Turno %d Mov. Normal---\n", i++);
//		boardtest.setBoard(blackmove.newMove(boardtest.getBoard(), 4, 0, 4, 3, i));
//		boardtest.drawBoard();

	}

	public PieceType gameLostBy(Square[][] board) {

		int pieceCount;
		// No hay piezas de cada tipo. (Includo el rey)
		for (PieceType piece : PieceType.values()) {

			pieceCount = 0;

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					// Cuenta las piezasgameWon(board)
					if (board[i][j].getPiece().isPresent()) {
						if (board[i][j].getPiece().get().getType() == piece) {
							pieceCount++;
						}
					}

				}
			}

			if (pieceCount == 0) {
				return piece;
			}

		}

		// El rey ha llegado a las esquinas
		if (board[0][0].getPiece().isPresent()) {
			if (board[0][0].getPiece().get().getType().equals(PieceType.KING)) {
				return PieceType.ATTACKER;
			}
		}
		if (board[0][10].getPiece().isPresent()) {
			if (board[0][10].getPiece().get().getType().equals(PieceType.KING)) {
				return PieceType.ATTACKER;
			}
		}
		if (board[10][0].getPiece().isPresent()) {
			if (board[10][0].getPiece().get().getType().equals(PieceType.KING)) {
				return PieceType.ATTACKER;
			}
		}
		if (board[10][10].getPiece().isPresent()) {
			if (board[10][10].getPiece().get().getType().equals(PieceType.KING)) {
				return PieceType.ATTACKER;
			}
		}
		return PieceType.KING;
	}

	private void gameInfo() {
		System.out.println("\n\n\n\n\n\n--Cómo Jugar--\n");

		System.out.println(
				"El Hnefatafl es un juego de mesa muy antiguo.\nSe desarrolla en un tablero de 11 filas y 11 columnas.\nEl juego se compone de dos jugadores, un atacante y un defensor.\n\nEn este juego, el defensor tiene las fichas azules y la ficha\namarilla que es el Rey.\nLa casilla donde se encuentra el Rey se denomina Trono.\n\nEl atacante tiene las fichas rojas y es el que empieza la partida.");
		System.out.println(
				"Las fichas solo pueden moverse en el eje vertical y horizontal, como las torres del ajedrez.");
		System.out.println("\n\n--Cómo Ganar--");
		System.out.println(
				"\nPara ganar siendo Atacante tienes que evitar que el defensor haga que el rey llegue a las esquinas.");
		System.out.println("\nPara ganar siendo Defensor tienes que hacer que tu Ray llegue a alguna de las esquinas.");
		System.out.println("\nCualquier jugador que se quede sin fichas perderá la partidas");
	}

	private void clearScr() {
		for (int i = 0; i < 25; i++) {
			System.out.println();
		}
	}

	private void mainMenu() {

		int option;

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

		do {

			// Mejorar el menú en algún momento
			System.out.println("  _    _             __      _    __ _  \r\n"
					+ " | |  | |           / _|    | |  / _| | \r\n" + " | |__| |_ __   ___| |_ __ _| |_| |_| | \r\n"
					+ " |  __  | '_ \\ / _ \\  _/ _` | __|  _| | \r\n" + " | |  | | | | |  __/ || (_| | |_| | | | \r\n"
					+ " |_|  |_|_| |_|\\___|_| \\__,_|\\__|_| |_| \r\n");

			System.out.println("\n==========================================\n");
			System.out.println("--- Menu ---");
			System.out.println("\n\n1-. Empezar nueva partida\n"); // Empezar partida nueva → Elegir jugadores [H-H ,
																	// H-CPU, CPU-CPU] → (si H-CPU elegir entre Negras o
																	// Blancas o Aleatorio)
			System.out.println("2-. Ayuda\n");
			System.out.println("3-. Salir\n");

			// Dos carácteres "⠀" y el carácter ⚫︎ miden excatamente lo mismo
			// Estos seran las casillas blancas y las fichas respectivamente

//			+-----------+----------+
//			|    Tipo   | Cáracter |
//			+-----------+----------+
//			|   Ficha   |    ⚫︎    |
//			+-----------+----------+
//			| En Blanco |    ⠀⠀    |
//			+-----------+----------+

			System.out.print("\nElige opción:  ");

			option = keyboard.nextInt();

			keyboard.nextLine();

			switch (option) {
			case 1 -> newGame();
			case 2 -> gameInfo();
			case 3 -> System.out.println();
			default -> System.out.println();
			}

			System.out.println("\n==============================================\n");

		} while (option != 3);

		System.out.println("Gracias por jugar");

	}

}
