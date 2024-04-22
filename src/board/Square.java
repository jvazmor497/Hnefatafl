package board;

public class Square {
	
	Position POSITION;
	
	String color;
	
	TypeSquares typesquare;
	
	public Square(Position position) {
		
		// 	POSITION = {};
		
		this.POSITION = position;
		
		//	typesquare = {};
		
		if ((position.column == 0 & position.row == 0) || (position.column == 10 & position.row == 0)
				|| (position.column == 0 & position.row == 10) || (position.column == 10 & position.row == 10)) {
			typesquare = TypeSquares.CORNER;
		} else if (position.column == 5 & position.row == 5) {
			typesquare = TypeSquares.THRONE;
		} else {
			typesquare = TypeSquares.REGULAR;
		}
		
		//	color = {};
		
		color = switch (typesquare) {
		
		case CORNER -> Colors.YELLOW_BG;
		case THRONE -> Colors.RED_BG;
		default -> Colors.WHITE_BG;
	
		};
		
	}
	
	@Override
	public String toString() {
		return String.format("%s   %s", color, Colors.RESET);
	}
	
}
