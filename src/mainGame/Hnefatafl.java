package mainGame;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import board.Board;
import board.PieceType;
import board.Square;
import players.Bot;
import players.Human;

public class Hnefatafl {

	void show() {
		mainMenu();
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

			// +-----------+----------+
			// | Tipo | Cáracter |
			// +-----------+----------+
			// | Ficha | ⚫︎ |
			// +-----------+----------+
			// | En Blanco | ⠀⠀ |
			// +-----------+----------+

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

	private void newGame() {

		Board mainBoard = new Board();

		Human human = new Human();
		Bot bot = new Bot();

		int i = 1;

		boolean continueGame = true;

		// Controla los turnos
		do {

			System.out.printf("\n--Turno %d--\n", i);
			System.out.printf("Turno de %s\n", i % 2 == 0 ? "Defensor" : "Atacante");
			System.out.println("\n==============================================");
			mainBoard.drawBoard();
			System.out.println("\n==============================================\n");

			if (i % 2 == 0) {
				mainBoard.setBoard(bot.makeMove(mainBoard, i).getBoard());
			} else {
				mainBoard.setBoard(human.makeMove(mainBoard, i).getBoard());
			}

			if (!gameLostBy(mainBoard.getBoard()).equals(PieceType.KING)) {
				continueGame = false;
				System.out.printf("Partida finalizada. Perdedor: %s", gameLostBy(mainBoard.getBoard()));
			}

			i++;

		} while (continueGame);
	}

	private void gameModePlayer() {

		int option;

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Selecciona el modo de juego:");
		System.out.println("1. Player vs. Player");
		System.out.println("2. Player vs. CPU");
		System.out.println("3. CPU vs. CPU");

		System.out.print("\nElige opción:  ");

		option = keyboard.nextInt();

		switch (option) {
		case 1: {
			System.out.println("Player vs Player");
		}
		case 2: {
			System.out.println("Player vs CPU");
		}
		case 3: {
			System.out.println("CPU vs CPU");
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}

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

	private void clearScr() {
		for (int i = 0; i < 5; i++) {
			System.out.println();
		}
	}

}
