package dkeep.logic;

public class Lever extends gameObject {
	int line;
	int col;
	char symbol = 'k';

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

	public Lever(int lin, int column, char symb) {
		line = lin;
		col = column;
		symbol = symb;
	}
}
