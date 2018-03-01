package dkeep.logic;

public class gameObject {
	 int line ;
 int col ;
 char symbol ;

public char getSymbol() {
		return symbol;
	}
	
	 public void setSymbol(char simbolo) {
		 symbol=simbolo;
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
}
