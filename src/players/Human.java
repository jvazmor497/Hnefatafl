package players;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import board.Board;
import mainGame.Move;

public class Human extends Player {

	@Override
	public Board makeMove(Board board, int turn) {

		Pattern pattern = Pattern.compile("(\\d+)-([A-K])\\s(\\d+)-([A-K])");
		Matcher matcher;

		Move move = new Move();
		Board comparableBoard = new Board();

		String moveAsk = "";
		String confirmAsk = "";

		boolean confirmLoop = true;

		int x, y, fx, fy;

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

		comparableBoard.copyBoard(board.getBoard());
		// move.newMove(tempBoard.getBoard(), x, y, fx, fy, i)

		do {
			confirmLoop = true;

			System.out.printf("\nElige tu movimiento [ Ej: 6-B 6-C ]:\t", turn % 2 == 0);

			moveAsk = keyboard.nextLine();
			moveAsk = moveAsk.toUpperCase();

			matcher = pattern.matcher(moveAsk);

			if (matcher.find()) {

				x = Integer.parseInt(matcher.group(1));
				y = matcher.group(2).charAt(0);
				fx = Integer.parseInt(matcher.group(3));
				fy = matcher.group(4).charAt(0);

				// Igualar para poder hacer luego la comparación
				x--;
				fx--;
				y -= 65;
				fy -= 65;

//			System.out.printf("%d|%d|%d|%d|%d\n", x, y, fx, fy, i);

				comparableBoard.copyBoard(board.getBoard());

				comparableBoard.setBoard(move.newMove(comparableBoard.getBoard(), x, y, fx, fy, turn));

//			System.out.println("\nTEMP\n");
//			tempBoard.drawBoard();
//			System.out.println("\nMAIN\n");
//			mainBoard.drawBoard();

				// Si los Tableros son diferentes, significa que el movimiento se ha podido
				// realizar
				if (!board.boardCompareEquals(comparableBoard)) {

					System.out.println("\n\nVista previa del movimiento:");

					move.colorChange(comparableBoard, x, y, fx, fy);

					System.out.print("\n¿Seguro que quieres hacer este movimiento? [S/N]:  ");

					confirmAsk = keyboard.nextLine();
					confirmAsk = confirmAsk.toUpperCase();

					if (confirmAsk.equals("S")) {
						confirmLoop = false;
					} else {
						confirmLoop = true;
					}
				}

				// Si no se ha escrito bien el comando de movimiento anteriormente
			} else {

				// Mensajes de error
				System.out.println("Movimiento no valido.");
				System.out.println("No te he entendido.");
				System.out.println("Intenta escribir el comando similar al del ejemplo.");
				System.out.println("Y además debe estar dentro de los limites.");
			}
		} while (confirmLoop);

		return comparableBoard;
	}

}
