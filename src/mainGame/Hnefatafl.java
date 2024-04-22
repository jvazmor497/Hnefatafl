package mainGame;

import board.Board;

public class Hnefatafl {

	public static void main(String[] args) {
		new Hnefatafl().show();

	}

	private void show() {
		mainMenu();
	}

	private void mainMenu() {
		boolean exit = true;

		do {
			System.out.println("Hnefatfl");
			System.out.println("-----------------");
			Board boardtest = new Board();
			boardtest.drawBoard();
			exit = false;
		} while (exit);

	}

}
