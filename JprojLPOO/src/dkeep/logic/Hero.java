package dkeep.logic;

public class Hero extends gameObject {
	int line;
	int col;
	char symbol = 'H';

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char simbolo) {
		symbol = simbolo;
	}

	public int getLine() {
		return line;
	}

	public int getCol() {
		return col;
	}

	public void setLine(int linha) {
		line = linha;
	}

	public void setCol(int coluna) {
		col = coluna;
	}

	public Hero(int lin, int column) {
		line = lin;
		col = column;
	}

}
