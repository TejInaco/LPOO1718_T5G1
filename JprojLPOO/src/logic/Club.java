package logic;

public class Club {
int col;
int line;
char symbol;
	
	
	
	public Club() {
		super(); 
	}

	public int getLine() {
		return this.line;
	}

	public int getCol() {
		return this.col;
	}

	public void setLine(int lin) {
		this.line = lin;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return this.symbol;
	}

}
