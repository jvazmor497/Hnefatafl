package board;

public class Position {

	final int ROW;
	final int COLUMN;

	public Position(int row, int column) {
		this.ROW = row;
		this.COLUMN = column;
	}

	public int getROW() {
		return ROW;
	}

	public int getCOLUMN() {
		return COLUMN;
	}

}
