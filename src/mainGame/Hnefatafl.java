package mainGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import code.ConsoleInput;

import board.Board;
import board.PieceType;
import board.Square;
import players.Bot;
import players.Human;
import players.Player;

/**
 * La clase "Hnefatafl" representa el juego de mesa, en él que los jugadores se
 * turnan para mover piezas en tablero para proteger o capturar al rey, añade un
 * menú para empezar partidas nuevas, o para elegir si jugar contra la IA o
 * contra otro jugador
 */
public class Hnefatafl {

	/**
	 * La función show llama al resto del juego. En este caso llama a la funcion
	 * mainMenu()
	 */
	void show() {
		mainMenu();
	}

	/**
	 * La funcion mainMenu() muestra un menu con las opciones para empezar un nuevo
	 * juego, mostrar una ayuda, que es la explicación de como jugar, o la opcion de
	 * salir del programa
	 */
	private void mainMenu() {

		int option;

		Scanner keyboard = new Scanner(System.in);
		ConsoleInput console = new ConsoleInput(keyboard);

		do {

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

			option = console.readIntInRange(1, 3);

			switch (option) {
			case 1 -> gameModeSelect();
			case 2 -> gameInfo();
			case 3 -> System.out.println();
			default -> System.out.println();
			}

			System.out.println("\n==============================================\n");

		} while (option != 3);

		System.out.println("Gracias por jugar");

	}

	/**
	 * La función "newGame" en Java controla el juego entre dos jugadores,
	 * alternando turnos y actualizando el tablero de juego hasta que se determina
	 * un ganador.
	 * 
	 * @param player1 Representa al primer jugador del juego.
	 * @param player2 Representa al segundo jugador del juego.
	 */
	private void newGame(Player player1, Player player2) {

		Board mainBoard = new Board();

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
				mainBoard.setBoard(player1.makeMove(mainBoard, i).getBoard());
			} else {
				mainBoard.setBoard(player2.makeMove(mainBoard, i).getBoard());
			}

			// Espera x segundos entre turnos
			try {
				Thread.sleep(1200); // Espera X segundos en milisegundos
			} catch (InterruptedException e) {
				// Manejo de excepción
			}

			if (!gameLostBy(mainBoard.getBoard()).equals(PieceType.KING)) {
				continueGame = false;
				System.out.printf("Partida finalizada.\nPerdedor: %s\nGanador: %s",
						((gameLostBy(mainBoard.getBoard()).equals(PieceType.ATTACKER)) ? "Atacante" : "Defensor"),
						(gameLostBy(mainBoard.getBoard()).equals(PieceType.ATTACKER)) ? "Defensor" : "Atacante");

			}

			i++;

		} while (continueGame);
	}

	/**
	 * La función `gameModeSelect` permite al usuario seleccionar un modo de juego
	 * (Jugador contra Jugador, Jugador contra CPU, CPU contra Jugador o CPU contra
	 * CPU) e inicializa el juego con los jugadores elegidos.
	 */
	private void gameModeSelect() {

		int option;
		List<Player> players = new ArrayList<>();

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		ConsoleInput console = new ConsoleInput(keyboard);

		System.out.println("\nSelecciona el modo de juego:");
		System.out.printf("\n1. %-6s  vs.  %-6s", "Player", "Player");
		System.out.printf("\n2. %-6s  vs.  %-6s", "Player", "CPU");
		System.out.printf("\n3. %-6s  vs.  %-6s", "CPU", "Player");
		System.out.printf("\n4. %-6s  vs.  %-6s", "CPU", "CPU");

		// Elegir opciones
		System.out.print("\nElige opción:  ");
		option = console.readIntInRange(1, 4);

		// Crea el jugador necesario en cada caso
		switch (option) {
		case 1: {
			System.out.println("Player vs Player");
			players.add(new Human());
			players.add(new Human());
			break;
		}
		case 2: {
			System.out.println("Player vs CPU");
			players.add(new Human());
			players.add(new Bot());
			break;
		}
		case 3: {
			System.out.println("CPU vs Player");
			players.add(new Bot());
			players.add(new Human());
			break;
		}
		case 4: {
			System.out.println("CPU vs CPU");
			players.add(new Bot());
			players.add(new Bot());
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}

		// Comienza la partida
		newGame(players.get(0), players.get(1));

	}

	/**
	 * La función `gameInfo` proporciona instrucciones sobre cómo jugar al juego de
	 * mesa Hnefatafl, incluida la configuración del juego, las reglas y las
	 * condiciones para ganar.
	 */
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

	/**
	 * La función `gameLostBy` determina el tipo de pieza que provocó la pérdida del
	 * juego en función de las piezas presentes en el tablero y la posición del rey.
	 * 
	 * @param board El método "gameLostBy" verifica el tablero para determinar qué
	 *              tipo de pieza se ha perdido en el juego. Primero itera sobre
	 *              todos los valores de PieceType y cuenta el número de piezas de
	 *              cada tipo en el tablero.
	 * 
	 * @return El método `gameLostBy` devuelve un valor de tipo `PiezaType`.
	 *         Dependiendo de quien haya perdido la partida
	 */
	private PieceType gameLostBy(Square[][] board) {

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

	// Originalmente limpiaría la pantalla. De momento se queda comentado porque no
	// está en uso
//	private void clearScr() {
//		for (int i = 0; i < 5; i++) {
//			System.out.println();
//		}
//	}

}
