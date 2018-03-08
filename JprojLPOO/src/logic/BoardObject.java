package logic;

public class BoardObject {
	protected int Line;
	protected int Col;
	protected char Symbol; 

	public BoardObject(int lin, int column, char symbol) {
		Line = lin;
		Col = column;
		Symbol = symbol;
	}

	public int getLine() {
		return Line;
	}

	public int getCol() {
		return Col;
	}

	public char getSymbol() {
		return Symbol;
	}

	public void setLine(int Line) {
		this.Line = Line;
	}

	public void setCol(int Col) {
		this.Col = Col;
	}

	public void setSymbol(char symbol) {
		Symbol = symbol;
}
}
