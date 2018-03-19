package logic;

public class BoardObject {
	protected int line;
	protected int col;
	protected char symbol; 

	public BoardObject(int lin, int column, char symb) {
		line = lin;
		col = column;
		symbol = symb;
	}
	public BoardObject(int lin, int column) {
		line = lin;
		col = column;
	}

	public int getLine() {
		return this.line;
	}

	public int getCol() {
		return this.col;
	}

	public char getSymbol() {
		return this.symbol;
	}

	public void setLine(int lne) {
		this.line = lne;
	}

	public void setCol(int cl) {
		this.col = cl;
	}

	public void setSymbol(char symbl) {
		this.symbol = symbl;
}
}
