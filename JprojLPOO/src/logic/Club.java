package logic;

public class Club {
int Col;
int Line;
char Symbol;
	
	
	
	public Club() {
		super(); 
	}

	public int getLine() {
		return Line;
	}

	public int getCol() {
		return Col;
	}

	public void setLine(int lin) {
		Line = lin;
	}

	public void setCol(int col) {
		Col = col;
	}

	public void setSymbol(char symbol) {
		Symbol = symbol;
	}

	public char getSymbol() {
		return Symbol;
	}

}
